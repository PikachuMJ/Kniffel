//Methoden zum Überprüfen aller kategorien in Kniffel
public class Check
{
    //Method zum Gucken Einser
    static void einser(int[] sortiert)
    {
        for (int j : sortiert)
        {
            if (j == 1)
            {
                Punkte.addPunkte(1);
            } else {
                Punkte.addPunkte(0);
            }
        }
    }
    //Method zum Gucken Zweier
    static void zweier(int[] sortiert)
    {
        for (int j : sortiert)
        {
            if (j == 2)
            {
                Punkte.addPunkte(2);
            } else {
                Punkte.addPunkte(0);
            }
        }
    }
    //Method zum Gucken Dreier
    static void dreier(int[] sortiert)
    {
        for (int j : sortiert)
        {
            if (j == 3)
            {
                Punkte.addPunkte(3);
            } else {
                Punkte.addPunkte(0);
            }
        }
    }
    //Method zum Gucken Vierer
    static void vierer(int[] sortiert)
    {
        for (int j : sortiert)
        {
            if (j == 4)
            {
                Punkte.addPunkte(4);
            } else {
                Punkte.addPunkte(0);
            }
        }
    }
    //Method zum Gucken Fuenfer
    static void fuenfer(int[] sortiert)
    {
        for (int j : sortiert)
        {
            if (j == 5)
            {
                Punkte.addPunkte(5);
            } else {
                Punkte.addPunkte(0);
            }
        }
    }
    //Method zum Gucken Sechser
    static void sechser(int[] sortiert)
    {
        for (int j : sortiert)
        {
            if (j == 6)
            {
                Punkte.addPunkte(6);
            } else {
                Punkte.addPunkte(0);
            }
        }
    }
    //Method zum Gucken Dreierpasch
    static void dreierpasch(int[] sortiert)
    {
        int[] zaehler = new int[6];

        for (int zahl : sortiert)
        {
            zaehler[zahl - 1]++;
        }
        for (int zaehlerstand : zaehler)
        {
            if (zaehlerstand >= 3)
            {
                Punkte.addPunkte(sortiert[0] + sortiert[1] + sortiert[2] + sortiert[3] + sortiert[4]);
            } else {
                Punkte.addPunkte(0);
            }
        }
    }
    //Method zum GuckenViererpasch
    static void viererpasch(int[] sortiert)
    {
        int[] zaehler = new int[6];

        for (int zahl : sortiert)
        {
            zaehler[zahl - 1]++;
        }
        for (int zaehlerstand : zaehler)
        {
            if (zaehlerstand >= 4)
            {
                Punkte.addPunkte(sortiert[0] + sortiert[1] + sortiert[2] + sortiert[3] + sortiert[4]);
            } else {
                Punkte.addPunkte(0);
            }
        }
    }
    //Method zum Gucken FullHouse
    static void fullHouse(int[] sortiert)
    {
        int[] zaehler = new int[6];

        for (int zahl : sortiert)
        {
            zaehler[zahl - 1]++;
        }
        boolean dreiVonEinerArt = false;
        boolean zweiVonEinerArt = false;
        for (int zaehlerstand : zaehler)
        {
            if (zaehlerstand == 3)
            {
                dreiVonEinerArt = true;
            } else if (zaehlerstand == 2)
            {
                zweiVonEinerArt = true;
            }
        }
        if (dreiVonEinerArt && zweiVonEinerArt)
        {
            Punkte.addPunkte(25);
        } else {
            Punkte.addPunkte(0);
        }
    }
    //Method zum Gucken kleine Straße
    static void kleineStrasse(int[] sortiert)
    {
        boolean kleineStrasseGefunden = false;
        for (int i = 0; i < sortiert.length - 3; i++)
        {
            if ((sortiert[i] == 1 && sortiert[i + 1] == 2 && sortiert[i + 2] == 3 && sortiert[i + 3] == 4) ||
                    (sortiert[i] == 2 && sortiert[i + 1] == 3 && sortiert[i + 2] == 4 && sortiert[i + 3] == 5) ||
                    (sortiert[i] == 1 && sortiert[i + 1] == 2 && sortiert[i + 2] == 2 && sortiert[i + 3] == 3) ||
                    (sortiert[i] == 2 && sortiert[i + 1] == 2 && sortiert[i + 2] == 3 && sortiert[i + 3] == 4) ||
                    (sortiert[i] == 2 && sortiert[i + 1] == 3 && sortiert[i + 2] == 3 && sortiert[i + 3] == 4) ||
                    (sortiert[i] == 3 && sortiert[i + 1] == 4 && sortiert[i + 2] == 5 && sortiert[i + 3] == 6))
            {
                kleineStrasseGefunden = true;
                break; // Eine kleine Straße wurde gefunden, breche die Schleife ab
            }
        }
        if (kleineStrasseGefunden)
        {
            Punkte.addPunkte(30);
        } else {
            Punkte.addPunkte(0);
        }
    }

    //Method zum Gucken große Straße
    static void grosseStrasse(int[] sortiert)
    {
        boolean grosseStrasseGefunden = false;
        // Überprüfe, ob die sortierte Reihenfolge die Große Straße ergibt
        if ((sortiert[0] == 1 && sortiert[1] == 2 && sortiert[2] == 3 && sortiert[3] == 4 && sortiert[4] == 5) ||
                (sortiert[0] == 2 && sortiert[1] == 3 && sortiert[2] == 4 && sortiert[3] == 5 && sortiert[4] == 6))
        {
            grosseStrasseGefunden = true;
        }
        if (grosseStrasseGefunden)
        {
            Punkte.addPunkte(40);
        } else {
            Punkte.addPunkte(0);
        }
    }
    //Method zum Gucken Kniffel
    static void kniffel(int[] sortiert)
    {
        int[] zaehler = new int[6];

        for (int zahl : sortiert)
        {
            zaehler[zahl - 1]++;
        }

        for (int zaehlerstand : zaehler)
        {
            if (zaehlerstand == 5)
            {
                Punkte.addPunkte(50);
            } else {
                Punkte.addPunkte(0);
            }
        }

    }
    //Method zum Gucken Chance, also alles addiert
    static void chance(int[] sortiert)
    {
        Punkte.addPunkte(sortiert[0] + sortiert[1] + sortiert[2] + sortiert[3] + sortiert[4]);
    }
}