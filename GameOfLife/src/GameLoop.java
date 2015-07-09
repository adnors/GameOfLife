
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
	
	GameLoop(int delayTime, Algorithmus algo, boolean bordered)
	{
		this.delayTime = delayTime;
		this.algo = algo;
		this.bordered = bordered;
	}
	
    public void run()
    {
    	while(true)
    	{
    		System.out.println("Calculating new generation");
    		algo.berechneNaechsteGeneration(bordered);
    		
    		
    		
    		try{
    			Thread.sleep(delayTime);
    		}
    		catch(Exception e)
    		{
    			
    		}
    	}
    }
}

