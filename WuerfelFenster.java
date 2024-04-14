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
        System.out.println("Würfel: "+wuerfel1+" "+wuerfel2+" "+wuerfel3+" "+wuerfel4+" "+ wuerfel5);
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
            for (int i = 0; i < checkBoxes.length; i++) {
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

                    switch (Kniffel.playerPlaying) {
                        case 1 -> auswertButton.setText("Nächster Spieler: " + Kniffel.p2Name);
                        case 2 -> auswertButton.setText("Nächster Spieler: " + Kniffel.p3Name);
                        case 3 -> auswertButton.setText("Nächster Spieler: " + Kniffel.p4Name);
                        case 4 -> auswertButton.setText("Nächster Spieler: " + Kniffel.p5Name);
                        case 5 -> auswertButton.setText("Nächster Spieler: " + Kniffel.p6Name);
                        case 6 -> auswertButton.setText("Nächster Spieler: " + Kniffel.p7Name);
                        case 7 -> auswertButton.setText("Nächster Spieler: " + Kniffel.p8Name);
                    }
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
                System.out.println("Würfel: "+wuerfel1+" "+wuerfel2+" "+wuerfel3+" "+wuerfel4+" "+ wuerfel5);
                System.out.println( " Punkte "+Kniffel.p1Name+ " "+Punkte.punkteSpieler[0]+"\n"+
                                    " Punkte "+Kniffel.p2Name+ " "+Punkte.punkteSpieler[1]+ "\n"+
                                    " Punkte "+Kniffel.p3Name+ " "+Punkte.punkteSpieler[2]+ "\n"+
                                    " Punkte "+Kniffel.p4Name+ " "+Punkte.punkteSpieler[3]+ "\n"+
                                    " Punkte "+Kniffel.p5Name+ " "+Punkte.punkteSpieler[4]+ "\n"+
                                    " Punkte "+Kniffel.p6Name+ " "+Punkte.punkteSpieler[5]+ "\n"+
                                    " Punkte "+Kniffel.p7Name+ " "+Punkte.punkteSpieler[6]+ "\n"+
                                    " Punkte "+Kniffel.p8Name+ " "+Punkte.punkteSpieler[7]);
            }
        }
    }
}
