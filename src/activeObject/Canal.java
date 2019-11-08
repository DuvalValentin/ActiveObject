package activeObject;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Canal implements Capteur,ObserverDeCapteur
{
	private ScheduledExecutorService scheduler;
	private Capteur capteur;
	private Set<ObserverDeCapteur> observers;
	
	public Canal(ScheduledExecutorService scheduler) 
	{
		this.scheduler=scheduler;
		observers = new HashSet<ObserverDeCapteur>();
	}
	public void update(Capteur c)
	{
		this.capteur=c;//FIXME pas fait au bon endroit
		for(ObserverDeCapteur observer:observers)
		{
			Update update = new Update(this,observer);
			this.scheduler.schedule(update,0 , TimeUnit.MILLISECONDS);
		}
	}

	@Override
	public void attach(ObserverDeCapteur o) 
	{
		observers.add(o);
	}

	@Override
	public void detach(ObserverDeCapteur o) 
	{
		observers.remove(o);	
	}

	@Override
	public Integer getValue() throws InterruptedException, ExecutionException
	{
		GetValue getValue = new GetValue(capteur);
		return this.scheduler.schedule(getValue, 0, TimeUnit.MILLISECONDS).get();
	}

	@Override
	public void tick() 
	{
		// TODO Aucune idée ici
	}
}