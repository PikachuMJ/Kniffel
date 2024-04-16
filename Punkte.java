/*
 * enthält Punktestand
 * enthält bonusPunkte
 */
public class Punkte
{
    static boolean start = false;
    static boolean bonusCheck1 = true;
    static boolean bonusCheck2 = true;
    static boolean bonusCheck3 = true;
    static boolean bonusCheck4 = true;
    static boolean bonusCheck5 = true;
    static boolean bonusCheck6 = true;
    static boolean bonusCheck7 = true;
    static boolean bonusCheck8 = true;
    // Variable für den Punktestand
    static int[] punkteSpieler = new int[8];
    static int[] bonusPunkte = new int[8];
    static int bonusPunkteFinal = 0;
    // Methode zum Hinzufügen von Punkten
    static void addPunkte(int addPunkte)
    {
        // überprüft welcher Spieler die Punkte bekommen soll
        int playerIndex = Kniffel.playerPlaying - 1;
        if (playerIndex >= 0 && playerIndex < punkteSpieler.length)
        {
            punkteSpieler[playerIndex] += addPunkte;
        }
    }
    static void addBonusPunkte(int punkte)
    {
        int playerIndex = Kniffel.playerPlaying - 1;
        if (playerIndex >= 0 && playerIndex < bonusPunkte.length)
        {
            bonusPunkte[playerIndex] += punkte;
            bonusPunkteFinal += bonusPunkte[playerIndex];

        }
    }
}