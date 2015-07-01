
public class Zelle {
	
	/* 2788085
	 * gibt Alter der jeweiligen Zelle im Spielfeld an*/
	private int alter;
	
	/* 2788085
	 * Standardkonstruktor für Zelle mit dem Alter 1 */
	public Zelle () {
		this.alter = 1;
	}
	
	/* 2788085
	 * Lebendige Zellen mit Übergabe des jeweiligen Alters
	 */
	public Zelle(int alter) {
		this.alter = alter;
	}
	
	/* 2788085
	 * Gibt das aktuelle Alter einer Zelle zurück */
	public int getAlter() {
		return alter;
	}
	
	/* 2788085
	Zelle wird eine Zeiteinheit älter*/
	public Zelle zaehleAlterHoch() {
		alter++;
		return this;
	}
	

}
