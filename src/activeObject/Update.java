package activeObject;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
/**
 * Demande à un observeur de canal de se mettre à jours lorsque call() est appellée
 * @author Valentin
 * @author Fares
 */
public class Update implements Callable<Void>
{
	/**
	 * Canal dont la valeur doit être récupérée par l'observeur
	 */
	private Canal canal ;
	/**
	 * Observer de canal devant se mettre à jour
	 */
	private ObserverDeCanal observerDeCanal;
	
	
	/**
	 * Un constructeur avec un canal et observeur de canal en paramètre
	 * @param canal
	 * @param observerDeCanal
	*/
	public Update(Canal canal, ObserverDeCanal observerDeCanal) 
	{
		this.canal=canal;
		this.observerDeCanal=observerDeCanal;
	}
	
	
	/**
	 * appelle la methode update sur le observer de canal 
	 */
	@Override
	public Void call() throws InterruptedException, ExecutionException 
	{
		observerDeCanal.update(canal);
		return null;
	}
	

}
