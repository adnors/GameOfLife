
public class Feld {
	
	/* 2788085
	 * 
	 */
	private int anzahlSpalte;
	private int anzahlZeile;
	private Zelle[][] Feld;
	
	
	/* 2788085
	 * Erstellt ein Spielfeld, gef�llt mit Zellen (Mindestalter = 1). 
	 * Alle anderen Spielfelder, die keine Zellen enthalten werden 
	 * standardm��ig durch die 0 (Null) gekennzeichnet */
	public Feld(int anzahlSpalte, int anzahlReihe) {
		Feld = new Zelle[anzahlSpalte][anzahlReihe];
	}
	
	/* 2788085
	 * liefert die Zelle in einem angefragten Speicherplatz des Arrays zur�ck
	 */
	public Zelle getZelle (int reihe, int spalte) {
		
		return Feld [spalte][reihe];
	} 
	
	/* 2788085
	 * Speichert Zelle im Spielfeldarray
	 */
	public void speichereZelle (int reihe, int spalte, Zelle z) {
		
		Feld[spalte][reihe] = z;
	}
	
	/* 2788085
	 * L�scht/T�tet eine Zelle in an einer bestimmten Position im Feld
	 */
	public void t�teZelle (int reihe, int spalte) {
		
		Feld[spalte][reihe] = null;
	}
	
	/* 2788085
	 * Generiert neue Zelle im Spielfeld (Alter = 1)
	 */
	public void geb�reZelle (int reihe, int spalte) {
		
		setZelle(reihe, spalte, new Zelle());
	}
	
	/* 2788085
	 * Zelle auf bestimmter Position im Feldarray wird �lter
	 */
	public void altereZelle (int reihe, int spalte) {
		
		setZelle(reihe, spalte, getZelle(reihe, spalte).setAlter());
	}
	
	/* 2788085
	 * Gibt zur�ck, ob eine Zelle lebt (Inhalt = leben)
	 * oder ein Arrayelement kein Inhalt besitzt (Null) 
	 */
	public boolean zelleLebt(int reihe, int spalte) {
		
		if (getZelle(reihe, spalte) != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/* 2788085
	 * Gibt die Anzahl der unmittelbaren lebenden Nachbarn einer Zelle zur�ck (Maximal 8 Nachbarn)
	 *   1 2 3
	 *   _ _ _
	 *  |     |
	 * 4|  o  |5
	 *  |_ _ _|
	 *   6 7 8
	 */
	public int returnNachbaranzahl(int reihe, int spalte) {
		
		int z�hler = 0; //Z�hler auf 0
		
		// 1. Zelle oben links ist vorhanden
		if (zelleLebt(reihe +1, spalte -1)) {
			z�hler++;
		}
		// 2. Zelle oberhalb ist vorhanden
		if (zelleLebt(reihe +1, spalte)) {
			z�hler++;
		}
		// 3. Zelle oben rechts ist vorhanden
		if (zelleLebt(reihe-1, spalte +1)) {
			z�hler++;
		}
		// _4. Zelle links daneben vorhanden
		if (zelleLebt(reihe, spalte -1)) {
			z�hler++;
		}
		// 5. Zelle rechts daneben vorhanden
		if (zelleLebt(reihe, spalte +1)) {
			z�hler++;
		}
		// 6. Zelle unten links vorhanden 
		if (zelleLebt(reihe -1, spalte -1)) {
			z�hler++;
		}
		// 7. Zelle unterhalb vorhanden
		if (zelleLebt(reihe -1, spalte)) {
			z�hler++;
		}
		// 8. Zelle unten rechts vorhanden
		if (zelleLebt(reihe -1, spalte +1)) {
			z�hler++;
		}
		
		return z�hler;
	}
}
