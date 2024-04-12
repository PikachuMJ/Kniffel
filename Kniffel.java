import java.util.Arrays;
import javax.swing.JOptionPane;

public class Kniffel
{
    //Array speichert Verfügbarkeit der Knöpfe in AuswahlFenster
    //  (hab bis jetzt keine bessere lösung gefunden)
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
    static int cheesyBalls = 0;
    static boolean[] buttonAvailP1 = new boolean[13];
    static boolean[] buttonAvailP2 = new boolean[13];
    static boolean[] buttonAvailP3 = new boolean[13];
    static boolean[] buttonAvailP4 = new boolean[13];
    static boolean[] buttonAvailP5 = new boolean[13];
    static boolean[] buttonAvailP6 = new boolean[13];
    static boolean[] buttonAvailP7 = new boolean[13];
    static boolean[] buttonAvailP8 = new boolean[13];

    //speichert Anzahl der Knopfdrücke die in MyFrame passieren
    static int buttonPressCount2 = 0;

    public static void main(String[] kniffelDings)
    {
        do
        {
            try
            {
                playerPlaying = Integer.parseInt(JOptionPane.showInputDialog(null, "Wie viele Spieler möchten sie?"));
            } catch (Exception e)
            {
                playerPlaying = 0;
            }
        }while (playerPlaying < 1 || playerPlaying > 9);
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
        //allgemein startet alles
        switch(playerPlaying){
            case 1: cheesyBalls = 13; break;
            case 2: cheesyBalls = 26; break;
            case 3: cheesyBalls = 39; break;
            case 4: cheesyBalls = 52; break;
            case 5: cheesyBalls = 65; break;
            case 6: cheesyBalls = 78; break;
            case 7: cheesyBalls = 91; break;
            case 8: cheesyBalls = 104; break;
        }
        p1Name = JOptionPane.showInputDialog("Spieler 1, geben sie ihren Namen an (oder was anderes)");
        if(playerPlaying > 1){
            p2Name = JOptionPane.showInputDialog("Spieler 2, geben sie ihren Namen an (oder was anderes)");
        }
        if(playerPlaying > 2){
            p3Name = JOptionPane.showInputDialog("Spieler 3, geben sie ihren Namen an (oder was anderes)");
        }
        if(playerPlaying > 3){
            p4Name = JOptionPane.showInputDialog("Spieler 4, geben sie ihren Namen an (oder was anderes)");
        }
        if(playerPlaying > 4){
            p5Name = JOptionPane.showInputDialog("Spieler 5, geben sie ihren Namen an (oder was anderes)");
        }
        if(playerPlaying > 5){
            p6Name = JOptionPane.showInputDialog("Spieler 6, geben sie ihren Namen an (oder was anderes)");
        }
        if(playerPlaying > 6){
            p7Name = JOptionPane.showInputDialog("Spieler 7, geben sie ihren Namen an (oder was anderes)");
        }
        if(playerPlaying > 7){
            p8Name = JOptionPane.showInputDialog("Spieler 8, geben sie ihren Namen an (oder was anderes)");
        }
        playerPlaying = 1;
        new WuerfelFenster();
    }
}
