package activeObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class CanalImp implements Canal
{
	private ScheduledExecutorService scheduler;
	private Capteur capteur;
	private ObserverDeCanal observer;
	
	public CanalImp(ScheduledExecutorService scheduler,ObserverDeCanal observer) 
	{
		this.scheduler=scheduler;
		this.observer=observer;
	}
	public ScheduledFuture<Void> update(Capteur capteur)
	{
		this.capteur=capteur;//FIXME pas fait au bon endroit
		Update update = new Update(this,observer);
		return scheduler.schedule(update,100 , TimeUnit.MILLISECONDS);
	}

	@Override
	public ScheduledFuture<Integer> getValue() throws InterruptedException, ExecutionException
	{
		GetValue getValue = new GetValue(capteur);
		return this.scheduler.schedule(getValue, 100, TimeUnit.MILLISECONDS);
	}
}