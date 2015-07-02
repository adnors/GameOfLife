/**
 * Ein Spielfeld ist ein Objekt vom Datentyp Zelle [] [], welches ein flexibles 2 Dimensionales Array 
 * mit n Reihen und m Spalten bestitzt
 * 
 * @author 2788085
 *
 */
public class Spielfeld {
	
	/**
	 * Initialisierung eines 2 Dimensionalen Arrays "Spielfeld" vom Datentyp Zelle
	 * @author 2788085
	 */
	private Zelle[][] Spielfeld;
	
	/**
	 * Überladener Konstruktor zum erstellen eines 2 Dimensionalen Arrays "Spielfeld" vom Datentyp Zelle
	 * mit den Übergabewerten anzahlSpalte (Anzahl der Spalten) und anzahlReihe (Anzahl der Reihen). 
	 * Das Spielfeld wird hier flexibel dimensioniert und jedes Element mit "Null" gefüllt.
	 * 
	 * @param anzahlSpalte Anzahl der Spalten des Spielfeldes
	 * @param anzahlReihe Anzahl der Reihen des Spielfeldes
	 * @author 2788085
	 */
	public Spielfeld(int anzahlSpalte, int anzahlReihe) {
		Spielfeld = new Zelle[anzahlReihe][anzahlSpalte];
	}
	
	/**
	 * Liefert die Zelle an einem bestimmten, angefragten Speicherplatz im Spielfeldarray zurück
	 * Wenn keine Zelle an diesem Ort vorhanden ist wird NULL zurpck gegeben
	 * 
	 * @param reihe Reihe, in der sich die Zelle im Array befindet
	 * @param spalte Spalte, in der sich die Zelle im Array befindet
	 * @return Gibt die Zelle/NULL an einem bestimmten Ort (Reihe/Spalte) zurück
	 * @author 2788085
	 */
	public Zelle liefereZelleZurueck (int reihe, int spalte) {
		
		return Spielfeld [reihe][spalte];
	} 
		
	/**
	 * Löscht/tötet eine Zelle an einer bestimmten Position im Spielfeld
	 * und ersetzt diese durch NULL
	 * @param reihe Reihe, in der sich die Zelle im Array befindet
	 * @param spalte Spalte, in der sich die Zelle im Array befindet
	 * @author 2788085
	 */
	public void töteZelle (int reihe, int spalte) {
		
		Spielfeld[reihe][spalte] = null;
	}
	
	/**
	 * Speichert eine übergebene Zelle im Spielfeldarray an der Position Spielfeld [reihe][spalte]
	 * Wird für folgende Methoden verwendet:
	 * - gebäreZelle (Geburt einer neuen Zelle im Spielfeld)
	 * - altereZelle (Vorhandene Zelle altert und wird im Array überschrieben)
	 * 
	 * @param reihe Reihe in der die Zelle gespeichert werden soll
	 * @param spalte Spalte, in der die Zelle gespeichert werden soll
	 * @param z Zelle die gespeichert werden soll
	 * @author 2788085
	 */
	public void speichereZelle (int reihe, int spalte, Zelle z) {
		
		Spielfeld[reihe][spalte] = z;
	}
	
	/**
	 * Generiert eine neue Zelle im Spielfeld
	 * Das Alter der neuen Zelle wird über den Standardkonstruktor der Zelle auf 1 gesetzt
	 * 
	 * @param reihe Reihe in der die Zelle gespeichert werden soll
	 * @param spalte Spalte, in der die Zelle gespeichert werden soll
	 * @author 2788085
	 */
	public void gebäreZelle (int reihe, int spalte) {
		
		speichereZelle(reihe, spalte, new Zelle());
	}
	

	/**
	 * Zelle, auf einer bestimmten Position im Array wird um 1 älter.
	 * 
	 * @param reihe Reihe, der zu alternden Zelle
	 * @param spalte Spalte, der zu alternden Zelle
	 * @author 2788085
	 */
	public void altereZelle (int reihe, int spalte) {
		
		speichereZelle(reihe, spalte, liefereZelleZurueck(reihe, spalte).zaehleAlterHoch());
	}
	
	/**
	 * Prüft ein Arrayelement im Spielfeld, ob dort eine lebende Zelle vorhanden ist.
	 * 
	 * @param reihe Reihe im Spielfeld
	 * @param spalte Spalte im Spielfeld
	 * @return Gibt true zurück, ob eine Arrayposition eine lebende Zelle beinhaltet (Inhalt = Leben) oder false, wenn ein Arrayelement kein Inhalt bestitzt (NULL)
	 * @author 2788085
	 */
	public boolean zelleLebt(int reihe, int spalte) {
		
		if (liefereZelleZurueck(reihe, spalte) != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Berechnet die Anzahl der unmittelbaren lebenden Nachbarn einer Zelle
	 * 
	 * Zunächst prüft die Methode, ob die Positionen rund um die Zelle lebende Nachbarzellen sind
	 * und zählt bei einem Treffer eine Zählvariable vom Typ Integer hoch. 
	 * Die betrachtete Zelle selbst wird beim Zählen ausgeschlossen.
	 * 
	 * Reihenfolge der Überprüfung der Nachbarn (von links oben nach rechts unten):
	 *   1 2 3  
	 *   _ _ _
	 *  |     |
	 * 4|  o  |5
	 *  |_ _ _|
	 *   6 7 8
	 * 
	 * @param reihe
	 * @param spalte
	 * @return Gibt die Anzahl der unmittelbaren lebenden Nachbarn einer Zelle als Integerwert zurück (Maximal 8 Nachbarn)
	 * @author 2788085
	 */
	public int returnNachbaranzahl(int reihe, int spalte) {
		
		int zähler = 0; //Zähler auf 0
		
		
		for (int i = (reihe -1); i < (reihe +2); i++) {
			for (int j = (spalte -1); j < (spalte +2); j++) {
				if (zelleLebt(i, j)) {
					if (i == reihe & j == spalte) {
						
					}
					else {
						zähler++;
					}
					
				}
			}
		}
		return zähler;
	}
		
		/* ALTERNATIVE FÜR RETURNNACHBARNANZAHL
		// 1. Zelle unten links ist vorhanden
		if (zelleLebt(reihe+1, spalte-1)) {
			zähler++;
		}
		// 2. Zelle unterhalb ist vorhanden
		if (zelleLebt(reihe+1, spalte)) {
			zähler++;
		}
		// 3. Zelle unten rechts ist vorhanden
		if (zelleLebt(reihe-1, spalte+1)) {
			zähler++;
		}
		// _4. Zelle links daneben vorhanden
		if (zelleLebt(reihe, spalte-1)) {
			zähler++;
		}
		// 5. Zelle rechts daneben vorhanden
		if (zelleLebt(reihe, spalte+1)) {
			zähler++;
		}
		// 6. Zelle oben links vorhanden 
		if (zelleLebt(reihe-1, spalte-1)) {
			zähler++;
		}
		// 7. Zelle oberhalb vorhanden
		if (zelleLebt(reihe-1, spalte)) {
			zähler++;
		}
		// 8. Zelle oben rechts vorhanden
		if (zelleLebt(reihe-1, spalte+1)) {
			zähler++;
		}
		
		return zähler;
		*/
	
	/**
	 * Berechnet die Anzahl der Reihen im Spielfeld
	 * @return Gibt die Anzahl der Reihen als Integerwert zurück
	 * @author 2788085
	 */
	public int anzahlReihen () {		
		return Spielfeld.length;
	}
	
	/**
	 * Berechnet die Anzahl der Reihen im Spielfeld
	 * @return Gibt die Anzahl der Reihen als Integerwert zurück
	 * @author 2788085
	 */	
	public int anzahlSpalten () {
		return Spielfeld[0].length;
	}
		
	
}
