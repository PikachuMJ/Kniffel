import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class ErgebnisFenster extends JFrame implements ActionListener
{
    boolean bonusCheck = true;
    // Bilder für gewinner/verlierer (noch nicht benutzt)
    static ImageIcon Win = new ImageIcon("win.png");
    static ImageIcon Lose = new ImageIcon("lose.png");
    JButton[] buttons;
    boolean[] buttonAvailability;

    //constructor ErgebnisFenster
    public ErgebnisFenster(boolean[] buttonAvailability)
    {
        setTitle("Choose your category");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.buttonAvailability = buttonAvailability;
        //erstellen der Knöpfe
        buttons = new JButton[13];
        buttons[0] = new JButton("Einser");
        buttons[1] = new JButton("Zweier");
        buttons[2] = new JButton("Dreier");
        buttons[3] = new JButton("Vierer");
        buttons[4] = new JButton("Fünfer");
        buttons[5] = new JButton("Sechser");
        buttons[6] = new JButton("Dreierpasch");
        buttons[7] = new JButton("Viererpasch");
        buttons[8] = new JButton("Full House");
        buttons[9] = new JButton("Kleine Straße");
        buttons[10] = new JButton("Große Straße");
        buttons[11] = new JButton("Kniffel");
        buttons[12] = new JButton("Chance");
        //ActionListender jedem knopf hinzufügen
        for (int i = 0; i < buttons.length; i++)
        {
            buttons[i].addActionListener(this);
            // Sichtbarkeit anhand buttonAvailability(true oder false, wenn gedrückt einfach gesagt)
            buttons[i].setVisible(buttonAvailability[i]);
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
        if (clickedButton == buttons[0])
        {
            int[] sortiert = {MyFrame.wuerfel1, MyFrame.wuerfel2, MyFrame.wuerfel3, MyFrame.wuerfel4, MyFrame.wuerfel5};
            Arrays.sort(sortiert);
            Check.einser(sortiert);
        }
        if (clickedButton == buttons[1])
        {
            int[] sortiert = {MyFrame.wuerfel1, MyFrame.wuerfel2, MyFrame.wuerfel3, MyFrame.wuerfel4, MyFrame.wuerfel5};
            Arrays.sort(sortiert);
            Check.zweier(sortiert);
        }
        if (clickedButton == buttons[2])
        {
            int[] sortiert = {MyFrame.wuerfel1, MyFrame.wuerfel2, MyFrame.wuerfel3, MyFrame.wuerfel4, MyFrame.wuerfel5};
            Arrays.sort(sortiert);
            Check.dreier(sortiert);
        }
        if (clickedButton == buttons[3])
        {
            int[] sortiert = {MyFrame.wuerfel1, MyFrame.wuerfel2, MyFrame.wuerfel3, MyFrame.wuerfel4, MyFrame.wuerfel5};
            Arrays.sort(sortiert);
            Check.vierer(sortiert);
        }
        if (clickedButton == buttons[4])
        {
            int[] sortiert = {MyFrame.wuerfel1, MyFrame.wuerfel2, MyFrame.wuerfel3, MyFrame.wuerfel4, MyFrame.wuerfel5};
            Arrays.sort(sortiert);
            Check.fuenfer(sortiert);
        }
        if (clickedButton == buttons[5])
        {
            int[] sortiert = {MyFrame.wuerfel1, MyFrame.wuerfel2, MyFrame.wuerfel3, MyFrame.wuerfel4, MyFrame.wuerfel5};
            Arrays.sort(sortiert);
            Check.sechser(sortiert);
        }
        if (clickedButton == buttons[6])
        {
            int[] sortiert = {MyFrame.wuerfel1, MyFrame.wuerfel2, MyFrame.wuerfel3, MyFrame.wuerfel4, MyFrame.wuerfel5};
            Arrays.sort(sortiert);
            Check.dreierpasch(sortiert);
        }
        if (clickedButton == buttons[7])
        {
            int[] sortiert = {MyFrame.wuerfel1, MyFrame.wuerfel2, MyFrame.wuerfel3, MyFrame.wuerfel4, MyFrame.wuerfel5};
            Arrays.sort(sortiert);
            Check.viererpasch(sortiert);
        }
        if (clickedButton == buttons[8])
        {
            int[] sortiert = {MyFrame.wuerfel1, MyFrame.wuerfel2, MyFrame.wuerfel3, MyFrame.wuerfel4, MyFrame.wuerfel5};
            Arrays.sort(sortiert);
            Check.fullHouse(sortiert);
        }
        if (clickedButton == buttons[9])
        {
            int[] sortiert = {MyFrame.wuerfel1, MyFrame.wuerfel2, MyFrame.wuerfel3, MyFrame.wuerfel4, MyFrame.wuerfel5};
            Arrays.sort(sortiert);
            Check.kleineStrasse(sortiert);
        }
        if (clickedButton == buttons[10])
        {
            int[] sortiert = {MyFrame.wuerfel1, MyFrame.wuerfel2, MyFrame.wuerfel3, MyFrame.wuerfel4, MyFrame.wuerfel5};
            Arrays.sort(sortiert);
            Check.grosseStrasse(sortiert);
        }
        if (clickedButton == buttons[11])
        {
            int[] sortiert = {MyFrame.wuerfel1, MyFrame.wuerfel2, MyFrame.wuerfel3, MyFrame.wuerfel4, MyFrame.wuerfel5};
            Arrays.sort(sortiert);
            Check.kniffel(sortiert);
        }
        if (clickedButton == buttons[12])
        {
            int[] sortiert = {MyFrame.wuerfel1, MyFrame.wuerfel2, MyFrame.wuerfel3, MyFrame.wuerfel4, MyFrame.wuerfel5};
            Arrays.sort(sortiert);
            Check.chance(sortiert);
        }
        if(!buttonAvailability[0] && !buttonAvailability[1] && !buttonAvailability[2] && !buttonAvailability[3] && !buttonAvailability[4] && !buttonAvailability[5] && bonusCheck)
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
        if (buttonAvailability[index])
        {
            //MessageDialog anzeigen + knopf deaktivieren
            JOptionPane.showMessageDialog(this, "You selected " + clickedButton.getText());
            buttonAvailability[index] = false; // Button cannot be clicked again
            clickedButton.setVisible(false); // Hide the button
            //wenn noch mindestens eine möglichkeit zum Drücken existiert
            //wird nochmal gewürfelt bzw alles wiederholt
            if (Kniffel.buttonPressCount2 < 13)
            {
                MyFrame.wuerfel1 = ((int) ((Math.random()) * 6 + 1));
                MyFrame.wuerfel2 = ((int) ((Math.random()) * 6 + 1));
                MyFrame.wuerfel3 = ((int) ((Math.random()) * 6 + 1));
                MyFrame.wuerfel4 = ((int) ((Math.random()) * 6 + 1));
                MyFrame.wuerfel5 = ((int) ((Math.random()) * 6 + 1));
                new MyFrame();
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