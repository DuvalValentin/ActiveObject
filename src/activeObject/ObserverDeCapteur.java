package activeObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;

public interface ObserverDeCapteur
{
	ScheduledFuture<Void> update(Capteur c) throws InterruptedException, ExecutionException;
}