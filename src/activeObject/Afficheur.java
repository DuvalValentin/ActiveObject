package activeObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;

public class Afficheur implements ObserverDeCanal{
	private Integer value;

	@Override
	public ScheduledFuture<Void> update(CanalImp c) throws InterruptedException, ExecutionException 
	{
		value=c.getValue().get();
		System.out.println(this+" : "+value);
		return null;
	}
}