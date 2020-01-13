package activeObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.logging.Logger;

import main.Main;
/**
 * Affiche les valeurs d'un capteur
 * @author Valentin
 * @author Fares
 */
public class Afficheur implements ObserverDeCanal
{
	/**
	 * Nombre d'instances de cette classe créés
	 */
	private static int nombreAfficheurs=0;
	
	public static final Logger logger=Main.logger;
	/**
	 * Numéro de l'afficheur
	 */
	private int id;
	
	/**
	 * 
	 */
	public Afficheur()
	{
		nombreAfficheurs++;
		id=nombreAfficheurs;
		
	}
	
	/**
	 * Valeur que l'afficheur doit afficher
	 */
	private Integer value;
   
	/**
	 * @param canal canal sur lequel on vient lire une valeur
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	@Override
	public ScheduledFuture<Void> update(Canal canal) throws InterruptedException, ExecutionException 
	{
		value=canal.getValue().get();
		String message = this+" : "+value;
		logger.info(message);
		return null;
	}
	/**
	 * @return Description de l'Afficheur
	 */
	@Override
	public String toString()
	{
		return ("Afficheur "+id);
	}
}