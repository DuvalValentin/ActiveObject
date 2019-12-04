package activeObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;

public class Afficheur implements ObserverDeCanal{
	
	private Integer value;
   
	/**
	 * @param canal 
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	@Override
	public ScheduledFuture<Void> update(Canal c) throws InterruptedException, ExecutionException 
	{
		value=c.getValue().get();
		System.out.println(this+" : "+value);
		return null;
	}

	 
}