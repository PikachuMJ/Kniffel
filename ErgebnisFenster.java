import javax.swing.*;
import java.util.Arrays;

public class ErgebnisFenster
{
    ErgebnisFenster()
    {
        ImageIcon endBild = new ImageIcon("end.png");
        /*alle Punkte dem einzelnen Spiel werden gespeichert
         * zum schnell abholen
         */
        int[] erg = {Punkte.punkteSpieler[0],
                     Punkte.punkteSpieler[1],
                     Punkte.punkteSpieler[2],
                     Punkte.punkteSpieler[3],
                     Punkte.punkteSpieler[4],
                     Punkte.punkteSpieler[5],
                     Punkte.punkteSpieler[6],
                     Punkte.punkteSpieler[7]};
        //Als aufbau so das man nicht aus Versehen wegklickt
        JOptionPane.showMessageDialog(null, "Und der gewinner ist/die gewinner sind......");
        //Array wird offensichtlich sortiert
        Arrays.sort(erg);
        //StringBuild wird erstellt
        StringBuilder message = new StringBuilder();
        for (int j = erg.length - 1; j >= erg.length - Kniffel.playerPlaying; j--)
        {
            int punkte = erg[j];
            for (int i = 0; i < Punkte.punkteSpieler.length; i++)
            {
                if (punkte == Punkte.punkteSpieler[i])
                {
                    String pName = switch (i)
                    {
                        //enhanced switch ist scheinbar wie ein normaler switch
                        // nur ohne breaks und allgemein übersichtlicher
                        case 0 -> Kniffel.pNames[0];
                        case 1 -> Kniffel.pNames[1];
                        case 2 -> Kniffel.pNames[2];
                        case 3 -> Kniffel.pNames[3];
                        case 4 -> Kniffel.pNames[4];
                        case 5 -> Kniffel.pNames[5];
                        case 6 -> Kniffel.pNames[6];
                        default -> Kniffel.pNames[7];
                    };
                    //unten wird allgemein alles zusammen gefasst, Punkte, namen, reihenfolge
                    message.append(pName).append(": ").append(punkte).append(" Punkte").append("\n");
                    break;
                }
            }
        }
        //Ausgabe von allem
        JOptionPane.showMessageDialog(null, message.toString(), "Ende :O", JOptionPane.PLAIN_MESSAGE, endBild);
    }
}
