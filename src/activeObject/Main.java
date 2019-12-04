package activeObject;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class Main {

	public static void main(String[] args) 
	{
		Capteur capteur1 = new CapteurImpl();
		Capteur capteur2 = new CapteurImpl();
		ScheduledExecutorService scheduler = new ScheduledThreadPoolExecutor(30);
		Afficheur afficheur1 = new Afficheur();
		Afficheur afficheur2 = new Afficheur();
		CanalImp canal1 = new CanalImp(scheduler,afficheur1);
		CanalImp canal2 = new CanalImp(scheduler,afficheur2);
		capteur1.attach(canal1);
		capteur1.attach(canal2);
		capteur2.attach(canal1);
		capteur2.attach(canal2);
		DiffusionAtomique diffusionAtomique=new DiffusionAtomique();
		DiffusionSequentielle diffusionSequentielle=new DiffusionSequentielle();
		diffusionAtomique.configure(capteur1);
		diffusionSequentielle.configure(capteur2);
		
		
		System.out.println("Diffusion Atomique");
		for(int i =0;i<10;i++)
		{
			capteur1.tick();
		}
		System.out.println("Diffusion Séquentielle");
		for(int i =0;i<10000000;i++)
		{
			capteur2.tick();
		}
		scheduler.shutdown();
	}
}