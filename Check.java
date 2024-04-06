//Methoden zum Überprüfen aller kategorien in Kniffel
public class Check {
    //Method zum Gucken Einser.
    public static void Einser(int[] sortiert){
        for (int j : sortiert) {
            if (j == 1) {
                Punkte.addPunkte(1);
            } else {
                Punkte.addPunkte(0);
            }
        }
    }
    //Method zum Gucken Zweier
    public static void Zweier(int[] sortiert){
        for (int j : sortiert) {
            if (j == 2){
                Punkte.addPunkte(2);
            } else {
                Punkte.addPunkte(0);
            }
        }
    }
    //Method zum Gucken Dreier
    public static void Dreier(int[] sortiert){
        for (int j : sortiert) {
            if (j == 3) {
                Punkte.addPunkte(3);
            } else {
                Punkte.addPunkte(0);
            }
        }
    }
    //Method zum Gucken Vierer
    public static void Vierer(int[] sortiert){
        for (int j : sortiert) {
            if (j == 4) {
                Punkte.addPunkte(4);
            } else {
                Punkte.addPunkte(0);
            }
        }
    }
    //Method zum Gucken Fuenfer
    public static void Fuenfer(int[] sortiert){
        for (int j : sortiert) {
            if (j == 5) {
                Punkte.addPunkte(5);
            } else {
                Punkte.addPunkte(0);
            }
        }
    }
    //Method zum Gucken Sechser
    public static void Sechser(int[] sortiert){
        for (int j : sortiert) {
            if (j == 6) {
                Punkte.addPunkte(6);
            } else {
                Punkte.addPunkte(0);
            }
        }
    }
    //Method zum Gucken Dreierpasch
    public static void Dreierpasch(int[] sortiert){
        int[] zaehler = new int[6];

        for (int zahl : sortiert){
            zaehler[zahl - 1]++;
        }
        for (int zaehlerstand : zaehler) {
            if (zaehlerstand >= 3) {
                Punkte.addPunkte(sortiert[0] + sortiert[1] + sortiert[2] + sortiert[3] + sortiert[4]);
            } else {
                Punkte.addPunkte(0);
            }
        }
    }
    //Method zum GuckenViererpasch
    public static void Viererpasch(int[] sortiert) {
        int[] zaehler = new int[6];

        for (int zahl : sortiert) {
            zaehler[zahl - 1]++;
        }
        for (int zaehlerstand : zaehler) {
            if (zaehlerstand >= 4) {
                Punkte.addPunkte(sortiert[0] + sortiert[1] + sortiert[2] + sortiert[3] + sortiert[4]);
            } else {
                Punkte.addPunkte(0);
            }
        }
    }
    //Method zum Gucken FullHouse
    public static void FullHouse(int[] sortiert) {
        int[] zaehler = new int[6];

        for (int zahl : sortiert) {
            zaehler[zahl - 1]++;
        }
        boolean dreiVonEinerArt = false;
        boolean zweiVonEinerArt = false;
        for (int zaehlerstand : zaehler) {
            if (zaehlerstand == 3) {
                dreiVonEinerArt = true;
            } else if (zaehlerstand == 2){
                zweiVonEinerArt = true;
            }
        }
        if (dreiVonEinerArt && zweiVonEinerArt) {
            Punkte.addPunkte(25);
        } else {
            Punkte.addPunkte(0);
        }
    }
    //Method zum Gucken kleine Straße
    public static void KleineStrasse(int[] sortiert) {
        for (int i = 0; i < sortiert.length - 1; i++) {
            if (sortiert[i + 1] - sortiert[i] != 1) {
                Punkte.addPunkte(0);
            } else {
                Punkte.addPunkte(30);
            }
        }
    }

    //Method zum Gucken große Straße
    public static void GrosseStrasse(int[] sortiert) {
        for (int i = 0; i < sortiert.length - 1; i++) {
            if (sortiert[i + 1] - sortiert[i] != 1) {
                Punkte.addPunkte(0);
            } else {
                Punkte.addPunkte(40);
            }
        }
    }
    //Method zum Gucken Kniffel
    public static void Kniffel(int[] sortiert){
        int[] zaehler = new int[6];

        for (int zahl : sortiert) {
            zaehler[zahl - 1]++;
        }

        for (int zaehlerstand : zaehler) {
            if (zaehlerstand == 5) {
                Punkte.addPunkte(50);
            } else {
                Punkte.addPunkte(0);
            }
        }

    }
    //Method zum Gucken Chance, also alles addiert
    public static void Chance(int[] sortiert) {
        Punkte.addPunkte(sortiert[0] + sortiert[1] + sortiert[2] + sortiert[3] + sortiert[4]);
    }
}
