package activeObject;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class Main {

	public static void main(String[] args) 
	{
		ScheduledExecutorService scheduler = new ScheduledThreadPoolExecutor(10);
		Afficheur afficheur = new Afficheur();
		Canal canal = new Canal(scheduler,afficheur);
		Capteur capteur = new CapteurImpl(canal);
		capteur.tick();
	}
}
