package activeObject;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class Update implements Callable<Integer> //FIXME régler le type d'update
{
	private Canal canal ;
	private ObserverDeCapteur observerDeCapteur;
	
	public Update(Canal canal, ObserverDeCapteur observerDeCapteur) 
	{
		this.canal=canal;
		this.observerDeCapteur=observerDeCapteur;
	}
	
	@Override
	public Integer call() throws InterruptedException, ExecutionException 
	{
		observerDeCapteur.update(canal);
		return null; //FIXME retourner qqchose ici
		
	}
	

}
