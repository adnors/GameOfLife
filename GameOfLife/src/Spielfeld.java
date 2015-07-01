
public class Spielfeld {
	
	/* 2788085
	 * Spielfeld ist ein 2 Dimensionales Array mit den Inhalten vom Objekt Zelle
	 */
	private cell[][] Spielfeld;
	
	
	/* 2788085
	 * Erstellt ein Spielfeld, gefüllt mit Zellen (Mindestalter = 1)
	 * und wird je nach Übergabewert flexibel dimensioniert 
	 * Alle anderen Spielfelder, die keine Zellen enthalten werden 
	 * standardmäßig durch die Null gekennzeichnet 
	 * Übergeben wird die Anzahl der Reihen und Spalten des Spielfelds
	 */
	public Spielfeld(int anzahlSpalte, int anzahlReihe) {
		Spielfeld = new Zelle[anzahlReihe][anzahlSpalte];
	}
	
	/* 2788085
	 * liefert die Zelle in einem angefragten Speicherplatz des Spielfeld-Arrays zurück
	 */
	public Zelle liefereZelleZurueck (int reihe, int spalte) {
		
		return Spielfeld [reihe][spalte];
	} 
		
	/* 2788085
	 * Löscht/Tötet eine Zelle an einer bestimmten Position im Spielfeld
	 */
	public void töteZelle (int reihe, int spalte) {
		
		Spielfeld[reihe][spalte] = null;
	}
	
	/* 2788085
	 * Speichert Zelle im Spielfeldarray
	 * Wird für zwei Methoden benutzt:
	 * - gebäreZelle (Geburt einer neuen Zelle)
	 * - altereZelle (Vorhandene Zelle altert und wird im Array überschrieben)
	 */
	public void speichereZelle (int reihe, int spalte, Zelle z) {
		
		Spielfeld[reihe][spalte] = z;
	}
	
	/* 2788085
	 * Generiert neue Zelle im Spielfeld (Alter = 1)
	 */
	public void gebäreZelle (int reihe, int spalte) {
		
		speichereZelle(reihe, spalte, new Zelle());
	}
	
	/* 2788085
	 * Zelle auf bestimmter Position im Feldarray wird älter
	 * Aufruf: jeweilige Zelle der Reihe und Spalte nehmen 
	 * -> Zelle altern lassen (zaehleAlterHoch) und abspeichern
	 */
	public void altereZelle (int reihe, int spalte) {
		
		speichereZelle(reihe, spalte, liefereZelleZurueck(reihe, spalte).zaehleAlterHoch());
	}
	
	/* 2788085
	 * Gibt zurück, ob eine Zelle lebt (Inhalt = leben)
	 * oder ein Arrayelement kein Inhalt besitzt (Null) 
	 */
	public boolean zelleLebt(int reihe, int spalte) {
		
		if (liefereZelleZurueck(reihe, spalte) != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/* 2788085
	 * Gibt die Anzahl der unmittelbaren lebenden Nachbarn einer Zelle zurück (Maximal 8 Nachbarn)
	 *   6 7 8  
	 *   _ _ _
	 *  |     |
	 * 4|  o  |5
	 *  |_ _ _|
	 *   1 2 3
	 *   
	 *   Zunächst prüft das IF Statement, ob die Positionen rund um die Zelle lebende Zellen sind
	 *   und zählt bei einem Treffer die Zählvariable hoch. Diese wird zum Schluss als Integer Wert zurück gegeben
	 */
	public int returnNachbaranzahl(int reihe, int spalte) {
		
		int zähler = 0; //Zähler auf 0
		
		
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
	}
}
