package activeObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Canal implements Capteur,ObserverDeCapteur
{
	private ScheduledExecutorService scheduler;
	private Capteur capteur;
	private ObserverDeCapteur observer;
	
	public Canal(ScheduledExecutorService scheduler) 
	{
		this.scheduler=scheduler;
	}
	public ScheduledFuture<Void> update(Capteur c)
	{
		capteur=c;//FIXME pas fait au bon endroit
		Update update = new Update(this,observer);
		return scheduler.schedule(update,0 , TimeUnit.MILLISECONDS);
	}

	@Override
	public void attach(ObserverDeCapteur o) 
	{
		observer=o;
	}

	@Override
	public void detach(ObserverDeCapteur o) 
	{
		observer=null;	
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