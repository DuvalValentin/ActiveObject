package activeObject;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;

public class DiffusionSequentielle implements AlgoDiffusion 
{
	private Set<CanalImp> canals;
	private Capteur capteur;
	private Integer value;
	private boolean executing;
	private int compteur;
	private int nbCanaux;
	
	public DiffusionSequentielle(Set<CanalImp> canals) 
	{
		this.canals=canals;
		this.executing=false;
		this.compteur=0;
		this.nbCanaux=canals.size();
	}

	@Override
	public void configure() 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void execute(Capteur c) 
	{	
		if(!executing)
		{
			executing=true;
			this.capteur=c;
			value = capteur.getValue();
			Set<ScheduledFuture<Void>> futures = new HashSet<ScheduledFuture<Void>>();
			for(CanalImp canal : canals)
			{
				futures.add(canal.update(capteur));
			}
		}
	}
	
	@Override
	public Integer getValue() 
	{
		compteur++;
		if(compteur==nbCanaux)
		{
			compteur=0;
			executing=false;
		}
		
		return value;
	}
}