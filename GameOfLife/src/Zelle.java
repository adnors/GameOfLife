
public class Zelle {
	
	//gibt Alter der jeweiligen Zelle im Spielfeld an
	private int alter;
	
	//Tote Platzhalter f�r Spielfeld
	public Zelle () {
		
	}
	
	//Lebendige Zellen mit �bergabe des jeweiligen Alters
	public Zelle(int alter) {
		this.alter = alter;
	}
	
	public int getAlter() {
		return alter;
	}
	
	//Zelle wird eine Zeiteinheit �lter
	public void setAlter() {
		alter++;
	}
	
}
