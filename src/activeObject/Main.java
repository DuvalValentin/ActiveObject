package activeObject;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class Main {

	public static void main(String[] args) 
	{
		ScheduledExecutorService scheduler = new ScheduledThreadPoolExecutor(30);
		Canal canal1 = new Canal(scheduler);
		Canal canal2 = new Canal(scheduler);
		Set<Canal> canals = new HashSet<Canal>();
		canals.add(canal1);
		canals.add(canal2);
		DiffusionAtomique diffusionAtomique=new DiffusionAtomique(canals);
		Capteur capteur = new CapteurImpl(diffusionAtomique);
		
		Afficheur afficheur1 = new Afficheur();
		Afficheur afficheur2 = new Afficheur();
		
		//capteur.attach(canal);
		canal1.attach(afficheur1);
		canal2.attach(afficheur2);
		
		for(int i =0;i<10;i++)
		{
			capteur.tick();
		}		
	}
}