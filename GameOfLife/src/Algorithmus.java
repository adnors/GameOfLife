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
		Spielfeld tempSpielfeld = aktuellesSpielfeld.kopiereSpielfeld();
		int reihe;
		int spalte;
		for (reihe = 0; reihe < tempSpielfeld.reihe; reihe++) {
			for (spalte = 0; spalte < tempSpielfeld.spalte; spalte++) {
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
	public void bestimmeNeuenZellenStatus (Spielfeld dasSpielfeld, int reihe, int spalte, boolean bordered) {
		int anzahlNachbarn;
		anzahlNachbarn = aktuellesSpielfeld.returnNachbaranzahl(reihe, spalte, bordered);
		switch (anzahlNachbarn) {
			case 0: 
				dasSpielfeld.toeteZelle(reihe, spalte);
				break;
			case 1:
				dasSpielfeld.toeteZelle(reihe, spalte);
				break;
			case 2:
				if (aktuellesSpielfeld.zelleLebt(reihe, spalte)) {
					dasSpielfeld.altereZelle(reihe, spalte);
				}
				break;
			case 3: 
				if (aktuellesSpielfeld.zelleLebt(reihe, spalte)) {
					dasSpielfeld.altereZelle(reihe, spalte);
				}
				else {
					dasSpielfeld.gebaereZelle(reihe, spalte);
				}
				break;
			
			case 4:
				dasSpielfeld.toeteZelle(reihe, spalte);
				break;
			case 5:
				dasSpielfeld.toeteZelle(reihe, spalte);
				break;
			case 6:
				dasSpielfeld.toeteZelle(reihe, spalte);
				break;
			case 7:
				dasSpielfeld.toeteZelle(reihe, spalte);
				break;
			case 8:
				dasSpielfeld.toeteZelle(reihe, spalte);
				break;
			default:
				System.err.println("Invalide Anzahl an Zellennachbarn wurde ermittelt!");
				break;
		}
	}
}
