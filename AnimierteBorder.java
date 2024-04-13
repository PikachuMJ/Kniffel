import javax.swing.border.Border;
import java.awt.*;

public class AnimierteBorder implements Border {
    private Color color;
    private final int breite;

    public AnimierteBorder(Color initialColor, int thickness) {
        this.color = initialColor;
        this.breite = thickness * 2;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(color);
        g.fillRect(x, y, width, breite); // Oben
        g.fillRect(x, y + height - breite, width, breite); // Unten
        g.fillRect(x, y + breite, breite, height - 2 * breite); // Links
        g.fillRect(x + width - breite, y + breite, breite, height - 2 * breite); // Rechts
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(breite, breite, breite, breite);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }

    public void nextColor() {
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();

        if (r == 255 && g < 255 && b == 0) {
            g += 15;
        } else if (g == 255 && r > 0 && b == 0) {
            r -= 15;
        } else if (g == 255 && b < 255 && r == 0) {
            b += 15;
        } else if (b == 255 && g > 0 && r == 0) {
            g -= 15;
        } else if (b == 255 && r < 255 && g == 0) {
            r += 15;
        } else if (r == 255 && b > 0 && g == 0) {
            b -= 15;
        }

        color = new Color(Math.min(Math.max(r, 0), 255), Math.min(Math.max(g, 0), 255), Math.min(Math.max(b, 0), 255));
    }
}

