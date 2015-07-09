import javax.swing.JOptionPane;

/**
 * Zum Starten des Spieles GameOfLife.
 * 
 * @author 1443023
 *
 */
public class GameOfLife {
	/**
	 * Startet das Programm
	 * 
	 * @param Uebergabeparameter
	 *            //!!!hier kommen der Dateiname, und die anderen Variablen noch
	 *            rein !!!
	 */
	/**
		* @author 2552171 
		 * Main M r
		 */
	public static void main(String[] args) {
		
		String path = args[1];
		String timeDelay = args[2];
		String mode = args[3];
		String borderMode = args[4];
		
		
		// Erstellen des Objektes, der Klasse Einlesen
		Einlesen einl = new Einlesen();
		
		
		// Aufrufen des Einlesevorgangs, und abfangen der Fehler dabei und ausgeben
		try {
			
			einl.einlesen(path);

		} catch (MeineException e) {

			JOptionPane.showMessageDialog(null, e.getZusatz(), "Fehler", 0);
		}
		


		if (mode.equals("gui"))
		{
			//ATODO: mach gui
		}
		if (mode.equals("cli"))
		{
			//ATODO terminal
		}
		else
		{
			System.out.println("Mode parameter unrecognizable");	
		}
		
		Algorithmus algo = new Algorithmus(einl.feld); 
		
		boolean bordered = false;
		
		if(borderMode.equals("bordered"))
		{
			bordered = true;
		}
		
		
		GameLoop loop = new GameLoop(Integer.parseInt(timeDelay), algo, bordered);
		
		Thread thread = new Thread(loop);
		thread.start();
		
		
		// TODO create thread with sleep time according to parameter, in which a while loop calls the methods of "algo" and the gui/cli gets updated accordingly

		
	}
}
