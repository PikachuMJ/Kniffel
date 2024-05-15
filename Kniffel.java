import javax.swing.*;
import java.util.Arrays;

/**
 * Kniffel
 * lidlLohntSich = Anzahl der Knopfdrücke die im AuswahlFenster passieren bzw
 * es gibt wahrscheinlich mehrere if klauseln, die man
 * verbessern könnte, es soll aber erstmal gut funktionieren.
 * Ob das jetzt eine gute nutzung für mehrere klassen ist,
 * ist was anderes :O aber lerne ja noch
 *
 * @author MAP
 * @version 20240406.84
 */
public class Kniffel {
    // Arrays speichern die namen der Spieler
    // und der einzelnen button availability
    static String[] pNames = new String[8];
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
    static boolean[] aufgeben = new boolean[8];

    // speichert Anzahl der Knopfdrücke die in AuswahlFenster passieren
    static int AusFenButCount = 0;

    public static void main(String[] kniffelDings) {
        new StartMenu();
    }
    public Kniffel() {
        Arrays.fill(Kniffel.aufgeben, false);
        ImageIcon spielerAnzahl = new ImageIcon("spielerAnzahl.png");

        ImageIcon[] namenEingabeBilder = new ImageIcon[]{
                        new ImageIcon("namenEingabe1.png"),
                        new ImageIcon("namenEingabe2.png"),
                        new ImageIcon("namenEingabe3.png"),
                        new ImageIcon("namenEingabe4.png"),
                        new ImageIcon("namenEingabe5.png"),
                        new ImageIcon("namenEingabe6.png"),
                        new ImageIcon("namenEingabe7.png"),
                        new ImageIcon("namenEingabe8.png")
                };
        int toleranz = 1;
        // Einfache do schleife, zur auswahl der Spieler
        do {
            try {
                // JOptionPane wäre ein object, deshalb muss es zum string konvertiert werden. kp wieso
                playerPlaying = Integer.parseInt((String) JOptionPane.showInputDialog(null,
                        "Wie viele Spieler machen mit? \n (maximal 8 Spieler",
                        "Spieler Anzahl Eingabe",
                        JOptionPane.PLAIN_MESSAGE, spielerAnzahl, null, ""));
            } catch (Exception e) {
                if (toleranz > 3) {
                    System.exit(0);
                }
                JOptionPane.showMessageDialog(null,
                        "Falsche Eingabe", "FehlerAusgabe", JOptionPane.ERROR_MESSAGE);
                playerPlaying = 0;
                toleranz++;
            }
        } while (playerPlaying < 1 || playerPlaying > 8);
        // maxPLayer sind die ausgewählten spieler,
        // playerPlaying verändert sich ständig und ist
        maxPlayerCount = playerPlaying;
        // setzt alle knöpfe als verfügbar
        Arrays.fill(buttonAvailP1, true);
        Arrays.fill(buttonAvailP2, true);
        Arrays.fill(buttonAvailP3, true);
        Arrays.fill(buttonAvailP4, true);
        Arrays.fill(buttonAvailP5, true);
        Arrays.fill(buttonAvailP6, true);
        Arrays.fill(buttonAvailP7, true);
        Arrays.fill(buttonAvailP8, true);
        /*
         *je nach anzahl der spieler
         *müssen verschieden viele
         *knopf drücke passieren.
         *btw den namen hat sich ein Freund von mir ausgedacht :O
         *nichts anderes wie buttonPressCount
         */
        switch (playerPlaying) {
            case 1 -> lidlLohntSich = 13;
            case 2 -> lidlLohntSich = 26;
            case 3 -> lidlLohntSich = 39;
            case 4 -> lidlLohntSich = 52;
            case 5 -> lidlLohntSich = 65;
            case 6 -> lidlLohntSich = 78;
            case 7 -> lidlLohntSich = 91;
            case 8 -> lidlLohntSich = 104;
        }
        // wird durch die player gelooped, und nach namen gefragt
        for (int i = 0; i < playerPlaying; i++) {
            String playerName = (String) JOptionPane.showInputDialog(null,
                    "Spieler " + (i + 1) + ", geben sie Ihren Namen an",
                    "Spieler " + (i + 1) + " Namen Eingabe",
                    // Bild je nach spieler
                    JOptionPane.PLAIN_MESSAGE, namenEingabeBilder[i], null, "");
            // Wenn der Name leer ist, wird der Name NULL + spielerZahl gesetzt
            if (playerName == null) {
                playerName = "NULL_" + (i + 1);
            }
            // Name wird hinzugefügt :O
            pNames[i] = playerName;
        }
        // Player wird auf 1 gesetzt, damit auch der erste anfängt
        playerPlaying = 1;
            new WuerfelFenster();
        }
    }