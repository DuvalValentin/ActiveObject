package activeObject;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;

public class DiffusionAtomique implements AlgoDiffusion  
{
	private Set<CanalImp> canals;
	private Capteur capteur;
	
	public DiffusionAtomique(Set<CanalImp> canals) 
	{
		this.canals=canals;
	}

	@Override
	public void configure() 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void execute(Capteur c) 
	{
		capteur=c;
		Set<ScheduledFuture<Void>> futures = new HashSet<ScheduledFuture<Void>>();
		for(CanalImp canal : canals)
		{
			futures.add(canal.update(capteur));
		}
		
		for(ScheduledFuture<Void> future : futures)
		{
			try {
				future.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Integer getValue() 
	{
		return capteur.getValue();
	}

}
