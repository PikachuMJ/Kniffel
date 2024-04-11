import java.util.Arrays;

public class Kniffel
{
    //Array speichert Verfügbarkeit der Knöpfe in AuswahlFenster
    //  (hab bis jetzt keine bessere lösung gefunden)
    static boolean[] buttonAvailP1 = new boolean[13];
    static boolean[] buttonAvailP2 = new boolean[13];

    //speichert Anzahl der Knopfdrücke die in MyFrame passieren
    static int buttonPressCount2 = 0;

    public static void main(String[] kniffelDings)
    {
        //setzt alle knöpfe als verfügbar
        Arrays.fill(buttonAvailP1, true);
        Arrays.fill(buttonAvailP2, true);
        //allgemein startet alles

        new WuerfelFenster();
    }
}
