package activeObject;

import java.util.concurrent.ExecutionException;

public interface ObserverDeCapteur
{
	void update(Capteur c) throws InterruptedException, ExecutionException;
}