
public class Zelle {
	
	//gibt Alter der jeweiligen Zelle im Spielfeld an
	private int alter;
	
	//Tote Platzhalter für Spielfeld
	public Zelle () {
		
	}
	
	//Lebendige Zellen mit Übergabe des jeweiligen Alters
	public Zelle(int alter) {
		this.alter = alter;
	}
	
	public int getAlter() {
		return alter;
	}
	
	//Zelle wird eine Zeiteinheit älter
	public void setAlter() {
		alter++;
	}
	
}
