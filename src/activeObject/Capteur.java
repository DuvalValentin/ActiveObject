package activeObject;

public interface Capteur 
{
	void attach(ObserverDeCapteur o);
	void detach(ObserverDeCapteur o);
	Integer getValue();
	void tick();
	AlgoDiffusion getAlgo();
}