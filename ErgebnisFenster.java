import javax.swing.*;
import java.util.Arrays;

public class ErgebnisFenster
{
    ErgebnisFenster() {
        ImageIcon Win = new ImageIcon("win.png");
        ImageIcon Lose = new ImageIcon("lose.png");
        int Spieler1 = Punkte.punkteSpieler[0];



        int[] erg = {Punkte.punkteSpieler[0],
                     Punkte.punkteSpieler[1],
                     Punkte.punkteSpieler[2],
                     Punkte.punkteSpieler[3],
                     Punkte.punkteSpieler[4],
                     Punkte.punkteSpieler[5],
                     Punkte.punkteSpieler[6],
                     Punkte.punkteSpieler[7]};

        Arrays.sort(erg);
        StringBuilder message = new StringBuilder();
        for (int j = erg.length - 1; j >= erg.length - Kniffel.playerPlaying; j--) {
            int score = erg[j];
            for (int i = 0; i < Punkte.punkteSpieler.length; i++) {
                if (score == Punkte.punkteSpieler[i]) {
                    message.append("Player ").append(i + 1).append(": ").append(score).append("\n");
                    break; // To avoid matching the same score multiple times
                }
            }
        }
        JOptionPane.showMessageDialog(null, message.toString());
    }
}
