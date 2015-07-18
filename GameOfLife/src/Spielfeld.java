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
	public LebendigesObjekt[][] zellenRaster;
	public int maxSpalte, maxReihe;
	
	/**
	 * Ueberladener Konstruktor zum erstellen eines 2 Dimensionalen Arrays "Spielfeld" vom Datentyp Zelle
	 * mit den Uebergabewerten anzahlSpalte (Anzahl der Spalten) und anzahlReihe (Anzahl der Reihen). 
	 * Das Spielfeld wird hier flexibel dimensioniert und jedes Element mit "Null" gefuellt.
	 * 
	 * @param anzahlSpalte Anzahl der Spalten des Spielfeldes
	 * @param anzahlReihe Anzahl der Reihen des Spielfeldes
	 * @author 2788085
	 */
	public Spielfeld(int anzahlReihe, int anzahlSpalte) {
		zellenRaster = new LebendigesObjekt[anzahlReihe][anzahlSpalte];
		maxSpalte = anzahlSpalte;
		maxReihe = anzahlReihe;
		//System.out.println("AnzReihen: "+anzahlReihe +" AnzSpalt: "+anzahlSpalte) ;
	
	}
	
	/**
	 * Liefert die Zelle an einem bestimmten, angefragten Speicherplatz im Spielfeldarray zurueck
	 * Wenn keine Zelle an diesem Ort vorhanden ist wird NULL zurpck gegeben
	 * 
	 * @param reihe Reihe, in der sich die Zelle im Array befindet
	 * @param spalte Spalte, in der sich die Zelle im Array befindet
	 * @return Gibt die Zelle/NULL an einem bestimmten Ort (Reihe/Spalte) zurueck
	 * @author 2788085
	 */
	public LebendigesObjekt liefereZelleZurueck (int reihe, int spalte) {
		
		return zellenRaster [reihe][spalte];
	} 
		
	/**
	 * Loescht/toetet eine Zelle an einer bestimmten Position im Spielfeld
	 * und ersetzt diese durch NULL
	 * @param reihe Reihe, in der sich die Zelle im Array befindet
	 * @param spalte Spalte, in der sich die Zelle im Array befindet
	 * @author 2788085
	 */
	public void toeteZelle (int reihe, int spalte) { 
		
		zellenRaster[reihe][spalte] = null;
	}
	
	/**
	 * Speichert eine uebergebene Zelle im Spielfeldarray an der Position Spielfeld [reihe][spalte]
	 * Wird fuer folgende Methoden verwendet:
	 * - gebaereZelle (Geburt einer neuen Zelle im Spielfeld)
	 * - altereZelle (Vorhandene Zelle altert und wird im Array ueberschrieben)
	 * 
	 * @param reihe Reihe in der die Zelle gespeichert werden soll
	 * @param spalte Spalte, in der die Zelle gespeichert werden soll
	 * @param z Zelle die gespeichert werden soll
	 * @author 2788085
	 */
	public void speichereZelle (int reihe, int spalte, LebendigesObjekt z) {
		zellenRaster[reihe][spalte] = z;
	}
	
	/**
	 * Generiert eine neue Zelle im Spielfeld
	 * Das Alter der neuen Zelle wird ueber den Standardkonstruktor der Zelle auf 1 gesetzt
	 * 
	 * @param reihe Reihe in der die Zelle gespeichert werden soll
	 * @param spalte Spalte, in der die Zelle gespeichert werden soll
	 * @author 2788085
	 */
	public void gebaereZelle (int reihe, int spalte) {
		
		speichereZelle(reihe, spalte, new Zelle());
	}
	

	/**
	 * Zelle, auf einer bestimmten Position im Array wird um 1 aelter.
	 * 
	 * @param reihe Reihe, der zu alternden Zelle
	 * @param spalte Spalte, der zu alternden Zelle
	 * @author 2788085
	 */
	public void altereZelle (int reihe, int spalte) {
		
		speichereZelle(reihe, spalte, liefereZelleZurueck(reihe, spalte).zaehleAlterHoch());
	}
	
	/**
	 * Prueft ein Arrayelement im Spielfeld, ob dort eine lebende Zelle vorhanden ist.
	 * 
	 * @param reihe Reihe im Spielfeld
	 * @param spalte Spalte im Spielfeld
	 * @return Gibt true zurueck, ob eine Arrayposition eine lebende Zelle beinhaltet (Inhalt = Leben) oder false, wenn ein Arrayelement kein Inhalt bestitzt (NULL)
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
	 * Zunaechst prueft die Methode, ob die Positionen rund um die Zelle lebende Nachbarzellen sind
	 * und zaehlt bei einem Treffer eine Zaehlvariable vom Typ Integer hoch. 
	 * Die betrachtete Zelle selbst wird beim Zaehlen ausgeschlossen.
	 * 
	 * Reihenfolge der Ueberpruefung der Nachbarn (von links oben nach rechts unten):
	 *   1 2 3  
	 *   _ _ _
	 *  |     |
	 * 4|  o  |5
	 *  |_ _ _|
	 *   6 7 8
	 * Spezialfaelle entstehen, wen die zu betrachtende Zelle am Rand des Spielfelds liegt. Insgesamt 8 Spezialfaelle:
	 * - in den vier Ecken des Spielfelds
	 * - an den vier Seitenraendern des Spielfeldes
	 * 
	 * @param reihe Reihenposition im Spielfeld
	 * @param spalte Spaltenposition im Spielfeld
	 * @return Gibt die Anzahl der unmittelbaren lebenden Nachbarn einer Zelle als Integerwert zurueck (Maximal 8 Nachbarn)
	 * @author 2788085, 7866387
	 */
	public int returnNachbaranzahl(int reihe, int spalte, boolean bordered) {
		
		int zaehler = 0; 															//Zaehler auf 0
		

		if (reihe == 0 & spalte == 0) {												//Ecke: OBEN LINKS
			for (int i = (reihe); i < (reihe +2); i++) {
					for (int j = (spalte); j < (spalte +2); j++) {
						
						if (zelleLebt(i, j) && !((i == reihe) && (j == spalte))) { //prueft ob Zelle lebt und nicht sie selbst ist
								zaehler++;
						}
					}
				}
			if (!bordered) {
				if (zelleLebt(maxReihe-1, maxSpalte-1)) {			//pruefe Nachbar 1
					zaehler++;
				}
				if (zelleLebt(maxReihe-1, 0)) {							//pruefe Nachbar 2
					zaehler++;
				}
				if (zelleLebt(maxReihe-1, 1)) {							//pruefe Nachbar 3
					zaehler++;
				}
				if (zelleLebt(0, maxSpalte-1)) {							//pruefe Nachbar 4
					zaehler++;
				}
				if (zelleLebt(1, maxSpalte-1)) {							//pruefe Nachbar 6
					zaehler++;
				}
			}
		}
		else if (reihe == 0 & spalte == zellenRaster[0].length -1) {						//Ecke: OBEN RECHTS
			for (int i = (reihe); i < (reihe +2); i++) {
				for (int j = (spalte -1); j < (spalte +1); j++) {
					
					if (zelleLebt(i, j) && !((i == reihe) && (j == spalte))) { //prueft ob Zelle lebt und nicht sie selbst ist
							zaehler++;
					}
				}
			}
			if (!bordered) {
				if (zelleLebt(maxReihe-1, maxSpalte-2)) {			//pruefe Nachbar 1
					zaehler++;
				}
				if (zelleLebt(maxReihe-1, maxSpalte-1)) {			//pruefe Nachbar 2
					zaehler++;
				}
				if (zelleLebt(maxReihe-1, 0)) {							//pruefe Nachbar 3
					zaehler++;
				}
				if (zelleLebt(0, 0)) {											//pruefe Nachbar 5
					zaehler++;
				}
				if (zelleLebt(1, 0)) {											//pruefe Nachbar 8
					zaehler++;
				}
			}			
		}
		else if (reihe == zellenRaster.length -1 & spalte == 0) {					//Ecke: UNTEN LINKS
			for (int i = (reihe -1); i < (reihe +1); i++) {
				for (int j = (spalte); j < (spalte +2); j++) {
					
					if (zelleLebt(i, j) && !((i == reihe) && (j == spalte))) { //prueft ob Zelle lebt und nicht sie selbst ist
							zaehler++;
					}
				}
			}
			if (!bordered) {
				if (zelleLebt(maxReihe-2, maxSpalte-1)) {			//pruefe Nachbar 1
					zaehler++;
				}
				if (zelleLebt(maxReihe-1, maxSpalte-1)) {			//pruefe Nachbar 4
					zaehler++;
				}
				if (zelleLebt(0, maxSpalte-1)) {							//pruefe Nachbar 6
					zaehler++;
				}
				if (zelleLebt(0, 0)) {											//pruefe Nachbar 7
					zaehler++;
				}
				if (zelleLebt(0, 1)) {											//pruefe Nachbar 8
					zaehler++;
				}
			}		
		}
		else if (reihe == zellenRaster.length -1 & spalte == zellenRaster[0].length -1) {	//Ecke: UNTEN RECHTS
			for (int i = (reihe -1); i < (reihe +1); i++) {
				for (int j = (spalte -1); j < (spalte +1); j++) {
					
					if (zelleLebt(i, j) && !((i == reihe) && (j == spalte))) { //prueft ob Zelle lebt und nicht sie selbst ist
							zaehler++;
					}
				}
			}
			if (!bordered) {
				if (zelleLebt(maxReihe-2, 0)) {							//pruefe Nachbar 3
					zaehler++;
				}
				if (zelleLebt(maxReihe-1, 0)) {							//pruefe Nachbar 5
					zaehler++;
				}
				if (zelleLebt(0, maxSpalte-2)) {							//pruefe Nachbar 6
					zaehler++;
				}
				if (zelleLebt(0, maxSpalte-1)) {							//pruefe Nachbar 7
					zaehler++;
				}
				if (zelleLebt(0, 0)) {											//pruefe Nachbar 8
					zaehler++;
				}
			}
		}
		else if (spalte == zellenRaster[0].length -1) {									//Seite: RECHTS
			for (int i = (reihe -1); i < (reihe +2); i++) {
				for (int j = (spalte -1); j < (spalte +1); j++) {
					
					if (zelleLebt(i, j) && !((i == reihe) && (j == spalte))) { //prueft ob Zelle lebt und nicht sie selbst ist
							zaehler++;
					}
				}
			}
			if (!bordered) {
				for (int k = (reihe -1); k < (reihe +2); k++) {
					if (zelleLebt(k, 0)) {											//pruefe Nachbar 3, 5, 8
						zaehler++;
					}
				}
			}
		}
		else if (reihe == zellenRaster.length -1) {									//Seite: UNTEN
			for (int i = (reihe -1); i < (reihe +1); i++) {
				for (int j = (spalte -1); j < (spalte +2); j++) {
					
					if (zelleLebt(i, j) && !((i == reihe) && (j == spalte))) { //prueft ob Zelle lebt und nicht sie selbst ist
							zaehler++;
					}
				}
			}	
			if (!bordered) {
				for (int k = (spalte -1); k < (spalte +2); k++) {
					if (zelleLebt(0, k)) {											//pruefe Nachbar 6, 7, 8
						zaehler++;
					}
				}
			}
		}
		else if (spalte == 0) {														//Seite: LINKS
			for (int i = (reihe -1); i < (reihe +2); i++) {
				for (int j = (spalte); j < (spalte +2); j++) {
					
					if (zelleLebt(i, j) && !((i == reihe) && (j == spalte))) { //prueft ob Zelle lebt und nicht sie selbst ist
							zaehler++;
					}
				}
			}	
			if (!bordered) {
				for (int k = (reihe -1); k < (reihe +2); k++) {
					if (zelleLebt(k, maxSpalte-1)) {							//pruefe Nachbar 1, 4, 6
						zaehler++;
					}
				}
			}
		}
		else if (reihe == 0) {														//Seite: OBEN
			for (int i = (reihe); i < (reihe +2); i++) {
				for (int j = (spalte -1); j < (spalte +2); j++) {
					
					if (zelleLebt(i, j) && !((i == reihe) && (j == spalte))) { //prueft ob Zelle lebt und nicht sie selbst ist
							zaehler++;
					}
				}
			}	
			if (!bordered) {
				for (int k = (spalte -1); k < (spalte +2); k++) {
					if (zelleLebt(maxReihe-1, k)) {							//pruefe Nachbar 1, 2, 3
						zaehler++;
					}
				}
			}
		}
		else {																		//Kein Spezialfall
			for (int i = (reihe -1); i < (reihe +2); i++) {
				for (int j = (spalte -1); j < (spalte +2); j++) {
					
					if (zelleLebt(i, j) && !((i == reihe) && (j == spalte))) { //prueft ob Zelle lebt und nicht sie selbst ist
							zaehler++;
					}
				}
			}					
		}
		
		

		return zaehler;																//Rueckgabe Anzahl der Nachbarn
	}
	
	/**
	 * Berechnet die Anzahl der Reihen im Spielfeld
	 * @return Gibt die Anzahl der Reihen als Integerwert zurueck
	 * @author 2788085
	 */
	public int anzahlReihen () {		
		return zellenRaster.length;
	}
	
	/**
	 * Berechnet die Anzahl der Spalten im Spielfeld
	 * @return Gibt die Anzahl der Spalten als Integerwert zurueck
	 * @author 2788085
	 */	
	public int anzahlSpalten () {
		return zellenRaster[0].length;
	}
		
	/**
	 * Kopiert das Spielfeld und gibt es zurück.
	 * @return Gibt das kopierte Spielfeld zurück
	 * @author 7866387
	 */
	public Spielfeld kopiereSpielfeld () {
		Spielfeld kopie = new Spielfeld(maxReihe, maxSpalte);
		for (int i = 0; i < maxReihe; i++){
			for (int j = 0; j < maxSpalte; j++){
				kopie.zellenRaster[i][j] = this.liefereZelleZurueck(i, j);
			}
		}
		return kopie;
	}
}
