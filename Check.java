//Methoden zum Überprüfen aller kategorien in Kniffel
public class Check {
    //Method zum Gucken Einser
    public static void einser(int[] sortiert){
        for (int j : sortiert) {
            if (j == 1) {
                Punkte.addAllgemeinPunkte(1);
                Punkte.addbonusPunkte(1);
            } else {
                Punkte.addAllgemeinPunkte(0);
            }
        }
    }
    //Method zum Gucken Zweier
    public static void zweier(int[] sortiert){
        for (int j : sortiert) {
            if (j == 2){
                Punkte.addAllgemeinPunkte(2);
                Punkte.addbonusPunkte(2);
            } else {
                Punkte.addAllgemeinPunkte(0);
            }
        }
    }
    //Method zum Gucken Dreier
    public static void dreier(int[] sortiert){
        for (int j : sortiert) {
            if (j == 3) {
                Punkte.addAllgemeinPunkte(3);
                Punkte.addbonusPunkte(3);
            } else {
                Punkte.addAllgemeinPunkte(0);
            }
        }
    }
    //Method zum Gucken Vierer
    public static void vierer(int[] sortiert){
        for (int j : sortiert) {
            if (j == 4) {
                Punkte.addAllgemeinPunkte(4);
                Punkte.addbonusPunkte(4);
            } else {
                Punkte.addAllgemeinPunkte(0);
            }
        }
    }
    //Method zum Gucken Fuenfer
    public static void fuenfer(int[] sortiert){
        for (int j : sortiert) {
            if (j == 5) {
                Punkte.addAllgemeinPunkte(5);
                Punkte.addbonusPunkte(5);
            } else {
                Punkte.addAllgemeinPunkte(0);
            }
        }
    }
    //Method zum Gucken Sechser
    public static void sechser(int[] sortiert){
        for (int j : sortiert) {
            if (j == 6) {
                Punkte.addAllgemeinPunkte(6);
                Punkte.addbonusPunkte(6);
            } else {
                Punkte.addAllgemeinPunkte(0);
            }
        }
    }
    public static void bonus (int bonusPunkte){
        if(bonusPunkte >= 63){
            Punkte.addAllgemeinPunkte(35);
            bonusPunkte = -100000;
        }
    }
    //Method zum Gucken Dreierpasch
    public static void dreierpasch(int[] sortiert){
        int[] zaehler = new int[6];

        for (int zahl : sortiert){
            zaehler[zahl - 1]++;
        }
        for (int zaehlerstand : zaehler) {
            if (zaehlerstand >= 3) {
                Punkte.addAllgemeinPunkte(sortiert[0] + sortiert[1] + sortiert[2] + sortiert[3] + sortiert[4]);
            } else {
                Punkte.addAllgemeinPunkte(0);
            }
        }
    }
    //Method zum GuckenViererpasch
    public static void viererpasch(int[] sortiert) {
        int[] zaehler = new int[6];

        for (int zahl : sortiert) {
            zaehler[zahl - 1]++;
        }
        for (int zaehlerstand : zaehler) {
            if (zaehlerstand >= 4) {
                Punkte.addAllgemeinPunkte(sortiert[0] + sortiert[1] + sortiert[2] + sortiert[3] + sortiert[4]);
            } else {
                Punkte.addAllgemeinPunkte(0);
            }
        }
    }
    //Method zum Gucken FullHouse
    public static void fullHouse(int[] sortiert) {
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
            Punkte.addAllgemeinPunkte(25);
        } else {
            Punkte.addAllgemeinPunkte(0);
        }
    }
    //Method zum Gucken kleine Straße
    public static void kleineStrasse(int[] sortiert) {
        for (int i = 0; i < sortiert.length - 1; i++) {
            if (sortiert[i + 1] - sortiert[i] != 1) {
                Punkte.addAllgemeinPunkte(0);
            } else {
                Punkte.addAllgemeinPunkte(30);
            }
        }
    }

    //Method zum Gucken große Straße
    public static void grosseStrasse(int[] sortiert) {
        for (int i = 0; i < sortiert.length - 1; i++) {
            if (sortiert[i + 1] - sortiert[i] != 1) {
                Punkte.addAllgemeinPunkte(0);
            } else {
                Punkte.addAllgemeinPunkte(40);
            }
        }
    }
    //Method zum Gucken Kniffel
    public static void kniffel(int[] sortiert){
        int[] zaehler = new int[6];

        for (int zahl : sortiert) {
            zaehler[zahl - 1]++;
        }

        for (int zaehlerstand : zaehler) {
            if (zaehlerstand == 5) {
                Punkte.addAllgemeinPunkte(50);
            } else {
                Punkte.addAllgemeinPunkte(0);
            }
        }

    }
    //Method zum Gucken Chance, also alles addiert
    public static void chance(int[] sortiert) {
        Punkte.addAllgemeinPunkte(sortiert[0] + sortiert[1] + sortiert[2] + sortiert[3] + sortiert[4]);
    }
}