package main;

import java.io.IOException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import activeObject.Afficheur;
import activeObject.CanalImp;
import activeObject.Capteur;
import activeObject.CapteurImpl;
import activeObject.DiffusionAtomique;
import activeObject.DiffusionSequentielle;

public class Main {
	
	public static final Logger logger=Logger.getAnonymousLogger();

	public static void main(String[] args) 
	{ 
		addHandler();
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
		
		
		logger.info("Diffusion Atomique");
		for(int i =0;i<10;i++)
		{
			capteur1.tick();
		}
		logger.info("Diffusion Séquentielle");
		for(int i =0;i<10000000;i++)
		{
			capteur2.tick();
		}
		scheduler.shutdown();
	}
	
	private static void addHandler()
	{
		FileHandler fh;
		try 
		{
			fh = new FileHandler("./info/Logger/Afficheur.xml", true);
			logger.addHandler(fh);
		}
		catch (SecurityException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}