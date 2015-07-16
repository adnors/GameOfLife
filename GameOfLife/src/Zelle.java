/**
 * Eine Zelle ist ein lebendes Objekt, mit der Eigenschaft zu altern.
 * Eine geborene Zelle hat das Alter 1. Die Klasse Zelle dient als Grundlage
 * fuer das erstellen eines Spielfelds, als Array, bestehend aus Zellen.
 * 
 * @author 2788085
 *
 */
public class Zelle implements LebendigesObjekt {
	
	/**
	 * Deklarieren der Variable alter, als Eigenschaft einer Zelle. 
	 * Sie gibt das jeweilige Alter der Zelle im Spielfeld an.
	 * @author 2788085
	 */
	private int alter;
	
	/**
	 * Standardkonstruktor, ohne Uebergabewert. Eine neu erstellte Zelle hat 
	 * immer das Alter 1
	 * 
	 * @author 2788085
	 */
	public Zelle () {
		this.alter = 1;
	}
	
	/**
	 * Ueberladener Konstruktor dient zur Erstellung einer Zelle mit bestimmtem Alter.
	 * @param alter Alter einer Zelle
	 * @author 2788085
	 */
	public Zelle(int alter) {
		this.alter = alter;
	}
	
	/**
	 * Methode zur Bestimmung des Alters einer Zelle
	 * @return Gibt das aktuelle Alter einer Zelle als Integerwert zurueck
	 * @author 2788085
	 */
	public int getAlter() {
		return alter;
	}
	
	/**
	 * Laesst das Alter einer bestehenden Zelle um 1 erhoehen
	 * @return Gibt das Aktuelle Alter + 1 zurueck
	 * @author 2788085
	 */
	public Zelle zaehleAlterHoch() {
		alter++;
		return this;
	}
	
	/**
	 * Tötet eine Zelle
	 * @return Gibt eine "tote" Zelle zurück
	 * @author 2788085
	 * @return 
	 */
	public Zelle toeteZelle() {
		return null;
	}

}
