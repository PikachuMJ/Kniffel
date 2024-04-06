import javax.swing.*;
import java.util.Arrays;

public class Kniffel {
    //Array speichert Verfügbarkeit der Knöpfe in ErgebnisFenster
    public static boolean[] buttonAvailability = new boolean[13];
    //speichert Anzahl der Knopfdrücke die in MyFrame passieren
    public static int buttonPressCount2 = 0;

    public static void main(String[] args) {
        ImageIcon icon = new ImageIcon("wuerfel4.png");
        JOptionPane.showMessageDialog(null, "","",JOptionPane.PLAIN_MESSAGE, icon);
        //setzt alle knöpfe als verfügbar
        Arrays.fill(buttonAvailability, true);
        //allgemein startet alles

        new MyFrame(buttonAvailability, buttonPressCount2, Punkte.punkte);
    }
}
