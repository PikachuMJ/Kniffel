import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class AuswahlFenster extends JFrame implements ActionListener
{
    JButton[] buttons;
    boolean[] buttonAvailP1;
    boolean[] buttonAvailP2;
    boolean[] buttonAvailP3;
    boolean[] buttonAvailP4;
    boolean[] buttonAvailP5;
    boolean[] buttonAvailP6;
    boolean[] buttonAvailP7;
    boolean[] buttonAvailP8;


    //constructor AuswahlFenster
    public AuswahlFenster()
    {
        setTitle("Wähle eine Kategorie aus");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Übertragung der buttonAvailability
        this.buttonAvailP1 = Kniffel.buttonAvailP1;
		this.buttonAvailP2 = Kniffel.buttonAvailP2;
        this.buttonAvailP3 = Kniffel.buttonAvailP3;
        this.buttonAvailP4 = Kniffel.buttonAvailP4;
        this.buttonAvailP5 = Kniffel.buttonAvailP5;
        this.buttonAvailP6 = Kniffel.buttonAvailP6;
        this.buttonAvailP7 = Kniffel.buttonAvailP7;
        this.buttonAvailP8 = Kniffel.buttonAvailP8;
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
            //je nachdem welcher spieler spielt, wird etwas anderes benutzt
            boolean keinFehler = true;
            do
            {
                switch (Kniffel.playerPlaying)
                {
                    case 1 -> buttons[i].setVisible(Kniffel.buttonAvailP1[i]);
                    case 2 ->buttons[i].setVisible(Kniffel.buttonAvailP2[i]);
                    case 3 ->buttons[i].setVisible(Kniffel.buttonAvailP3[i]);
                    case 4 ->buttons[i].setVisible(Kniffel.buttonAvailP4[i]);
                    case 5 ->buttons[i].setVisible(Kniffel.buttonAvailP5[i]);
                    case 6 ->buttons[i].setVisible(Kniffel.buttonAvailP6[i]);
                    case 7 ->buttons[i].setVisible(Kniffel.buttonAvailP7[i]);
                    case 8 ->buttons[i].setVisible(Kniffel.buttonAvailP8[i]);
                    default ->
                    {
                        // falls irgendwas falsch laufen sollte (was eig nicht passiert)
                        // wird sich drum gekümmert
                        System.out.println(
                                "Unzulässiger playerPlaying wert: " + Kniffel.playerPlaying);
                        keinFehler = false;
                    }
                }
            } while (!keinFehler);
        }
        //Layout für knöpfe
        setLayout(new GridLayout(13, 1));
        for (JButton button : buttons)
        {
            add(button);
        }
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private boolean[] getCurrPlAvail()
    {
        return switch (Kniffel.playerPlaying)
        {
            case 1 -> buttonAvailP1;
            case 2 -> buttonAvailP2;
            case 3 -> buttonAvailP3;
            case 4 -> buttonAvailP4;
            case 5 -> buttonAvailP5;
            case 6 -> buttonAvailP6;
            case 7 -> buttonAvailP7;
            case 8 -> buttonAvailP8;
            /*
                gibt eine Exception aus,
                wenn einer der oberen Werte nicht existiert
                was bei einem richtigen ablauf nicht passieren sollte
            */
            default -> throw new IllegalStateException(
                    "Unerwarteter Wert " + Kniffel.playerPlaying);
        };
    }
    public void actionPerformed(ActionEvent e)
    {
        //Der gedrückte Knopf wird zu clickedButton hinzugefügt (man weiß von außen nicht welcher knopf es ist)
        JButton clickedButton = (JButton) e.getSource();
        int index = -1;
        //überprüft welcher knopf gedrückt wurde, um die nötigen klauseln auszuführen
        int[] sortiert = {WuerfelFenster.wuerfel1,
                            WuerfelFenster.wuerfel2,
                            WuerfelFenster.wuerfel3,
                            WuerfelFenster.wuerfel4,
                            WuerfelFenster.wuerfel5};
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
        //guckt welcher spieler die ersten 6 knöpfe gedrückt hat
        if(     !buttonAvailP1[0] && !buttonAvailP1[1] &&
                !buttonAvailP1[2] && !buttonAvailP1[3] &&
                !buttonAvailP1[4] && !buttonAvailP1[5] &&
                Punkte.bonusCheck1)
        {
            //wenn die ersten 6 knöpfe, gedrückt wurden,
            // wird die erreichte punktzahl überprüft
            if(Punkte.bonusPunkteFinal >= 63)
            {
                Punkte.addPunkte(Punkte.bonusPunkteFinal);
            }
            Punkte.bonusCheck1 = false;
        }
        if (!buttonAvailP2[0] && !buttonAvailP2[1] &&
                !buttonAvailP2[2] && !buttonAvailP2[3] &&
                !buttonAvailP2[4] && !buttonAvailP2[5] &&
                Punkte.bonusCheck2)
        {
            if(Punkte.bonusPunkteFinal >= 63)
            {
                Punkte.addPunkte(Punkte.bonusPunkteFinal);
            }
            Punkte.bonusCheck2 = false;
        }
        if (!buttonAvailP3[0] && !buttonAvailP3[1] &&
                !buttonAvailP3[2] && !buttonAvailP3[3] &&
                !buttonAvailP3[4] && !buttonAvailP3[5] &&
                Punkte.bonusCheck3)
        {
            if(Punkte.bonusPunkteFinal >= 63)
            {
                Punkte.addPunkte(Punkte.bonusPunkteFinal);
            }
            Punkte.bonusCheck3 = false;

        }
        if (!buttonAvailP4[0] && !buttonAvailP4[1] &&
                !buttonAvailP4[2] && !buttonAvailP4[3] &&
                !buttonAvailP4[4] && !buttonAvailP4[5] &&
                Punkte.bonusCheck4)
        {
            if(Punkte.bonusPunkteFinal >= 63)
            {
                Punkte.addPunkte(Punkte.bonusPunkteFinal);
            }
            Punkte.bonusCheck4 = false;
        }
        if (!buttonAvailP5[0] && !buttonAvailP5[1] &&
                !buttonAvailP5[2] && !buttonAvailP5[3] &&
                !buttonAvailP5[4] && !buttonAvailP5[5] &&
                Punkte.bonusCheck5)
        {
            if(Punkte.bonusPunkteFinal >= 63)
            {
                Punkte.addPunkte(Punkte.bonusPunkteFinal);
            }
            Punkte.bonusCheck5 = false;
        }
        if (!buttonAvailP6[0] && !buttonAvailP6[1] &&
                !buttonAvailP6[2] && !buttonAvailP6[3] &&
                !buttonAvailP6[4] && !buttonAvailP6[5] &&
                Punkte.bonusCheck6)
            {
                if(Punkte.bonusPunkteFinal >= 63)
                {
                    Punkte.addPunkte(Punkte.bonusPunkteFinal);
                }
                Punkte.bonusCheck6 = false;
            }
        if (!buttonAvailP7[0] && !buttonAvailP7[1] &&
                !buttonAvailP7[2] && !buttonAvailP7[3] &&
                !buttonAvailP7[4] && !buttonAvailP7[5] &&
                Punkte.bonusCheck7)
            {
                if(Punkte.bonusPunkteFinal >= 63)
                {
                    Punkte.addPunkte(Punkte.bonusPunkteFinal);
                }
                Punkte.bonusCheck7 = false;
            }
        if (!buttonAvailP8[0] && !buttonAvailP8[1] &&
                !buttonAvailP8[2] && !buttonAvailP8[3] &&
                !buttonAvailP8[4] && !buttonAvailP8[5] &&
                Punkte.bonusCheck8)
        {
            if(Punkte.bonusPunkteFinal >= 63)
            {
                Punkte.addPunkte(Punkte.bonusPunkteFinal);
            }
            Punkte.bonusCheck8 = false;
        }
        for (int i = 0; i < buttons.length; i++)
        {
            if (clickedButton == buttons[i])
            {
                index = i;
                break;
            }
        }
        boolean[] currPlayAvail = getCurrPlAvail();
        //schaut ob der bzw ein knopf noch gedrückt werden kann
        if (currPlayAvail[index])
        {
            /*MessageDialog anzeigen + knopf deaktivieren
            * Allgemein dafür gedacht, um spieler zu zeigen, was er ausgewählt hat,
            * wenn er sich nicht sicher ist
            */
            JOptionPane.showMessageDialog(this, "Du hast " + clickedButton.getText()+ " ausgewählt");
            //knopf kann nicht mehr gedrückt werden (ausgegraut)
            currPlayAvail[index] = false;
            //Knopf verschwindet bzw gelöscht
            clickedButton.setVisible(false);
            //Es wird so lange wiederholt
            //bis jeder Knopf unsichtbar ist
            if (Kniffel.AusFenButCount < Kniffel.lidlLohntSich)
            {
                WuerfelFenster.wuerfel1 = ((int) ((Math.random()) * 6 + 1));
                WuerfelFenster.wuerfel2 = ((int) ((Math.random()) * 6 + 1));
                WuerfelFenster.wuerfel3 = ((int) ((Math.random()) * 6 + 1));
                WuerfelFenster.wuerfel4 = ((int) ((Math.random()) * 6 + 1));
                WuerfelFenster.wuerfel5 = ((int) ((Math.random()) * 6 + 1));
                //Spieler wird gewechselt
                Kniffel.playerPlaying++;
                //wenn der Spieler höher als die am anfang, angeforderte
                //SpielerZahl ist, wird sie wieder auf den ernsten gesetzt
                if (Kniffel.playerPlaying - 1 >= Kniffel.maxPlayerCount) {
                    Kniffel.playerPlaying = 1;
                }
                //Wiederholter Aufruf von WuerfelFenster
                new WuerfelFenster();
                //Dieses Fenster wird geschlossen
                dispose();
            }
            //wenn alle knöpfe, gedrückt wurden, öffnet sich das ErgebnisFenster
            if (Kniffel.AusFenButCount == Kniffel.lidlLohntSich)
            {
                new ErgebnisFenster();
                dispose();
            }
        } else {
            //Passiert eigentlich nicht aber kann zeigen, wenn bestimmte werte nicht funktionieren
            JOptionPane.showMessageDialog(this, "Diese Option wurde schon benutzt");
        }
    }
}
