package activeObject;

import java.util.concurrent.ExecutionException;

public interface Capteur 
{
	void attach(ObserverdeCapteur o);
	void detach(ObserverdeCapteur o);
	Integer getValue() throws InterruptedException, ExecutionException;
	void tick();
}