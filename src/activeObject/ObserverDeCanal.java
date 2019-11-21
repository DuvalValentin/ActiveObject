package activeObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;

public interface ObserverDeCanal
{
	ScheduledFuture<Void> update(CanalImp c) throws InterruptedException, ExecutionException;
}