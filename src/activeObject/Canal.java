package activeObject;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Canal implements Capteur,ObserverdeCapteur
{
	private ScheduledExecutorService scheduler;
	private Afficheur afficheur;
	
	public Canal(ScheduledExecutorService scheduler,Afficheur afficheur) 
	{
		this.scheduler=scheduler;
		this.afficheur=afficheur;
	}
	public void update(Capteur c)
	{
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
	public Integer getValue() 
	{
		new GetValue();
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
	

}
