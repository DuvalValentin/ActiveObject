package activeObject;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;

public class DiffusionSequentielle implements AlgoDiffusion 
{
	private Set<CanalImp> canals;
	private Capteur capteur;
	private Integer value;
	private int i;
	
	public DiffusionSequentielle(Set<CanalImp> canals) 
	{
		this.canals=canals;
		this.i=0;
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
			this.i++;
			if(i==2) {
			for(ScheduledFuture<Void> future : futures)
			{
				while(!future.isDone()){}//FIXME ici ça bloque
			}
			this.i=0;
			}
			
		}
		
		
			
		System.out.println("coucou");
	}
	
	@Override
	public Integer getValue() 
	{
		return value;
	}
}