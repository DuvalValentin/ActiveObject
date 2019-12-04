package activeObject;

import java.util.Set;

public interface Capteur 
{
	void attach(ObserverDeCapteur o);
	void detach(ObserverDeCapteur o);
	Set<ObserverDeCapteur> getObervers();
	Integer getValue();
	void tick();
	AlgoDiffusion getAlgo();
	void setAlgo(AlgoDiffusion algo);
}