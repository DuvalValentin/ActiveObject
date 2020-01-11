package activeObject;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;

/**
 * Diffusion pemettant au Capteur à se mettre à jour même si les afficheurs n'on pas encore affiché de valeurs. Les afficheurs doivent à un instant t afficher la même valeur.
 * @author Valentin
 * @author Fares
*/
public class DiffusionSequentielle implements AlgorithmeDiffusion 
{
	/**
	 * Capteur dont on doit diffuser la valeur
	 */
	private Capteur capteur;
	/**
	 * Valeur qui doit être affichée
	 */
	private Integer value;
	/**
	 * Indique si une diffusion est déjà en cours
	 */
	private boolean executing;
	/**
	 * Compte le nombre de canaux ayant fait passer la valeur du capteur
	 */
	private int compteur;
	/**
	 * Nombre total de canaux
	 */
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