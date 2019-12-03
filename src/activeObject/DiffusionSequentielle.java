package activeObject;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;

public class DiffusionSequentielle implements AlgoDiffusion 
{
	private Set<CanalImp> canals;
	private Capteur capteur;
	private Integer value;
	
	public DiffusionSequentielle(Set<CanalImp> canals) 
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
		System.out.println("Début");
		this.capteur=c;
		value = capteur.getValue();
		Set<ScheduledFuture<Void>> futures = new HashSet<ScheduledFuture<Void>>();
		for(CanalImp canal : canals)
		{
			futures.add(canal.update(capteur));
		}
		
		for(ScheduledFuture<Void> future : futures)
		{
			while(!future.isDone()){}//FIXME ici ça bloque
		}
			
		System.out.println("Salut");
	}
	
	@Override
	public Integer getValue() 
	{
		return value;
	}
}