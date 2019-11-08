package activeObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Canal implements Capteur,ObserverdeCapteur
{
	private ScheduledExecutorService scheduler;
	private Afficheur afficheur;
	private Capteur capteur;
	
	public Canal(ScheduledExecutorService scheduler,Afficheur afficheur) 
	{
		this.scheduler=scheduler;
		this.afficheur=afficheur;
	}
	public void update(Capteur c)
	{
		this.capteur=c;
		Update<Capteur> update = new Update<Capteur>(this,afficheur);//FIXME mauvais type
		this.scheduler.schedule(update,0 , TimeUnit.MILLISECONDS);
	}

	@Override
	public void attach(ObserverdeCapteur o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detach(ObserverdeCapteur o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getValue() throws InterruptedException, ExecutionException
	{
		GetValue getValue = new GetValue(capteur);
		return this.scheduler.schedule(getValue, 0, TimeUnit.MILLISECONDS).get();
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
	

}
