import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class AuswahlFenster extends JFrame implements ActionListener
{
    boolean bonusCheck = true;
    // Bilder für gewinner/verlierer (noch nicht benutzt)
    static ImageIcon Win = new ImageIcon("win.png");
    static ImageIcon Lose = new ImageIcon("lose.png");
    JButton[] buttons;
    boolean[] buttonAvailP1;
    boolean[] buttonAvailP2;


    //constructor AuswahlFenster
    public AuswahlFenster(boolean[] buttonAvailP1, boolean[] buttonAvailP2)
    {
        setTitle("Choose your category");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.buttonAvailP1 = buttonAvailP1;
		this.buttonAvailP2 = buttonAvailP2;
        //erstellen der Knöpfe
        buttons     = new JButton[13];
        buttons[0]  = new JButton("Einser");
        buttons[1]  = new JButton("Zweier");
        buttons[2]  = new JButton("Dreier");
        buttons[3]  = new JButton("Vierer");
        buttons[4]  = new JButton("Fünfer");
        buttons[5]  = new JButton("Sechser");
        buttons[6]  = new JButton("Dreierpasch");
        buttons[7]  = new JButton("Viererpasch");
        buttons[8]  = new JButton("Full House");
        buttons[9]  = new JButton("Kleine Straße");
        buttons[10] = new JButton("Große Straße");
        buttons[11] = new JButton("Kniffel");
        buttons[12] = new JButton("Chance");
        //ActionListender jedem knopf hinzufügen
        for (int i = 0; i < buttons.length; i++)
        {
            buttons[i].addActionListener(this);
            // Sichtbarkeit anhand buttonAvailability
            // (true oder false, wenn gedrückt einfach gesagt)
            buttons[i].setVisible(buttonAvailP1[i]);
        }
        //Layout für knöpfe
        setLayout(new GridLayout(13, 1));
        for (JButton button : buttons)
        {
            add(button);
        }
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        //button[i] wird zu clickedButton hinzugefügt
        JButton clickedButton = (JButton) e.getSource();
        int index = -1;
        //überprüft welcher knopf gedrückt wurde, um die nötigen methoden auszuführen
        //nötigen werte werden rübergesendet
        int[] sortiert = {WuerfelFenster.wuerfel1, WuerfelFenster.wuerfel2, WuerfelFenster.wuerfel3, WuerfelFenster.wuerfel4, WuerfelFenster.wuerfel5};
        Arrays.sort(sortiert);
        if (clickedButton == buttons[0])
        {
            Check.einser(sortiert);
        }
        if (clickedButton == buttons[1])
        {
            Check.zweier(sortiert);
        }
        if (clickedButton == buttons[2])
        {
            Check.dreier(sortiert);
        }
        if (clickedButton == buttons[3])
        {
            Check.vierer(sortiert);
        }
        if (clickedButton == buttons[4])
        {
            Check.fuenfer(sortiert);
        }
        if (clickedButton == buttons[5])
        {
            Check.sechser(sortiert);
        }
        if (clickedButton == buttons[6])
        {
            Check.dreierpasch(sortiert);
        }
        if (clickedButton == buttons[7])
        {
            Check.viererpasch(sortiert);
        }
        if (clickedButton == buttons[8])
        {
            Check.fullHouse(sortiert);
        }
        if (clickedButton == buttons[9])
        {
            Check.kleineStrasse(sortiert);
        }
        if (clickedButton == buttons[10])
        {
            Check.grosseStrasse(sortiert);
        }
        if (clickedButton == buttons[11])
        {
            Check.kniffel(sortiert);
        }
        if (clickedButton == buttons[12])
        {
            Check.chance(sortiert);
        }
        if(!buttonAvailP1[0] && !buttonAvailP1[1] && !buttonAvailP1[2] && !buttonAvailP1[3] && !buttonAvailP1[4] && !buttonAvailP1[5] && bonusCheck)
        {
            Punkte.addbonusPunkte(Punkte.bonusPunkte);
            bonusCheck = false;
        }
        for (int i = 0; i < buttons.length; i++)
        {
            if (clickedButton == buttons[i])
            {
                index = i;
                break;
            }
        }
        //überprüft ob der knopf verfügbar ist
        if (buttonAvailP1[index])
        {
            //MessageDialog anzeigen + knopf deaktivieren
            JOptionPane.showMessageDialog(this, "You selected " + clickedButton.getText());
            //knopf kann nicht mehr gedrückt werden (ausgegraut)
            buttonAvailP1[index] = false;
            //Knopf verschwindet bzw gelöscht
            clickedButton.setVisible(false);
            //wenn noch mindestens eine möglichkeit zum Drücken existiert
            //wird nochmal gewürfelt bzw alles wiederholt
            if (Kniffel.buttonPressCount2 < 13)
            {
                WuerfelFenster.wuerfel1 = ((int) ((Math.random()) * 6 + 1));
                WuerfelFenster.wuerfel2 = ((int) ((Math.random()) * 6 + 1));
                WuerfelFenster.wuerfel3 = ((int) ((Math.random()) * 6 + 1));
                WuerfelFenster.wuerfel4 = ((int) ((Math.random()) * 6 + 1));
                WuerfelFenster.wuerfel5 = ((int) ((Math.random()) * 6 + 1));
                //Wiederholter Aufruf von WuerfelFenster
                new WuerfelFenster();
                //Dieses Fenster wird geschlossen
                dispose();
            }
            System.out.println("Wie oft wurde der Knopf gedrückt: " + Kniffel.buttonPressCount2);
            if (Kniffel.buttonPressCount2 == 13)
            {
                JOptionPane.showMessageDialog(this, "Ergebnis: " + Punkte.getAllgemeinPunkte());
                JOptionPane.showMessageDialog(null, "Gewinner :O", "Mikakika ", JOptionPane.PLAIN_MESSAGE, Win);
                JOptionPane.showMessageDialog(null, "Verlierer :c", "Mikakika", JOptionPane.PLAIN_MESSAGE, Lose);
                dispose();
                System.exit(0);
            }
        } else {
            JOptionPane.showMessageDialog(this, "This option has already been chosen!");
        }
    }
}
