import javax.swing.JFrame;

public class FrameContainer 
{
    private JFrame frame;
    
    FrameContainer(Spielfeld feld)
    {
        frame = new JFrame();
        
        int feldBreite = feld.reihe;
        int feldHoehe = feld.spalte;
        
        int anzSpa = feldBreite;// !!! WERT SUCHEN
        int anzZei = feldHoehe;// !!! WERT SUCHEN
        int breite = (24 + anzSpa * 30);
        int hoehe = (24 + anzZei * 33);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(breite, hoehe);
        frame.add(new Gui(feld));                // add component inheriting from JPanel
        frame.setVisible(true);
    }
}
//Ja Hallo