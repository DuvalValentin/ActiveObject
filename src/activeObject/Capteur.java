package activeObject;

import java.util.concurrent.ScheduledFuture;

public interface Capteur 
{
	void attach(ObserverdeCapteur o);
	void detach(ObserverdeCapteur o);
	ScheduledFuture<Integer> getValue();
	void tick();
}