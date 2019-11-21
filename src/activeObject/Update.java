package activeObject;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class Update implements Callable<Void>
{
	private CanalImp canal ;
	private ObserverDeCanal observerDeCanal;
	
	public Update(CanalImp canal, ObserverDeCanal observerDeCanal) 
	{
		this.canal=canal;
		this.observerDeCanal=observerDeCanal;
	}
	
	@Override
	public Void call() throws InterruptedException, ExecutionException 
	{
		observerDeCanal.update(canal);
		return null; //FIXME retourner qqchose ici
	}
	

}
