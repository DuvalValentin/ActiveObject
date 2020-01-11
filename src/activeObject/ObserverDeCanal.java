package activeObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
/**
 * Un Observer de Canal
 * @author Valentin
 * @author Fares
 */
public interface ObserverDeCanal
{
	/**
	 * Effectue des actions en rapport avec le canal passé en paramètre
	 * @param  canal 
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	ScheduledFuture<Void> update(Canal canal) throws InterruptedException, ExecutionException;
}