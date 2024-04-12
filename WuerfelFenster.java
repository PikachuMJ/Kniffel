import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class WuerfelFenster extends JFrame implements ActionListener
{
    //Bilder für checkbox (Hacken und X)
    ImageIcon wBildC = new ImageIcon("checkbox.png");
    ImageIcon X = new ImageIcon("X.png");
    static int wuerfel1 = ((int)((Math.random()) * 6 + 1));
    static int wuerfel2 = ((int)((Math.random()) * 6 + 1));
    static int wuerfel3 = ((int)((Math.random()) * 6 + 1));
    static int wuerfel4 = ((int)((Math.random()) * 6 + 1));
    static int wuerfel5 = ((int)((Math.random()) * 6 + 1));
    JCheckBox[] checkBoxes;
    JButton evaluateButton;
    boolean[] checkboxStates;
    int buttonPressCount;
    //constructor für WuerfelFenster
    public WuerfelFenster()
    {
        setTitle("Wähle aus was du behalten willst");
        setSize(400, 400);
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
            box.setSelectedIcon(wBildC);
        }

        //erstellung des knopfes
        evaluateButton = new JButton("Neu würfeln/Weiter");
        evaluateButton.addActionListener(this);
        //panels für checkboxen und Knopf erstellen
        JPanel checkBoxPanel = new JPanel(new GridLayout(1, 2));
        for (JCheckBox checkBox : checkBoxes)
        {
            checkBoxPanel.add(checkBox);
        }
        //FlowLayout weil faul
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(evaluateButton);
        //mainPanel erstellen und alles nötige hinzufügen
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(checkBoxPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        //mainPanel zum frame hinzufügen + sichtbar
        add(mainPanel);
        setLocationRelativeTo(null);
        setVisible(true);

        //Checkbox zustände erstellen
        checkboxStates = new boolean[5];
        buttonPressCount = 0;
        System.out.println("Würfel: "+wuerfel1+" "+wuerfel2+" "+wuerfel3+" "+wuerfel4+" "+ wuerfel5);
    }
    //Methode zum Aktualisieren der checkboxen damit immer die gewürfelten Zahlen angezeigt werden
    void checkboxUpdate(int wuerfel1, int wuerfel2, int wuerfel3, int wuerfel4, int wuerfel5) {
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
        if (e.getSource() == evaluateButton)
        {
            //erhöht wie oft der Knopf gedrückt wurde
            buttonPressCount++;
            if (buttonPressCount == 2)
            {
                //Text vom Knopf ändert sich nach dem dritten wurf
                evaluateButton.setText("Beenden");
            }
            //wenn der knopf 3-mal gedrückt wurde
            if (buttonPressCount == 3)
            {
                //schließt das Fenster, fügt einen button press für die Knöpfe von AuswahlFenster
                //und AuswahlFenster wird geöffnet
                dispose();
                Kniffel.buttonPressCount2++;
                // rüberschicken der button availability zum AuswahlFenster
                new AuswahlFenster();
            } else {

                    //Messagebox mit den Checkbox-Zuständen anzeigen
                    if (buttonPressCount < 3)
                    {;
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
                //Placeholder ausgabe
                System.out.println("Würfel: "+wuerfel1+" "+wuerfel2+" "+wuerfel3+" "+wuerfel4+" "+ wuerfel5);
                System.out.println( " Punkte Spieler 1: "+Punkte.punkteSpieler[0] + " \n"+
                                    " Punkte Spieler 2: "+Punkte.punkteSpieler[1]+ "\n"+
                                    " Punkte Spieler 3: "+Punkte.punkteSpieler[2]+ "\n"+
                                    " Punkte Spieler 4: "+Punkte.punkteSpieler[3]+ "\n"+
                                    " Punkte Spieler 5: "+Punkte.punkteSpieler[4]+ "\n"+
                                    " Punkte Spieler 6: "+Punkte.punkteSpieler[5]+ "\n"+
                                    " Punkte Spieler 7: "+Punkte.punkteSpieler[6]+ "\n"+
                                    " Punkte Spieler 8: "+Punkte.punkteSpieler[7]);
            }
        }
    }
}
