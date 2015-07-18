
/**
 * Zum Starten des Spieles GameOfLife.
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
    	while(true)
    	{
    		
    		algo.berechneNaechsteGeneration(bordered);
    		if(guienabled)
    		{ 
    			FrameContainer container = new FrameContainer(algo.aktuellesSpielfeld);
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

