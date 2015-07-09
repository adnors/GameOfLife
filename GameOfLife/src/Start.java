import javax.swing.JOptionPane;

/**
 * Zum Starten des Spieles GameOfLife.
 * 
 * @author 1443023
 *
 */
public class Start {
	/**
	 * Startet das Programm
	 * 
	 * @param Uebergabeparameter
	 *            //!!!hier kommen der Dateiname, und die anderen Variablen noch
	 *            rein !!!
	 */
	public static void main(String[] args) {
		
		String name = "/Users/MatthiasDuernay/Documents/workspace/GameOfLife_DHBW/src/test.txt"; // Nur zum testen jetzt vorlaeufig so, dann mit
									// der args variable
									// zb. so, wenn der datei name an erster
									// stelle name = args[0];

		// Erstellen des Objektes, der Klasse Einlesen
		Einlesen einl = new Einlesen();

		// Aufrufen des Einlesevorgangs, und abfangen der Fehler dabei und ausgeben
		try {
			
			einl.einlesen(name);
			
			//Spielfeld anzeigen
			//Zeig mich an kollege
			//JUENGE :D
			

		} catch (MeineException e) {

			JOptionPane.showMessageDialog(null, e.getZusatz(), "Fehler", 0);
		}

	}
}
