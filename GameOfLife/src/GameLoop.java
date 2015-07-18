import java.awt.Container;
import java.io.FileNotFoundException;

/**
 * Zum Starten des Spieles GameOfLife..
 * 
 * @author 2552171
 *
 */
public class GameLoop implements Runnable
{
	private int delayTime;
	private Algorithmus algo;
	private boolean bordered;
	private Konsole konsole = new Konsole();
	private boolean guienabled;
	
	public GameLoop(String delayTime, Algorithmus algo, boolean guienabled, boolean bordered)  throws java.lang.NumberFormatException
	{
try {
			int a = Integer.parseInt(delayTime);
			this.delayTime = Integer.parseInt(delayTime);
			this.algo = algo;
			this.guienabled = guienabled;
			this.bordered = bordered;
		} catch (NumberFormatException k) {
			// Falsche Verzoegerungszeit: Fehlermeldung ausgeben und abbrechen
			System.out.println("Die Verzögerungszeit ist falsch eingegeben, bitte stellen Sie sicher, dass es sich um ein Integerwert handelt");
		}
	} 
	
    public void run()
    {
    	FrameContainer container = null;
    	if (guienabled) {
    		container = new FrameContainer(algo.aktuellesSpielfeld);
		}
    	
    	while(true)
    	{
    		
    		algo.berechneNaechsteGeneration(bordered);
    		if(guienabled)
    		{
        		container.zeichneArray(algo.aktuellesSpielfeld);

   
    		}
    		else
    		{
    			konsole.zeichneArray(algo.aktuellesSpielfeld); 
    		}
    		
    		
    		try{
    			Thread.sleep(delayTime);
    		}
    		catch(Exception e)
    		{
    			
    		}
    	}
    }
}

