import java.awt.*;
import javax.swing.*;
public class Gui extends JPanel
{
	protected void paintComponent( Graphics g )
	{
	super.paintComponent ( g );
	int anzSpa = 6;
	int anzZei = 8;
	int y = 12;
	int x = 12;
	for (int z = anzSpa; z > 0; z--){
	y = 12;
	for (int a = anzZei; a > 0; a--){
	g.setColor(Color.black);
	g.fillRect(x-1, y-1, 25, 25);
	g.setColor(Color.red);
	g.drawRect(x-1, y-1, 25, 25);
	y = y + 30;
	}
	x = x + 30;
	}
	}
	public static void main( String[] args){
		JFrame f = new JFrame("Game of Life");
		//Die Main wird ersetzt, die initialisierungen erfolgen später zusammen.
		int anzSpa = 6;
		int anzZei = 8;
		int breite = (24+anzSpa*30);
		int hoehe = (24+anzZei*30);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(breite, hoehe);
		f.add(new Gui());
		f.setUndecorated(true);
		f.setVisible(true);
	}
}