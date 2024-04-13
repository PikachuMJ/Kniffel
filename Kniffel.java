import java.util.Arrays;
import javax.swing.*;

/**
 * Kniffel
 *
 * @author MAP
 * @version 20240412.40
 */
public class Kniffel
{
    //Arrays speichern die namen der Spieler
    //und der einzelnen button availability
    //cheesyBalls = Anzahl der Knopfdrücke die im AuswahlFenster passieren bzw
    //passieren sollen bis etwas Bestimmtes auslöst
    static String p1Name = "";
    static String p2Name = "";
    static String p3Name = "";
    static String p4Name = "";
    static String p5Name = "";
    static String p6Name = "";
    static String p7Name = "";
    static String p8Name = "";
    static int playerPlaying = 0;
    static int maxPlayerCount = 0;
    static int lidlLohntSich = 0;
    static boolean[] buttonAvailP1 = new boolean[13];
    static boolean[] buttonAvailP2 = new boolean[13];
    static boolean[] buttonAvailP3 = new boolean[13];
    static boolean[] buttonAvailP4 = new boolean[13];
    static boolean[] buttonAvailP5 = new boolean[13];
    static boolean[] buttonAvailP6 = new boolean[13];
    static boolean[] buttonAvailP7 = new boolean[13];
    static boolean[] buttonAvailP8 = new boolean[13];

    //speichert Anzahl der Knopfdrücke die in AuswahlFenster bzw Wuerfelfenster passieren
    static int buttonPressCount2 = 0;

    public static void main(String[] kniffelDings)
    {
        ImageIcon spielerAnzahl   = new ImageIcon("spielerAnzahl.png");

        ImageIcon namenEingabeSp1 = new ImageIcon("namenEingabe1.png");
        ImageIcon namenEingabeSp2 = new ImageIcon("namenEingabe2.png");
        ImageIcon namenEingabeSp3 = new ImageIcon("namenEingabe3.png");
        ImageIcon namenEingabeSp4 = new ImageIcon("namenEingabe4.png");
        ImageIcon namenEingabeSp5 = new ImageIcon("namenEingabe5.png");
        ImageIcon namenEingabeSp6 = new ImageIcon("namenEingabe6.png");
        ImageIcon namenEingabeSp7 = new ImageIcon("namenEingabe7.png");
        ImageIcon namenEingabeSp8 = new ImageIcon("namenEingabe8.png");
        int tolerance = 1;
        do
        {  //Einfache do schleife, zur auswahl der Spieler
            try
            {
                //JOptionPane wäre ein object, deshalb muss es zum string konvertiert werden
                playerPlaying = Integer.parseInt((String)JOptionPane.showInputDialog(null,
                        "Zu wievielt spielen sie? \n (maximal 8 Spieler",
                        "Spieler Anzahl Eingabe", JOptionPane.PLAIN_MESSAGE, spielerAnzahl, null, ""));
            } catch (Exception e)
            {
                if(tolerance > 3)
                {
                System.exit(0);
                }
                JOptionPane.showMessageDialog(null,"Falsche Eingabe", "FehlerAusgabe", JOptionPane.ERROR_MESSAGE);
                playerPlaying = 0;
                tolerance++;
            }
        }while (playerPlaying < 1 || playerPlaying > 8);
        //maxPLayer sind die ausgewählten spieler,
        //playerPlaying verändert sich ständig und ist
        //deshalb für meine zwecke nicht unbedingt gut nutzbar
        // (im Bereich der Vergleiche)
        maxPlayerCount = playerPlaying;
        //setzt alle knöpfe als verfügbar
        Arrays.fill(buttonAvailP1, true);
        Arrays.fill(buttonAvailP2, true);
        Arrays.fill(buttonAvailP3, true);
        Arrays.fill(buttonAvailP4, true);
        Arrays.fill(buttonAvailP5, true);
        Arrays.fill(buttonAvailP6, true);
        Arrays.fill(buttonAvailP7, true);
        Arrays.fill(buttonAvailP8, true);
        //je nach anzahl der spieler
        //müssen verschieden viele
        //knopf drücke passieren.
        //btw den namen hat sich ein Freund von mir ausgedacht :O
        //nichts anderes wie buttonPressCount
        switch(playerPlaying)
        {
            case 1: lidlLohntSich = 13; break;
            case 2: lidlLohntSich = 26; break;
            case 3: lidlLohntSich = 39; break;
            case 4: lidlLohntSich = 52; break;
            case 5: lidlLohntSich = 65; break;
            case 6: lidlLohntSich = 78; break;
            case 7: lidlLohntSich = 91; break;
            case 8: lidlLohntSich = 104; break;
        }
            //spieler wird nach namen gefragt, wenn er mitmacht
            p1Name = (String) JOptionPane.showInputDialog(null,
                    "Spieler 1, geben sie Ihren Namen an",
                    "Spieler 1 Namen Eingabe", JOptionPane.PLAIN_MESSAGE, namenEingabeSp1, null, "");
        if(playerPlaying > 1)
        {
            p2Name = (String)JOptionPane.showInputDialog(null,
                    "Spieler 2, geben sie Ihren Namen an",
                    "Spieler 2 Namen Eingabe", JOptionPane.PLAIN_MESSAGE, namenEingabeSp2, null, "");
        }
        if(playerPlaying > 2)
        {
            p3Name = (String)JOptionPane.showInputDialog(null,
                    "Spieler 3, geben sie Ihren Namen an",
                    "Spieler 3 Namen Eingabe", JOptionPane.PLAIN_MESSAGE, namenEingabeSp3, null, "");
        }
        if(playerPlaying > 3)
        {
            p4Name = (String)JOptionPane.showInputDialog(null,
                    "Spieler 4, geben sie Ihren Namen an",
                    "Spieler 4 Namen Eingabe", JOptionPane.PLAIN_MESSAGE, namenEingabeSp4, null, "");
        }
        if(playerPlaying > 4)
        {
            p5Name = (String)JOptionPane.showInputDialog(null,
                    "Spieler 5, geben sie Ihren Namen an",
                    "Spieler 5 Namen Eingabe", JOptionPane.PLAIN_MESSAGE, namenEingabeSp5, null, "");
        }
        if(playerPlaying > 5)
        {
            p6Name = (String)JOptionPane.showInputDialog(null,
                    "Spieler 6, geben sie Ihren Namen an",
                    "Spieler 6 Namen Eingabe", JOptionPane.PLAIN_MESSAGE, namenEingabeSp6, null, "");
        }
        if(playerPlaying > 6)
        {
            p7Name = (String)JOptionPane.showInputDialog(null,
                    "Spieler 7, geben sie Ihren Namen an",
                    "Spieler 7 Namen Eingabe", JOptionPane.PLAIN_MESSAGE, namenEingabeSp7, null, "");
        }
        if(playerPlaying > 7)
        {
            p8Name = (String)JOptionPane.showInputDialog(null,
                    "Spieler 8, geben sie Ihren Namen an",
                    "Spieler 8 Namen Eingabe", JOptionPane.PLAIN_MESSAGE, namenEingabeSp8, null, "");
        }
        //Player wird auf 1 gesetzt, damit auch der erste anfängt
        playerPlaying = 1;
        new WuerfelFenster();
    }
}
