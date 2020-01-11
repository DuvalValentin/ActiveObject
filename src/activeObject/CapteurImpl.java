package activeObject;

import java.util.HashSet;
import java.util.Set;

/**
 * Implémentation de l'interface Capteur
 * @author Valentin
 * @author Fares
 */
public class CapteurImpl implements Capteur {
	
	/**
	  * Un algo de diffusion  à visibilité privé
	  */
	private AlgorithmeDiffusion algo;
	
	/**
	 * Un Integer  à visibilité privé
	 */
	private Integer value;
	
	 /**
	  *  Set de nos observeurs
	  */
	private Set<ObserverDeCapteur> observers;
	
	public CapteurImpl() 
	{
		this.value=0;
		observers=new HashSet<ObserverDeCapteur>(); 
	}
	
	@Override
	public void attach(ObserverDeCapteur o) 
	{
		observers.add(o);
	}
	
	@Override
	public void detach(ObserverDeCapteur o) 
	{
		observers.remove(o);
	}
	
	@Override
	public Integer getValue() 
	{
		return value;
	}
	
	@Override
	public void tick() 
	{
		value++;
		algo.execute();
		System.out.print("");//Juste pour que ça prenne un peu plus de temps
	}
	
	
	@Override
	public AlgorithmeDiffusion getAlgorithme() {
		return algo;
	}
	
	@Override
	public void setAlgo(AlgorithmeDiffusion algo) {
		this.algo=algo;
		
	}
	@Override
	public Set<ObserverDeCapteur> getObervers() 
	{
		return observers;
	}
	

}
