package activeObject;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;

public class DiffusionSequentielle implements AlgoDiffusion 
{
	private Capteur capteur;
	private Integer value;
	private boolean executing;
	private int compteur;
	private int nbCanaux;
	
	public DiffusionSequentielle() 
	{
		this.executing=false;
		compteur=0;
	}

	@Override
	public void configure(Capteur capteur) 
	{
		this.capteur=capteur;
		capteur.setAlgo(this);
	}

	@Override
	public void execute() 
	{	
		if(!executing)
		{
			executing=true;
			Set<ObserverDeCapteur> observerDeCapteurs=capteur.getObervers();
			nbCanaux=observerDeCapteurs.size();
			value = capteur.getValue();
			Set<ScheduledFuture<Void>> futures = new HashSet<ScheduledFuture<Void>>();
			for(ObserverDeCapteur observerDeCapteur : observerDeCapteurs)
			{
				futures.add(observerDeCapteur.update(capteur));
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