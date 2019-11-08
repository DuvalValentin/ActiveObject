package activeObject;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class Main {

	public static void main(String[] args) 
	{
		Capteur capteur = new CapteurImpl();
		ScheduledExecutorService scheduler = new ScheduledThreadPoolExecutor(30);
		Canal canal = new Canal(scheduler);
		
		Afficheur afficheur1 = new Afficheur();
		Afficheur afficheur2 = new Afficheur();
		
		capteur.attach(canal);
		
		canal.attach(afficheur1);
		canal.attach(afficheur2);
		
		for(int i =0;i<10;i++)
		{
			capteur.tick();
		}
		
	}
}