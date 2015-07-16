/**
 * Die Klasse Konsole gibt nach jedem berechneten Feld das gesamte Feld in der Konsole aus:
 * ' ': Keine Zelle
 * '.': Zelle mit Alter = 1
 * '+': Zelle mit Alter = 2
 * '*': Zelle mit Alter = 3
 * '#': Zelle mit Alter = 4
 * @author 2788085
 *
 */
public class Konsole extends Ausgabe {

	
	/**
	 * Zeichenarray, das zur Ausgabe des Spielfelds über die Konsole verwendet werden
	 * ' ': Keine Zelle
	 * '.': Zelle mit Alter = 1
	 * '+': Zelle mit Alter = 2
	 * '*': Zelle mit Alter = 3
	 * '#': Zelle mit Alter = 4
	 * @author 2788085
	 */
		
	private char [] Zeichenarray = { ' ', '.' , '+' , '*' , '#'};
	
	public Konsole() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Gibt das aktuell berechnete Spielfeld zurück
	 * @param feld Aktuelles berechnetes Feld, welches ausgegeben wird
	 * @author 2788085
	 */
	
	@Override 
	public void zeichneArray (Spielfeld feld) {
		for (int i = 0; i < feld.anzahlReihen(); i++) {			//Geht Reihen nacheinander durch 
			for (int j = 0; j < feld.anzahlSpalten(); j++) {	//Geht einzelne Elemente in der Reihe durch
				if (feld.zelleLebt(i, j)) {						//Wenn Zelle lebt, gebe entsprechendes Zeichen, abh�ngig vom Alter der Zelle, aus dem Zeichenarray aus
					switch (feld.liefereZelleZurueck(i, j).getAlter()) {
					case 1:
						System.out.print(Zeichenarray[1]);		//Alter = 1
						break;
					case 2:
						System.out.print(Zeichenarray[2]);		//Alter = 2
						break;
					case 3:
						System.out.print(Zeichenarray[3]);		//Alter = 3
						break;
					case 4:
						System.out.print(Zeichenarray[4]);		//Alter = 4
						break;
					default:
						System.out.print(Zeichenarray[4]);		//Alter gr��er als 4
						break;
					}
				}
				else {											//Wenn keine Zelle auf der Position [i][j] vorhanden ist, gebe Zeichen ' ' aus
					System.out.print(Zeichenarray[0]);
				}
			} 
			System.out.print("\n");								//Nach jedem Durchlauf einer Reihe einen Zeilenumbruch ausgeben
		}
	}

}