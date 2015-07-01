
public class Zelle {
	
	/* 2788085
	 * gibt Alter der jeweiligen Zelle im Spielfeld an*/
	private int alter;
	
	/* 2788085
	 * Standardkonstruktor f�r Zelle mit dem Alter 1 */
	public Zelle () {
		this.alter = 1;
	}
	
	/* 2788085
	 * Lebendige Zellen mit �bergabe des jeweiligen Alters
	 */
	public Zelle(int alter) {
		this.alter = alter;
	}
	
	/* 2788085
	 * Gibt das aktuelle Alter einer Zelle zur�ck */
	public int getAlter() {
		return alter;
	}
	
	/* 2788085
	Zelle wird eine Zeiteinheit �lter*/
	public Zelle zaehleAlterHoch() {
		alter++;
		return this;
	}
	

}
