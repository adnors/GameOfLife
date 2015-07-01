import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 * Die Datei mit der Vorlage für die Erste runte des GamesOfLife auslesen, 
 * die Größe des Arrays ermitteln und die Werte dann auslesen und damit die 
 * lebendigen Zellen im Feld erstellen
 * @author 1443023
 *
 */
public class Einlesen {

	//Deklaration der Variablen
	private Feld fe;				//Abspeichern der Zellen in dem Feld
	private String zeile;			//Auslesen der Zeilen in der Datei
	private int anzahlZeile;	//Ermitteln der Anzahl der Zeilen
	private int anzahlZeichen;	//Ermitteln der Zeichen pro Zeile	
	int anzahlZeichenNeu;			//Anzahl der Zeichen, der aktuellen neuen Zeile
	//Zum Zugreifen auf die Datei 
	private BufferedReader bufferErmittelGroesse;	//Ermitteln der Größe des Arrays
	private BufferedReader bufferAuslesen;	//Auslesen der Werte
	
	//Konstruktor		
	public Einlesen() {
		anzahlZeile = 0;
		anzahlZeichen = 0;
	}

	/**
	 * Ermittelt die Größe des Benötigten Arrays für die Zellen, 
	 * anhand des Inhaltes in der Datei
	 * und ließt diese Werte aus und erstellt damit die lebendigen Zellen im Feld
	 * @author 1443023
	 * @param dateiName Type String und wird benötigt zum Aufrufen der Datei
	 * @throws MeineException Gibt einen Fehler, 
	 * wenn die Datei verschiedenlange Zeilen hat oder falsche Werte enthält, 
	 * also nicht . und *
	 */
	public void einlesen(String dateiName) throws MeineException {
		//Prüft die Vorgänge und wirft sonst eine Fehlermeldung
		try {
			//Verbindung zur Datei Aufbauen, zum Auslesen bzw. ermitteln der Anzahl der Zeichen und Zeilen
			bufferErmittelGroesse = new BufferedReader(new FileReader(new File(dateiName)));

//!!unsicher ob benötigt wird, warsch. raus!!	
//		zeile = null;

			// Anzahl der Zeilen auslesen
			while ((zeile = bufferErmittelGroesse.readLine()) != null) {
				// Auslesen wie lang die Zeilen der Datei sind
				anzahlZeichenNeu = zeile.length();
				// Wenn 0, also erstes mal anzahlZeichenNeu, Wert vom auslesen übernehmen
				anzahlZeichen = (anzahlZeichen == 0) ? anzahlZeichenNeu : anzahlZeichen;
				// Prüfenob die Neue aktuelle Zeile gleich lang der anderen ist 
				if (anzahlZeichen != anzahlZeichenNeu) {
					//Fehlermeldung ausgeben, das die Zeilen Ungleichlang sind und abbrechen
					throw new MeineException("Fehler: Die Datei enthält ungleichlange Zeilen!");
				}
				//Anzahl der Zeilen erhöhen um eins
				anzahlZeile++; 
			}
			//Neue Verbindung zur Datei Aufbauen, zum Auslesen der Daten
			bufferAuslesen = new BufferedReader(new FileReader(dateiName));

			//Das Objekt Feld mit der ermittelten Größe erstellen
			fe = new Feld(anzahlZeile, anzahlZeichen);
			//Zeile für zeile durchgehen
			for (int k = 0; k < anzahlZeile; k++) {
				// Zur Nächsten Zeile springen und auslesen
				zeile = bufferAuslesen.readLine();
				// Zeichen für Zeichen der Zeile durchgehen
				for (int i = 0; i < anzahlZeichen; i++) {
					//Prüfen ob das Zeichen ein "*" ist, also ob sie lebt
					if (('*' == zeile.charAt(i))) 
					{
						//Neue Zelle erstellen
						fe.gebäreZelle(k, i);

					} else {
						//Prüfen ob ein Falsches zeichen, also alle auser * oder . vorhanden ist
						if ('.' != zeile.charAt(i)) {
							// System.out.println("Abbruch, da falsche zelle");
							throw new MeineException("Fehler: Die Datei enthält falsche Werte!");
						}
					}
				}
			}
		} catch (FileNotFoundException eFile) {
			//Fehlermeldung ausgeben und abbrechen
			System.out.println("Fehler: Die Datei ist nicht vorhanden oder der Name ist Falsch!");
		} catch (IOException e) {
			//Abfangen der undefinierten Fehler
			e.printStackTrace();
		} finally {	//Wen der BufferReader vorhanden ist, aber nicht Funktioniert, diesen Schließen
			if (bufferErmittelGroesse != null) {
				try {
					bufferErmittelGroesse.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
