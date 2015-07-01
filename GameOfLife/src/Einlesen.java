import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Die Datei mit der Vorlage für die Erste runte des GamesOfLife auslesen, die
 * Größe des Arrays ermitteln und die Werte dann auslesen und damit die
 * lebendigen Zellen im Spielfeld erstellen
 * 
 * @author 1443023
 *
 */
public class Einlesen {

	// Deklaration der Variablen
	private Spielfeld feld; // Abspeichern der Zellen in dem feld
	private String zeile; // Auslesen der Zeilen in der Datei
	private int anzahlZeile; // Ermitteln der Anzahl der Zeilen
	private int anzahlZeichen; // Ermitteln der Zeichen pro Zeile
	private int anzahlZeichenNeu; // Anzahl der Zeichen, der aktuellen neuen
									// Zeile
	// Zum Zugreifen auf die Datei
	private BufferedReader buffer;

	// Konstruktor
	public Einlesen() {
		anzahlZeile = 0;
		anzahlZeichen = 0;
	}

	/**
	 * Ermittelt die Größe des Benötigten Arrays für die Zellen, anhand des
	 * Inhaltes in der Datei und ließt diese Werte aus und erstellt damit die
	 * lebendigen Zellen im Feld
	 * 
	 * @author 1443023
	 * @param dateiName
	 *            Type String und wird benötigt zum Aufrufen der Datei
	 * @throws MeineException
	 *             Gibt einen Fehler, wenn die Datei verschiedenlange Zeilen hat
	 *             oder falsche Werte enthält, also nicht . und *
	 */
	public void einlesen(String dateiName) throws MeineException {
		// Prüft die Vorgänge und wirft sonst eine Fehlermeldung
		try {
			// Verbindung zur Datei Aufbauen, zum Auslesen bzw. ermitteln der
			// Anzahl der Zeichen und Zeilen
			buffer = verbinden(dateiName);

			// Größe der Zeilen und Anzahl der Zeichen in der Datei
			ermittleGroesse();

			// Neue Verbindung zur Datei Aufbauen, zum Auslesen der Daten
			buffer = verbinden(dateiName);

			// Das Objekt feld mit der ermittelten Größe erstellen
			feld = new Spielfeld(anzahlZeile, anzahlZeichen);

			datenAuslesen();
			// Zeile für zeile durchgehen
		} catch (FileNotFoundException eFile) {
			// Fehlermeldung ausgeben und abbrechen
			System.out
					.println("Die Datei ist nicht vorhanden oder der Name ist Falsch!");
		} catch (IOException e) {
			// Abfangen der undefinierten Fehler
			e.printStackTrace();
		} finally { // Wen der BufferReader vorhanden ist, aber nicht
					// Funktioniert, diesen Schließen
			if (buffer != null) { // ErmittelGroesse
				try {
					buffer.close(); // ErmittelGroesse
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Baut die Verbindung zu der Datei auf, in welcher der Anfangsspielstand
	 * steht
	 * 
	 * @author 1443023
	 * @param datNa
	 *            Name der Datei, in welcher der Anfangsspielstand steht
	 * @return Gibt das Verbindungsopjekt zu der Datei zurück
	 * @throws FileNotFoundException
	 */
	public BufferedReader verbinden(String datNa) throws FileNotFoundException {
		return new BufferedReader(new FileReader(datNa));
	}

	/**
	 * Ermittelt die Größe für das Array, also wieviele Zeilen es hat und
	 * Zeichen pro Zeile
	 * 
	 * @author 1443023
	 * @throws IOException
	 *             Fehlermeldung, wenn ein allgmeiner undefinierter
	 *             Fehlerauftritt
	 * @throws MeineException
	 *             Fehlermeldung, wenn die Zeilen in der Datei ungleichlang sind
	 */
	public void ermittleGroesse() throws IOException, MeineException {
		// Anzahl der Zeilen auslesen
		while ((zeile = buffer.readLine()) != null) { // !!! ErmittelGroesse
			// Auslesen wie lang die Zeilen der Datei sind
			anzahlZeichenNeu = zeile.length();
			// Wenn 0, also erstes mal anzahlZeichenNeu, Wert vom auslesen
			// übernehmen
			anzahlZeichen = (anzahlZeichen == 0) ? anzahlZeichenNeu
					: anzahlZeichen;
			// Prüfenob die Neue aktuelle Zeile gleich lang der anderen ist
			if (anzahlZeichen != anzahlZeichenNeu) {
				// Fehlermeldung ausgeben, das die Zeilen Ungleichlang sind und
				// abbrechen
				throw new MeineException(
						"Die Datei enthält ungleichlange Zeilen!");
			}
			// Anzahl der Zeilen erhöhen um eins
			anzahlZeile++;
		}
	}

	/**
	 * Ließt die Daten aus der Datei aus und erstellt damit dann die lebendigen
	 * Zellen in dem Feldarray
	 * 
	 * @throws IOException
	 *             Fehlermeldung, wenn ein allgmeiner undefinierter
	 *             Fehlerauftritt
	 * @throws MeineException
	 *             Wirft eine Fehlermeldung wenn die Datei falsche Werte
	 *             enthält, also etwas anderes wie '.' für tote Zellen oder '*'
	 *             für lebendige Zellen
	 */

	public void datenAuslesen() throws IOException, MeineException {
		// Zeile für zeile durchgehen
		for (int k = 0; k < anzahlZeile; k++) {
			// Zur Nächsten Zeile springen und auslesen
			zeile = buffer.readLine(); // !!!Auslesen
			// Zeichen für Zeichen der Zeile durchgehen
			for (int i = 0; i < anzahlZeichen; i++) {
				// Prüfen ob das Zeichen ein "*" ist, also ob sie lebt
				if (('*' == zeile.charAt(i))) {
					// Neue Zelle erstellen
					feld.gebäreZelle(k, i);
	//wenn getestet werden will ob die zellen aus der datei gelesen werden
	//diese zeile mit rein nehmen 		->		"System.out.print("l ");"     
			//und die "feld.gebäre.." darüber rauskomentieren
					
				} else {
					// Prüfen ob ein Falsches zeichen, also alle auser * oder .
					// vorhanden ist
					if ('.' != zeile.charAt(i)) {
						// System.out.println("Abbruch, da falsche zelle");
						throw new MeineException(
								"Die Datei enthält falsche Werte!");
					}
				}
			}
		}
	}

}
