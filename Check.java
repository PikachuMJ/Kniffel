//Methoden zum Überprüfen aller kategorien in Kniffel
/*  erklärung zur for each schleife, da ich sie hier oft benutze
 *  allgemeine syntax: for (Datentyp element : sammlung)
 * bei einem array mit zb 5 zahlen
 * und einem syntax mit for (int zahl : array) { System.out.println(zahl); }
 * würden alle werte von dem array nacheinander ausgegeben werden
 */
public class Check
{
    //Method zum Gucken Einser
    static void einser(int[] sortiert)
    {
        //j nimmt nach einander jeden wert
        // von sortiert an und vergleicht sie mit 1
        for (int j : sortiert)
        {
            if (j == 1)
            {
                Punkte.addPunkte(1);
                Punkte.addBonusPunkte(1);
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
                Punkte.addBonusPunkte(2);
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
                Punkte.addBonusPunkte(3);
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
                Punkte.addBonusPunkte(4);
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
                Punkte.addBonusPunkte(5);
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
                Punkte.addBonusPunkte(6);
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
                Punkte.addPunkte(sortiert[0] +
                                    sortiert[1] +
                                    sortiert[2] +
                                    sortiert[3] +
                                    sortiert[4]);
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
                Punkte.addPunkte(sortiert[0] +
                                    sortiert[1] +
                                    sortiert[2] +
                                    sortiert[3] +
                                    sortiert[4]);
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
            }
            if (zaehlerstand == 2)
            {
                zweiVonEinerArt = true;
            }
        }
        if (dreiVonEinerArt && zweiVonEinerArt)
        {
            Punkte.addPunkte(25);
        } else
        {
            Punkte.addPunkte(0);
        }
    }
    //Method zum Gucken kleine Straße
    static void kleineStrasse(int[] sortiert)
    {
        boolean kleineStrasseGefunden = false;
        int aufeiCount = 1;
        for (int i = 0; i < sortiert.length - 1; i++)
        {
            // wenn nächste zahl, so aufeinanderfolgend ist, wird count + 1 gemacht
            if (sortiert[i] + 1 == sortiert[i + 1])
            {
                aufeiCount++;
                // wenn 4 aufeinanderfolgende Zahlen gefunden wurden, wird
                // die Schleife abgebrochen. Ja es funktioniert
                // war am anfang bissel skeptisch
                if (aufeiCount >= 4)
                {
                    kleineStrasseGefunden = true;
                    break;
                }
                // wenn duplikat gefunden wurde, wird count zurückgesetzt
            } else if (sortiert[i] != sortiert[i + 1])
            {
                aufeiCount = 1;
            }
        }

        if (kleineStrasseGefunden)
        {
            Punkte.addPunkte(30);
        } else
        {
            Punkte.addPunkte(0);
        }
    }

    //Method zum Gucken große Straße
    static void grosseStrasse(int[] sortiert)
    {
        // Gehe von Wahrheit aus, wird nach gegenargument gesucht
        boolean grosseStrasseGefunden = true;
        for (int i = 0; i < sortiert.length - 1; i++)
        {
            if (sortiert[i] + 1 != sortiert[i + 1])
            {
                grosseStrasseGefunden = false;
                // wenn keine große straße möglich ist, wird die Schleife abgebrochen
                break;
            }
        }
        // sortiert muss mit 1 für eine 1-5 Straße oder mit 2 für eine 2-6 Straße beginnen.
        if (!(sortiert[0] == 1 || sortiert[0] == 2))
        {
            grosseStrasseGefunden = false;
        }

        if (grosseStrasseGefunden)
        {
            Punkte.addPunkte(40);
        } else
        {
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
        Punkte.addPunkte(sortiert[0]
                            + sortiert[1]
                            + sortiert[2]
                            + sortiert[3]
                            + sortiert[4]);
    }
}