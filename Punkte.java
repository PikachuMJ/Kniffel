//enthält Punktestand
public class Punkte
{
    //Variable für den Punktestand
    public static int allgemeinPunkte = 0;
    public  static int bonusPunkte = 0;
    //Methode für, wenn man die Punkte sehen will, ohne viel zu schreiben
    public static int getAllgemeinPunkte() {
        return allgemeinPunkte;
    }
    //Methode zum Hinzufügen von Punkten
    public static void addPunkte(int addPunkte){
        allgemeinPunkte += addPunkte;
    }
    public static void addbonusPunkte(int addPunkte) {
        bonusPunkte += addPunkte;
    }
}