
public class Feld {
	
	/* 2788085
	 * 
	 */
	private int anzahlSpalte;
	private int anzahlZeile;
	private Zelle[][] Feld;
	
	
	/* 2788085
	 * Erstellt ein SPielfeld, gefüllt mir Zellen (Mindestalter = 1). 
	 * Alle anderen Spielfelder, die keine Zellen enthalten werden 
	 * standardmäßig durch die 0 gekennzeichnet */
	public Feld(int anzahlSpalte, int anzahlReihe) {
		Feld = new Zelle[anzahlSpalte][anzahlReihe];
	}
	
	/* 2788085
	 * liefert die Zelle in einem angefragten Speicherplatz des Arrays zurück
	 */
	public Zelle getZelle (int anzahlSpalte, int anzahlZeile) {
		
		return Feld [anzahlSpalte][anzahlZeile];
	}
	
	/* 2788085
	 * Speichert Zelle im Spielfeld 
	 */
	public void setZelle (int reihe, int spalte, Zelle z) {
		
		Feld[spalte][reihe] = z;
	}
	
	/* 2788085
	 * Generiert neue Zelle im Spielfeld (Alter = 1)
	 */
	public void gebäreZelle (int reihe, int spalte) {
		
		setZelle(reihe, spalte, new Zelle());
	}
	
	/* 2788085
	 * Löscht/Tötet eine Zelle in an einer bestimmten Position im Feld
	 */
	public void töteZelle (int reihe, int spalte) {
		
		Feld[spalte][reihe] = null;
	}
	
	/* 2788085
	 * Zelle wird älter
	 */
	public void altereZelle (int reihe, int spalte) {
		
		setZelle(reihe, spalte, getZelle(reihe, spalte).setAlter());
	}
	
	
}
