import java.util.Arrays;
import javax.swing.JOptionPane;
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
        do
        {  //Einfache do schleife, zur auswahl der Spieler
            try
            {
                playerPlaying = Integer.parseInt(JOptionPane.showInputDialog(null, "Zu wievielt spielen sie? \n (maximal 8 Spieler"));
            } catch (Exception e)
            {
                playerPlaying = 0;
            }
        }while (playerPlaying < 1 || playerPlaying > 9);
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
        p1Name = JOptionPane.showInputDialog("Spieler 1, geben sie ihren Namen an (oder was anderes)");
        if(playerPlaying > 1)
        {
            p2Name = JOptionPane.showInputDialog("Spieler 2, geben sie ihren Namen an (oder was anderes)");
        }
        if(playerPlaying > 2)
        {
            p3Name = JOptionPane.showInputDialog("Spieler 3, geben sie ihren Namen an (oder was anderes)");
        }
        if(playerPlaying > 3)
        {
            p4Name = JOptionPane.showInputDialog("Spieler 4, geben sie ihren Namen an (oder was anderes)");
        }
        if(playerPlaying > 4)
        {
            p5Name = JOptionPane.showInputDialog("Spieler 5, geben sie ihren Namen an (oder was anderes)");
        }
        if(playerPlaying > 5)
        {
            p6Name = JOptionPane.showInputDialog("Spieler 6, geben sie ihren Namen an (oder was anderes)");
        }
        if(playerPlaying > 6)
        {
            p7Name = JOptionPane.showInputDialog("Spieler 7, geben sie ihren Namen an (oder was anderes)");
        }
        if(playerPlaying > 7)
        {
            p8Name = JOptionPane.showInputDialog("Spieler 8, geben sie ihren Namen an (oder was anderes)");
        }
        //Player wird auf 1 gesetzt, damit auch der erste anfängt
        playerPlaying = 1;
        new WuerfelFenster();
    }
}
