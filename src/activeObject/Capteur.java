package activeObject;

import java.util.concurrent.ExecutionException;

public interface Capteur 
{
	void attach(ObserverDeCapteur o);
	void detach(ObserverDeCapteur o);
	Integer getValue() throws InterruptedException, ExecutionException;
	void tick();
}