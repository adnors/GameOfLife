/**
 * @author 7866387
 */
public class Algorithmus {
	
	protected Spielfeld aktuellesSpielfeld; // Abspeichern des Spielfelds
	
	/**
	 * Konstruktor
	 * 
	 * @param s Uebergabe des Spielfelds
	 * @author 7866387
	 */
	public Algorithmus (Spielfeld s) {
		this.aktuellesSpielfeld = s;
	}
	
	/**
	 * Berechnet die naechste Generation und ueberschreibt dabei das Spielfeld.
	 * 
	 * @author 7866387
	 */
	public void berechneNaechsteGeneration (boolean bordered ) {
		int reihe;
		int spalte;
		for (reihe = 0; reihe < aktuellesSpielfeld.reihe; reihe++) {
			for (spalte = 0; spalte < aktuellesSpielfeld.spalte; spalte++) {
				bestimmeNeuenZellenStatus(reihe, spalte, bordered);
			}
		}
	}
	
	/**
	 * Berechnet den Status einer Zelle in der naechsten Generation.
	 * Hilfsmethode fuer berechneNaechsteGeneration()
	 * 
	 * @param reihe Reihe der zu bearbeitenden Zelle
	 * @param spalte Spalte der zu bearbeitenden Zelle
	 * @return Gibt die veraenderte Zelle zurueck.
	 * @author 7866387
	 */
	public void bestimmeNeuenZellenStatus (int reihe, int spalte, boolean bordered) {
		int anzahlNachbarn;
		anzahlNachbarn = aktuellesSpielfeld.returnNachbaranzahl(reihe, spalte, bordered);
		switch (anzahlNachbarn) {
			case 2: case 3: 
				if (aktuellesSpielfeld.zelleLebt(reihe, spalte)) {
					aktuellesSpielfeld.altereZelle(reihe, spalte);
				}
				else {
					aktuellesSpielfeld.gebaereZelle(reihe, spalte);
				}
				break;
			case 0: case 1: case 4: case 5: case 6: case 7: case 8:
				aktuellesSpielfeld.toeteZelle(reihe, spalte);
				break;
			default:
				System.err.println("Invalide Anzahl an Zellennachbarn wurde ermittelt!");
				break;
		}
	}
}
