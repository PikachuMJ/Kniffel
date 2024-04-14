import javax.swing.border.Border;
import java.awt.*;

public class AnimierteBorder implements Border {
    private Color farbe;
    private final int breite;

    public AnimierteBorder(Color farbe, int breite) {
        this.farbe = farbe;
        this.breite = breite * 2;
    }

    @Override
    //basically erstellt die border drum rum
    public void paintBorder(Component c, Graphics g, int x, int y, int breite, int hoehe) {
        // Berechnet die Farben
        Color obenFarbe = farbeAnpassung(farbe, -20);
        Color untenFarbe = farbeAnpassung(farbe, 20);
        Color linksFarbe = farbeAnpassung(farbe, -40);
        Color rechtsFarbe = farbeAnpassung(farbe, 40);

        // Obere border
        g.setColor(obenFarbe);
        g.fillRect(x, y, breite, this.breite);

        // Untere border
        g.setColor(untenFarbe);
        g.fillRect(x, y + hoehe - this.breite, breite, this.breite);

        // Linke border
        g.setColor(linksFarbe);
        g.fillRect(x, y + this.breite, this.breite, hoehe - 2 * this.breite);

        // Rechte border
        g.setColor(rechtsFarbe);
        g.fillRect(x + breite - this.breite, y + this.breite, this.breite, hoehe - 2 * this.breite);
    }

    private Color farbeAnpassung(Color farbe, int aenderung) {
        int r = Math.min(Math.max(farbe.getRed() + aenderung, 0), 255);
        int g = Math.min(Math.max(farbe.getGreen() + aenderung, 0), 255);
        int b = Math.min(Math.max(farbe.getBlue() + aenderung, 0), 255);
        return new Color(r, g, b);
    }

    @Override
    //einfach gesagt sagt es aus wie breit die border ist
    public Insets getBorderInsets(Component c) {
        return new Insets(breite, breite, breite, breite);
    }

    @Override
    //macht nichts, wegen dem interface muss sie aber trotzdem da sein
    public boolean isBorderOpaque() {
        return true;
    }

    public void nextColor() {
        // etwas bessere farben
        int r = farbe.getRed();
        int g = farbe.getGreen();
        int b = farbe.getBlue();

        /*
         *guckt welche Farbe höher, und welche niedriger
         * gemacht werden muss.
         */
        if (r == 255 && g < 255 && b == 0) {
            g += 5;
        } else if (g == 255 && r > 0 && b == 0) {
            r -= 5;
        } else if (g == 255 && b < 255 && r == 0) {
            b += 5;
        } else if (b == 255 && g > 0 && r == 0) {
            g -= 5;
        } else if (b == 255 && r < 255 && g == 0) {
            r += 5;
        } else if (r == 255 && b > 0 && g == 0) {
            b -= 5;
        } else {
            // fallback-Mechanismus. Falls nichts von oben zutrifft, werden die farben trotzdem geändert.
            if (r < 255 && g == 0 && b == 0) {
                r += 5;
            } else if (g == 255 && b < 255) {
                b += 5;
            } else if (b == 255 && g > 0) {
                g -= 5;
            } else if (r < 255 && b == 255) {
                r += 5;
            } else if (r == 0 && g == 0 && b > 0) {
                b -= 5;
            }
        }

        r = Math.min(Math.max(r, 0), 255);
        g = Math.min(Math.max(g, 0), 255);
        b = Math.min(Math.max(b, 0), 255);

        // Farben update
        farbe = new Color(r, g, b);
    }
}