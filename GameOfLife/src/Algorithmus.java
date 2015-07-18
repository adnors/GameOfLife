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
	 * Berechnet die naechste Generation und speichert es in aktuellesSpielfeld.
	 * 
	 * @author 7866387
	 */
	public void berechneNaechsteGeneration (boolean bordered ) {
		Spielfeld tempSpielfeld = aktuellesSpielfeld.kopiereSpielfeld();
		int reihe;
		int spalte;
		for (reihe = 0; reihe < tempSpielfeld.maxReihe; reihe++) {
			for (spalte = 0; spalte < tempSpielfeld.maxSpalte; spalte++) {
				bestimmeNeuenZellenStatus(tempSpielfeld, reihe, spalte, bordered);
			}
		}
		aktuellesSpielfeld = tempSpielfeld;
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
	public void bestimmeNeuenZellenStatus (Spielfeld neuesSpielfeld, int reihe, int spalte, boolean bordered) {
		int anzahlNachbarn;
		anzahlNachbarn = aktuellesSpielfeld.returnNachbaranzahl(reihe, spalte, bordered);
		switch (anzahlNachbarn) {
			case 2:
				if (aktuellesSpielfeld.zelleLebt(reihe, spalte)) {
					neuesSpielfeld.altereZelle(reihe, spalte);
				}
				break;
			case 3: 
				if (aktuellesSpielfeld.zelleLebt(reihe, spalte)) {
					neuesSpielfeld.altereZelle(reihe, spalte);
				}
				else {
					neuesSpielfeld.gebaereZelle(reihe, spalte);
				}
				break;
			case 0: case 1: case 4: case 5: case 6: case 7: case 8:
				neuesSpielfeld.toeteZelle(reihe, spalte);
				break;
			default:
				System.err.println("Invalide Anzahl an Zellennachbarn wurde ermittelt!");
				break;
		}
	}
}
