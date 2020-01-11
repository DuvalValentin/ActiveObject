package activeObject;
import java.util.concurrent.ScheduledFuture;
/**
 * Un Observer de Capteur
 * @author Valentin
 * @author Fares
 */
public interface ObserverDeCapteur 
{
	/**
	 * Effectue des actions en rapport avec le capteur passé en paramètre
	 * @param capteur
	 */
	ScheduledFuture<Void> update(Capteur capteur);
}