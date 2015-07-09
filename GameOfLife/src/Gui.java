import java.awt.*;
/**
 * @author 2552171
 * Die Klasse soll eine GUI zeichnen, die anschließend die Werte des Game of Life grafisch darstellt.
 * Dabei wird das Kästchen in mehreren Graustufen dargestellt. weiß ist eine tote Zelle und mit zunehmendem Alter werden die Zellen dunkler bis sie bei 5 schwarz sind.
 */
import javax.swing.*;
public class Gui extends JPanel
{
	/**
	 * @author 2552171
	 * In den 3 Arrays sind werte für die Bildung einer Farbe in RGB-Werten gespeichert. So kann das Farbenspektrum beliebig erweitert werden. Dieses wäre mit den Standardausdrücken nicht möglich. 
	 */
	private char [] RGBArrayR = {255,150,100,50,0};
	private char [] RGBArrayG = {255,150,100,50,0};
	private char [] RGBArrayB = {255,150,100,50,0};

	protected void paintComponent( Graphics g )
	{
	super.paintComponent ( g );
	int anzSpa = 6;
	int anzZei = 8;
	int y = 12;
	int x = 12;
	/**
	 * @author 2552171
	 * Die folgenden Schleifen zeichnen ein Feld mit den Farb und Positionswerten die aus der Zelle übergeben werden.
	 *  
	 */
	for (int z = anzSpa; z > 0; z--){
	y = 12;
	for (int a = anzZei; a > 0; a--){
		//
		if (feld.zelleLebt(a, z)) {		
			/**
			 * @author 2552171
			 * Wenn die Zelle lebt wird der Farbwert mit dem Alter ausgerechnet und entsprechend gezeichnet.
			 */
			Color farbe = new Color(RGBArrayR[feld.liefereZelleZurueck(a, z).getAlter()], RGBArrayG[RGBArrayR[feld.liefereZelleZurueck(a, z).getAlter()], RGBArrayB[RGBArrayR[feld.liefereZelleZurueck(a, z).getAlter()]);
			g.setColor(colr);
			g.fillRect(x-1, y-1, 25, 25);
			g.setColor(Color.red);
			g.drawRect(x-1, y-1, 25, 25); 
		}
		else {	
			/**
			 * @author 2552171
			 * Wenn die Zelle tot ist wird der Farbwert mit dem Alter 0 verwendet, im Array ist das weiß.
			 */
			Color farbe = new Color(RGBArrayR[0], RGBArrayG[RGBArrayR[0], RGBArrayB[RGBArrayR[0]);
			g.setColor(Farbe);
			g.fillRect(x-1, y-1, 25, 25);
			g.setColor(Color.red);
			g.drawRect(x-1, y-1, 25, 25); 
		}
		//
	y = y + 30;
	}
	x = x + 30;
	}
	}
	public void Frame{
		/**
		 * @author 2552171
		 * Zeichnen der GUI 
		 */
		JFrame f = new JFrame("Game of Life");
		int anzSpa = feld.breite;//!!! WERT SUCHEN
		int anzZei = feld.breite;//!!! WERT SUCHEN
		int breite = (24+anzSpa*30);
		int hoehe = (24+anzZei*30);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(breite, hoehe);
		f.add(new Gui());
		f.setVisible(true);
	}
}