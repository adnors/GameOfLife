import javax.swing.JOptionPane;

/**
 * Zum Starten des Spieles GameOfLife.
 * 
 * @author 1443023
 *
 */
public class GameOfLife {
	protected static boolean guienabled;
	
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
		
		String path = args[0];
		String timeDelay = args[1];
		String mode = args[2];
		String borderMode = args[3];
		
		/* ZUM TESTEN
		String path = "/Users/Daniel/git/test/GameOfLife/src/file2.txt";
		String timeDelay = "300";
		String mode = "gui";
		String borderMode = "torus";
		*/
		
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
			guienabled = true;
		}
		else
		{
			if (mode.equals("cli"))
			{
				guienabled = false;
			}
			else
			{
				System.out.println("Mode parameter unrecognizable");	
			}
		}
		
		
		Algorithmus algo = new Algorithmus(einl.feld); 
		
		boolean bordered = false;
		
		if(borderMode.equals("bordered"))
		{
			bordered = true;
		}
		
		
		GameLoop loop = new GameLoop(Integer.parseInt(timeDelay), algo, guienabled, bordered);
		
		Thread thread = new Thread(loop);
		thread.start();
		
		
		// TODO create thread with sleep time according to parameter, in which a while loop calls the methods of "algo" and the gui/cli gets updated accordingly

		
	}
}
