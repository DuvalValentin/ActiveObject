package activeObject;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class Update implements Callable<Void>
{
	private Canal canal ;
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
