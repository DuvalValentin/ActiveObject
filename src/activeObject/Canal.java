package activeObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
/**
 * Sert de proxy entre un capteur et un afficheur
 * @author Valentin
 * @author Fares
 */
public interface Canal extends ObserverDeCapteur
{
	/**
	 * 
	 * @return Une future qui contiendra la valeur du capteur
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	ScheduledFuture<Integer> getValue() throws InterruptedException, ExecutionException;
}