import java.util.Arrays;

public class Kniffel
{
    //Array speichert Verfügbarkeit der Knöpfe in AuswahlFenster
    //  (hab bis jetzt keine bessere lösung gefunden)
    static boolean[] buttonAvailability = new boolean[13];
    //speichert Anzahl der Knopfdrücke die in MyFrame passieren
    static int buttonPressCount2 = 0;

    public static void main(String[] kniffelDings)
    {
        //setzt alle knöpfe als verfügbar
        Arrays.fill(buttonAvailability, true);
        //allgemein startet alles

        new WuerfelFenster();
    }
}
