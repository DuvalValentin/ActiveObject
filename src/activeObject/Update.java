package activeObject;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class Update implements Callable<Void>
{
	private Canal canal ;
	private ObserverDeCapteur ObserverDeCapteur;
	
	public Update(Canal canal, ObserverDeCapteur observerDeCapteur) 
	{
		this.canal=canal;
		this.ObserverDeCapteur=observerDeCapteur;
	}
	
	@Override
	public Void call() throws InterruptedException, ExecutionException 
	{
		ObserverDeCapteur.update(canal);
		return null;
		
	}
	

}
