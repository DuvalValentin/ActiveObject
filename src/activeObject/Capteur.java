package activeObject;

public interface Capteur 
{
	void attach(ObserverdeCapteur o);
	void detach(ObserverdeCapteur o);
	Integer getValue();
	void tick();
}