package activeObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/**
 * Implémentation de l'interface Canal
 * @author Valentin
 * @author Fares
 */
public class CanalImp implements Canal
{
	private ScheduledExecutorService scheduler;
	/**
	 * Le capteur observé par le canal
	 */
	private Capteur capteur;
	/**
	 * L'observeur du canal
	 */
	private ObserverDeCanal observer;
	
	public CanalImp(ScheduledExecutorService scheduler,ObserverDeCanal observer) 
	{
		this.scheduler=scheduler;
		this.observer=observer;
	}
	@Override
	public ScheduledFuture<Void> update(Capteur capteur)
	{
		this.capteur=capteur;
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