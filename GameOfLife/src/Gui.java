import java.awt.*;
/**
 * @author 2552171
 * Die Klasse soll eine GUI zeichnen, die anschlieÃŸend die Werte des Game of Life grafisch darstellt.
 * Dabei wird das KÃ¤stchen in mehreren Graustufen dargestellt. weiÃŸ ist eine tote Zelle und mit zunehmendem Alter werden die Zellen dunkler bis sie bei 5 schwarz sind.
 */
import javax.swing.*;

public class Gui extends JPanel {
    /**
     * In den 3 Arrays sind werte fuer die Bildung einer Farbe in
     * RGB-Werten gespeichert. So kann das Farbenspektrum beliebig
     * erweitert werden. Dieses waere mit den Standardausdruecken nicht
     * moeglich.
     * 
     * @author 2552171 
     */
    private int[] RGBArrayR = { 255, 150, 100, 50, 0 };
    private int[] RGBArrayG = { 255, 150, 100, 50, 0 };
    private int[] RGBArrayB = { 255, 150, 100, 50, 0 };
    private Spielfeld feld;
    
    private int feldBreite;
    private int feldHoehe;
    
    public Gui(Spielfeld feldInstanz)
    {
        this.feld = feldInstanz;
        this.feldBreite = feldInstanz.anzahlSpalten();
        this.feldHoehe = feldInstanz.anzahlReihen();
    }

    // overrides JPanel implementation of paintComponent()
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int anzSpa = feldBreite;
        int anzZei = feldHoehe;
        int y = 12;
        int x = 12;
        /**
         * @author 2552171 Die folgenden Schleifen zeichnen ein Feld mit den
         *         Farb- und Positionswerten die aus der Zelle uebergeben werden.
         * 
         */
        for (int z = 0; z < anzSpa; z++) {
            y = 12;
            for (int a = 0; a < anzZei; a++) {
                //
                if (feld.zelleLebt(a, z)) {
                    /**
                     * @author 2552171 Wenn die Zelle lebt wird der Farbwert mit
                     *         dem Alter ausgerechnet und entsprechend
                     *         gezeichnet.
                     */
                    Color farbe = new Color(RGBArrayR[feld.liefereZelleZurueck(a, z).getAlter()],
                            RGBArrayG[feld.liefereZelleZurueck(a, z).getAlter()],
                            RGBArrayB[feld.liefereZelleZurueck(a, z).getAlter()]);
                    g.setColor(farbe);
                    g.fillRect(x - 1, y - 1, 25, 25);
                    g.setColor(Color.red);
                    g.drawRect(x - 1, y - 1, 25, 25);
                } else {
                    /**
                     * @author 2552171 Wenn die Zelle tot ist wird der Farbwert
                     *         mit dem Alter 0 verwendet, im Array ist das weiss.
                     */
                    Color farbe = new Color(RGBArrayR[0], RGBArrayG[0], RGBArrayB[0]);
                    g.setColor(farbe);
                    g.fillRect(x - 1, y - 1, 25, 25);
                    g.setColor(Color.red);
                    g.drawRect(x - 1, y - 1, 25, 25);
                    
                }
                //
                y = y + 30;
            }
            x = x + 30;
        }
    }

}
