//enthält Punktestand
public class Punkte
{
    //Variable für den Punktestand
    static int[] punkteSpieler = new int[8];
    static int[] bonusPunkte = new int[8];
    static int bonusPunkteFinal = 0;
    //Methode zum Hinzufügen von Punkten
    static void addPunkte(int addPunkte)
    {
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