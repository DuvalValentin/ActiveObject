package activeObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;

public class Afficheur implements ObserverDeCapteur{
	private Integer value;

	@Override
	public ScheduledFuture<Void> update(Capteur c) throws InterruptedException, ExecutionException 
	{
		value=c.getValue();
		System.out.println(this+" : "+value);
		return null;
	}
}