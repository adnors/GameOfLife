
/**
 * Zum Werfen der einzelnen Exception mit eigenem Text
 * @author 1443023
 */
public class MeineException extends Exception{
	//Atribut für die Zusatzinfo
	private String zusatzinfo;
	/**
	 * Weisst die Zusatzinfo vom aufruf dem Fehler zu
	 * @param zusatzinfo Meldung fuer den Fehler
	 * @author 1443023
	 */
	public MeineException(String zusatzinfo)
	{
		this.zusatzinfo = zusatzinfo;
		
	}
	/**
	 * Gibt den Text von der Fehlermeldung zurueck
	 * @return String, welcher die Fehlermeldung passend zu dem Fehler enthaelt
	 * @author 1443023
	 */
	public String getZusatz()
	{
		return this.zusatzinfo;
	}

}
