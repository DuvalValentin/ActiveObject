package activeObject;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;

public class DiffusionAtomique implements AlgoDiffusion  
{
	private Capteur capteur;
	
	public DiffusionAtomique() {}

	@Override
	public void configure(Capteur capteur) 
	{
		this.capteur=capteur;
		capteur.setAlgo(this);
	}

	@Override
	public void execute() 
	{
		Set<ObserverDeCapteur> observerDeCapteurs = capteur.getObervers();
		Set<ScheduledFuture<Void>> futures = new HashSet<ScheduledFuture<Void>>();
		for(ObserverDeCapteur observerDeCapteur : observerDeCapteurs)
		{
			futures.add(observerDeCapteur.update(capteur));
		}
		
		for(ScheduledFuture<Void> future : futures)
		{
			try {
				future.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Integer getValue() 
	{
		return capteur.getValue();
	}

}
