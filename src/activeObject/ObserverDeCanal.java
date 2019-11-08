package activeObject;

import java.util.concurrent.ExecutionException;

public interface ObserverDeCanal 
{
	void update(Canal c) throws InterruptedException, ExecutionException;
}
