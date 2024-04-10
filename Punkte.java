//enthält Punktestand
public class Punkte
{
    //Variable für den Punktestand
    static int allgemeinPunkte = 0;
    static int bonusPunkte = 0;
    //Methode für, wenn man die Punkte sehen will, ohne viel zu schreiben
    static int getAllgemeinPunkte()
    {
        return allgemeinPunkte;
    }
    //Methode zum Hinzufügen von Punkten
    static void addPunkte(int addPunkte)
    {
        allgemeinPunkte += addPunkte;
    }
    static void addbonusPunkte(int addPunkte)
    {
        bonusPunkte += addPunkte;
    }
}