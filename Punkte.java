//enthält Punktestand
public class Punkte
{
    //Variable für den Punktestand
    static int[] punkteSpieler = new int[8];
    static int[] bonusPunkte = new int[8];
    static int bonusPunkteFinal = 0;
    //Methode für, wenn man die Punkte sehen will, ohne viel zu schreiben
    static String getPunkteSpieler()
    {
        return   punkteSpieler[0] + "\n" +
                 punkteSpieler[1] + "\n" +
                 punkteSpieler[2] + "\n" +
                 punkteSpieler[3] + "\n" +
                 punkteSpieler[4] + "\n" +
                 punkteSpieler[5] + "\n" +
                 punkteSpieler[6] + "\n" +
                 punkteSpieler[7];
    }
    //Methode zum Hinzufügen von Punkten
    static void addPunkte(int addPunkte) {
        int playerIndex = Kniffel.playerPlaying - 1;
        if (playerIndex >= 0 && playerIndex < punkteSpieler.length) {
            punkteSpieler[playerIndex] += addPunkte;
        }
    }
    static void addBonusPunkte(int punkte)
    {
        int playerIndex = Kniffel.playerPlaying - 1;
        if (playerIndex >= 0 && playerIndex < bonusPunkte.length) {
            bonusPunkte[playerIndex] += punkte;
            bonusPunkteFinal += bonusPunkte[playerIndex];

        }
    }
}