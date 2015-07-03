
/**
 * @author 7866387
 *
 */
public class Algorithmus {
	
	private Spielfeld aktuellesSpielfeld; // Abspeichern des Spielfelds
	
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
	public void berechneNaechsteGeneration () {
		Spielfeld tempSpielfeld = aktuellesSpielfeld;
		
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
	public Zelle bestimmeNeuenZellenStatus (int reihe, int spalte) {
		Zelle aktuelleZelle;
		int anzahlNachbarn;
		aktuelleZelle = aktuellesSpielfeld.liefereZelleZurueck(reihe, spalte);
		anzahlNachbarn = aktuellesSpielfeld.returnNachbaranzahl(reihe, spalte);
		switch (anzahlNachbarn) {
			case 2: case 3: 
				aktuelleZelle.zaehleAlterHoch();
				break;
			case 0: case 1: case 4: case 5: case 6: case 7: case 8:
				aktuelleZelle = aktuelleZelle.toeteZelle();
				break;
			default:
				System.err.println("Invalide Anzahl an Zellennachbarn wurde ermittelt!");
				break;
		}
		return aktuelleZelle;
	}
	
}