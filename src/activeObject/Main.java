package activeObject;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class Main {

	public static void main(String[] args) 
	{
		ScheduledExecutorService scheduler = new ScheduledThreadPoolExecutor(30);
		Afficheur afficheur1 = new Afficheur();
		Afficheur afficheur2 = new Afficheur();
		CanalImp canal1 = new CanalImp(scheduler,afficheur1);
		CanalImp canal2 = new CanalImp(scheduler,afficheur2);
		Set<CanalImp> canals = new HashSet<CanalImp>();
		canals.add(canal1);
		canals.add(canal2);
		DiffusionAtomique diffusionAtomique=new DiffusionAtomique(canals);
		DiffusionSequentielle diffusionSequentielle=new DiffusionSequentielle(canals);
		Capteur capteur1 = new CapteurImpl(diffusionAtomique);
		Capteur capteur2 = new CapteurImpl(diffusionSequentielle);
		
		
		
		
		for(int i =0;i<10;i++)
		{
			capteur1.tick();
		}
		for(int i =0;i<10;i++)
		{
			capteur2.tick();
		}
		
	}
}