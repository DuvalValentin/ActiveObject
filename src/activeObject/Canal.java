package activeObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;

public interface Canal 
{
	ScheduledFuture<Void> update(Capteur capteur);
	ScheduledFuture<Integer> getValue() throws InterruptedException, ExecutionException;
}