package activeObject;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;

public class DiffusionSequentielle implements AlgoDiffusion 
{
	private Set<CanalImp> canals;
	private Capteur capteur;
	private Queue<Integer> listeValeur;
	private int compteurCompteur;
	
	public DiffusionSequentielle(Set<CanalImp> canals) 
	{
		this.canals=canals;
		listeValeur=new PriorityQueue<Integer>(3);
	}

	@Override
	public void configure() 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void execute(Capteur c) 
	{
		if(listeValeur.size()!=3)
		{
			this.capteur=c;
			compteurCompteur++;
			int compteur=0;
			listeValeur.add(capteur.getValue());
			Set<ScheduledFuture<Void>> futures = new HashSet<ScheduledFuture<Void>>();
			for(CanalImp canal : canals)
			{
				compteur++;
				futures.add(canal.update(capteur));
			}
		}
		
	}

	@Override
	public Integer getValue() {
		return listeValeur.poll();
	}
}