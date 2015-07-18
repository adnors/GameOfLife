import java.awt.Container;

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
	
	public GameLoop(int delayTime, Algorithmus algo, boolean guienabled, boolean bordered)
	{
		this.delayTime = delayTime;
		this.algo = algo;
		this.guienabled = guienabled;
		this.bordered = bordered;
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

