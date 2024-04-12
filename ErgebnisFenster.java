import javax.swing.*;
import java.util.Arrays;

public class ErgebnisFenster
{
    ErgebnisFenster()
    {
        int[] erg = {Punkte.punkteSpieler[0],
                     Punkte.punkteSpieler[1],
                     Punkte.punkteSpieler[2],
                     Punkte.punkteSpieler[3],
                     Punkte.punkteSpieler[4],
                     Punkte.punkteSpieler[5],
                     Punkte.punkteSpieler[6],
                     Punkte.punkteSpieler[7]};
        JOptionPane.showMessageDialog(null, "Und der gewinner ist/die gewinner sind......");
        Arrays.sort(erg);
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
                        case 0 -> Kniffel.p1Name;
                        case 1 -> Kniffel.p2Name;
                        case 2 -> Kniffel.p3Name;
                        case 3 -> Kniffel.p4Name;
                        case 4 -> Kniffel.p5Name;
                        case 5 -> Kniffel.p6Name;
                        case 6 -> Kniffel.p7Name;
                        default -> Kniffel.p8Name;
                    };
                    message.append(pName).append(": ").append(punkte).append(" Punkte").append("\n");
                    break;
                }
            }
        }
        JOptionPane.showMessageDialog(null, message.toString());
    }
}
