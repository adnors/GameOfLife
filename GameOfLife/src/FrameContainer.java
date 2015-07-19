import javax.swing.JFrame;

public class FrameContainer  extends Ausgabe
{
    private JFrame frame;
    
    public FrameContainer(Spielfeld feld)
    {
        frame = new JFrame();
        
        int feldBreite = feld.anzahlSpalten();
        int feldHoehe = feld.anzahlReihen();
        
        int anzSpa = feldBreite;
        int anzZei = feldHoehe;
        int breite = (24 + anzSpa * 30);
        int hoehe = (24 + anzZei * 33);
        frame.setTitle("Game of Life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(breite, hoehe);
        frame.add(new Gui(feld));                // add component inheriting from JPanel.
        frame.setVisible(true);
    }
    
    @Override
    public void zeichneArray(Spielfeld feld) {
    	frame.add(new Gui(feld));
    	frame.setVisible(true);
	}
    
}
