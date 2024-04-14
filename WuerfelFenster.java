import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class WuerfelFenster extends JFrame implements ActionListener
{
    //Bilder für checkbox (Haken und X)
    ImageIcon haken = new ImageIcon("checkbox.png");
    ImageIcon X = new ImageIcon("X.png");
    static int wuerfel1 = ((int)((Math.random()) * 6 + 1));
    static int wuerfel2 = ((int)((Math.random()) * 6 + 1));
    static int wuerfel3 = ((int)((Math.random()) * 6 + 1));
    static int wuerfel4 = ((int)((Math.random()) * 6 + 1));
    static int wuerfel5 = ((int)((Math.random()) * 6 + 1));
    JCheckBox[] checkBoxes;
    JButton auswertButton;
    boolean[] checkboxStates;
    int buttonPressCount;
    public AnimierteBorder animierteBorder;
    public
    Timer animationTimer;
    //constructor für WuerfelFenster
    public WuerfelFenster()
    {
        setTitle("Wähle aus, was du behalten willst");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //checkboxen werden initialisiert
        checkBoxes = new JCheckBox[5];
        checkBoxes[0] = new JCheckBox(""+wuerfel1);
        checkBoxes[1] = new JCheckBox(""+wuerfel2);
        checkBoxes[2] = new JCheckBox(""+wuerfel3);
        checkBoxes[3] = new JCheckBox(""+wuerfel4);
        checkBoxes[4] = new JCheckBox(""+wuerfel5);
        //bild für ausgewählt und nicht ausgewählt. Seticon ist das allgemeine bild und selected ist ausgewähltes bild
        for (JCheckBox box : checkBoxes)
        {
            box.setIcon(X);
            box.setSelectedIcon(haken);
        }

        //erstellung des knopfes
        auswertButton = new JButton("Neu würfeln/Weiter");
        auswertButton.addActionListener(this);
        //panels für checkboxen und Knopf erstellen
        JPanel checkBoxPanel = new JPanel(new GridLayout(1, 2));
        for (JCheckBox checkBox : checkBoxes)
        {
            checkBoxPanel.add(checkBox);
        }
        //FlowLayout weil faul
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(auswertButton);
        //hauptPanel erstellen und alles nötige hinzufügen
        JPanel hauptPanel = new JPanel(new BorderLayout());
        hauptPanel.add(checkBoxPanel, BorderLayout.CENTER);
        hauptPanel.add(buttonPanel, BorderLayout.SOUTH);

        animierteBorder = new AnimierteBorder(Color.RED, 5);
        hauptPanel.setBorder(animierteBorder);
        //hauptPanel zum frame hinzufügen + in der Mitte des Bildschirms + sichtbar
        add(hauptPanel);
        setLocationRelativeTo(null);
        //Timer aus dem internet :O
        animationTimer = new Timer(100, e ->
        {
            animierteBorder.nextColor();
            hauptPanel.repaint();
        });
        animationTimer.start();

        setVisible(true);

        //Checkbox zustände erstellen
        checkboxStates = new boolean[5];
        buttonPressCount = 0;
        //sysout je nach Spieler
        switch (Kniffel.playerPlaying) {
            case 1 -> System.out.println("Würfel von " + Kniffel.p1Name + ": " +
                    wuerfel1 + " " + wuerfel2 + " " + wuerfel3 + " " + wuerfel4 + " " + wuerfel5);
            case 2 -> System.out.println("Würfel von " + Kniffel.p2Name + ": " +
                    wuerfel1 + " " + wuerfel2 + " " + wuerfel3 + " " + wuerfel4 + " " + wuerfel5);
            case 3 -> System.out.println("Würfel von " + Kniffel.p3Name + ": " +
                    wuerfel1 + " " + wuerfel2 + " " + wuerfel3 + " " + wuerfel4 + " " + wuerfel5);
            case 4 -> System.out.println("Würfel von " + Kniffel.p4Name + ": " +
                    wuerfel1 + " " + wuerfel2 + " " + wuerfel3 + " " + wuerfel4 + " " + wuerfel5);
            case 5 -> System.out.println("Würfel von " + Kniffel.p5Name + ": " +
                    wuerfel1 + " " + wuerfel2 + " " + wuerfel3 + " " + wuerfel4 + " " + wuerfel5);
            case 6 -> System.out.println("Würfel von " + Kniffel.p6Name + ": " +
                    wuerfel1 + " " + wuerfel2 + " " + wuerfel3 + " " + wuerfel4 + " " + wuerfel5);
            case 7 -> System.out.println("Würfel von " + Kniffel.p7Name + ": " +
                    wuerfel1 + " " + wuerfel2 + " " + wuerfel3 + " " + wuerfel4 + " " + wuerfel5);
            case 8 -> System.out.println("Würfel von " + Kniffel.p8Name + ": " +
                    wuerfel1 + " " + wuerfel2 + " " + wuerfel3 + " " + wuerfel4 + " " + wuerfel5);
            }
    }
    //Methode zum Aktualisieren der checkboxen damit immer die gewürfelten Zahlen angezeigt werden
    void checkboxUpdate(int wuerfel1, int wuerfel2, int wuerfel3, int wuerfel4, int wuerfel5)
    {
        // Aktualisieren der Texte der CheckBoxes
        checkBoxes[0].setText(String.valueOf(wuerfel1));
        checkBoxes[1].setText(String.valueOf(wuerfel2));
        checkBoxes[2].setText(String.valueOf(wuerfel3));
        checkBoxes[3].setText(String.valueOf(wuerfel4));
        checkBoxes[4].setText(String.valueOf(wuerfel5));
    }
    //ActionListener welcher beim evaluateButton bei einem knopfdruck etwas macht
    @Override
    public void actionPerformed(ActionEvent e)
    {
        //Überprüft, ob der Knopf gedrückt wurde bzw welcher knopf gedrückt wurde. Kann ja auch ein anderer sein
        if (e.getSource() == auswertButton)
        {
            for (int i = 0; i < checkBoxes.length; i++)
            {
                checkboxStates[i] = checkBoxes[i].isSelected();
            }
            //erhöht wie oft der Knopf gedrückt wurde
            buttonPressCount++;
            if (buttonPressCount == 2)
            {
                //je nachdem wer spielt, wird eine andere Nachricht angezeigt
                if(Kniffel.maxPlayerCount == 1 && Kniffel.playerPlaying == 1)
                {
                    auswertButton.setText("Runde " +  (Kniffel.AusFenButCount + 1) + " abgeschlossen");
                } else {
                        auswertButton.setText("Finale würfel");
                }
            }
            //wenn der knopf 3-mal gedrückt wurde
            if (buttonPressCount == 3)
            {
                //schließt das Fenster, fügt einen button press für die Knöpfe von AuswahlFenster
                //und AuswahlFenster wird geöffnet
                dispose();
                Kniffel.AusFenButCount++;
                new AuswahlFenster();
            } else {
                    if (buttonPressCount < 3)
                    {
                        //wenn checkbox nicht ausgewählt ist, man diese Zahl also neuwürfeln will löst es aus
                        if (!checkboxStates[0])
                        {
                            wuerfel1 = ((int) ((Math.random()) * 6 + 1));
                        }
                        if (!checkboxStates[1])
                        {
                            wuerfel2 = ((int) ((Math.random()) * 6 + 1));
                        }
                        if (!checkboxStates[2])
                        {
                            wuerfel3 = ((int) ((Math.random()) * 6 + 1));
                        }
                        if (!checkboxStates[3])
                        {
                            wuerfel4 = ((int) ((Math.random()) * 6 + 1));
                        }
                        if (!checkboxStates[4])
                        {
                            wuerfel5 = ((int) ((Math.random()) * 6 + 1));
                        }
                    }
                //Checkbox mit neuen werten aktualisieren, damit auch immer die aktuellen Zahlen angezeigt werden
                checkboxUpdate(wuerfel1, wuerfel2, wuerfel3, wuerfel4, wuerfel5);
                //Wahrscheinlich lasse ich die ausgabe so bis ich was Besseres finde
                switch (Kniffel.playerPlaying) {
                    case 1 -> System.out.println("Würfel von " + Kniffel.p1Name + ": " +
                            wuerfel1 + " " + wuerfel2 + " " + wuerfel3 + " " + wuerfel4 + " " + wuerfel5);
                    case 2 -> System.out.println("Würfel von " + Kniffel.p2Name + ": " +
                            wuerfel1 + " " + wuerfel2 + " " + wuerfel3 + " " + wuerfel4 + " " + wuerfel5);
                    case 3 -> System.out.println("Würfel von " + Kniffel.p3Name + ": " +
                            wuerfel1 + " " + wuerfel2 + " " + wuerfel3 + " " + wuerfel4 + " " + wuerfel5);
                    case 4 -> System.out.println("Würfel von " + Kniffel.p4Name + ": " +
                            wuerfel1 + " " + wuerfel2 + " " + wuerfel3 + " " + wuerfel4 + " " + wuerfel5);
                    case 5 -> System.out.println("Würfel von " + Kniffel.p5Name + ": " +
                            wuerfel1 + " " + wuerfel2 + " " + wuerfel3 + " " + wuerfel4 + " " + wuerfel5);
                    case 6 -> System.out.println("Würfel von " + Kniffel.p6Name + ": " +
                            wuerfel1 + " " + wuerfel2 + " " + wuerfel3 + " " + wuerfel4 + " " + wuerfel5);
                    case 7 -> System.out.println("Würfel von " + Kniffel.p7Name + ": " +
                            wuerfel1 + " " + wuerfel2 + " " + wuerfel3 + " " + wuerfel4 + " " + wuerfel5);
                    case 8 -> System.out.println("Würfel von " + Kniffel.p8Name + ": " +
                            wuerfel1 + " " + wuerfel2 + " " + wuerfel3 + " " + wuerfel4 + " " + wuerfel5);
                }
                StringBuilder punkteAusgabe = new StringBuilder();
                for (int i = 0; i < Kniffel.maxPlayerCount; i++)
                {
                    //gibt, die punkte aller spieler aus. nicht vorhandene Spieler werden ignoriert bzw nicht ausgegeben
                    String playerName = switch (i)
                    {
                        case 0 -> Kniffel.p1Name;
                        case 1 -> Kniffel.p2Name;
                        case 2 -> Kniffel.p3Name;
                        case 3 -> Kniffel.p4Name;
                        case 4 -> Kniffel.p5Name;
                        case 5 -> Kniffel.p6Name;
                        case 6 -> Kniffel.p7Name;
                        case 7 -> Kniffel.p8Name;
                        default -> "Fehler";
                    };
                    punkteAusgabe.append(" Punkte ").append(playerName).append(" ").append(Punkte.punkteSpieler[i]).append("\n");
                }
                System.out.println(punkteAusgabe);
            }
        }
    }
}
