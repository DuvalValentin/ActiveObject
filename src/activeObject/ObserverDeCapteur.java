package activeObject;
import java.util.concurrent.ScheduledFuture;

public interface ObserverDeCapteur 
{
	/**
	 * Effectue des actions en rapport avec le capteur passé en paramètre
	 * 
	 * @param capteur
	 */
	ScheduledFuture<Void> update(Capteur c);
}