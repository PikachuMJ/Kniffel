import javax.swing.border.Border;
import java.awt.*;

public class AnimierteBorder implements Border
{
    private Color farbe;
    private final int breite;

    public AnimierteBorder(Color farbe, int breite)
    {
        this.farbe = farbe;
        this.breite = breite * 2;
    }

    @Override
    //basically erstellt die border drum rum
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
    {
        g.setColor(farbe);
        g.fillRect(x, y, width, breite); // Oben
        g.fillRect(x, y + height - breite, width, breite); // Unten
        g.fillRect(x, y + breite, breite, height - 2 * breite); // Links
        g.fillRect(x + width - breite, y + breite, breite, height - 2 * breite); // Rechts
    }

    @Override
    //einfach gesagt sagt es aus wie breit die border ist
    public Insets getBorderInsets(Component c)
    {
        return new Insets(breite, breite, breite, breite);
    }

    @Override
    //macht nichts, wegen dem interface muss sie aber trotzdem da sein
    public boolean isBorderOpaque()
    {
        return true;
    }
    public void nextColor()
    //einfach gesagt, geht durch bestimmte farben spektren, wenn
    //bestimmte farben erreicht sind, wodurch die animation entsteht
    {
        int r = farbe.getRed();
        int g = farbe.getGreen();
        int b = farbe.getBlue();

        if (r == 255 && g < 255 && b == 0)
        {
            g += 15;
        } else if (g == 255 && r > 0 && b == 0)
        {
            r -= 15;
        } else if (g == 255 && b < 255 && r == 0)
        {
            b += 15;
        } else if (b == 255 && g > 0 && r == 0)
        {
            g -= 15;
        } else if (b == 255 && r < 255 && g == 0)
        {
            r += 15;
        } else if (r == 255 && b > 0 && g == 0)
        {
            b -= 15;
        }
        //updates die farbe und schaut das die farbe zwischen 0 und 255 ist
        farbe = new Color(Math.min(Math.max(r, 0), 255), Math.min(Math.max(g, 0), 255), Math.min(Math.max(b, 0), 255));
    }
}