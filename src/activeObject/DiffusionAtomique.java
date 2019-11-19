package activeObject;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;

public class DiffusionAtomique implements AlgoDiffusion  
{
	private Set<Canal> canals;
	private Capteur capteur;
	
	public DiffusionAtomique(Set<Canal> canals) 
	{
		this.canals=canals;
	}

	@Override
	public void configure() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute(Capteur c) 
	{
		capteur=c;
		Set<ScheduledFuture<Void>> futures = new HashSet<ScheduledFuture<Void>>();
		for(Canal canal : canals)
		{
			futures.add(canal.update(capteur));
		}
		
		for(ScheduledFuture<Void> future : futures)
		{
			try {
				future.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public Integer getValue() 
	{
		Integer value = null;
		try {
			value =  capteur.getValue();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

}
