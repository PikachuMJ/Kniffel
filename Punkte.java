//enthält Punktestand
public class Punkte
{
    //Variable für den Punktestand
    public static int punkte = 0;
    //Methode für, wenn man die Punkte sehen will, ohne viel zu schreiben
    public static int getPunkte() {
        return punkte;
    }
    //Methode zum Hinzufügen von Punkten
    public static void addPunkte(int addPunkte){
        punkte += addPunkte;
    }
}