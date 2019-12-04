package activeObject;

import java.util.HashSet;
import java.util.Set;

public class CapteurImpl implements Capteur {
	
	/**
	  * Un algo de diffusion  à visibilité privé
	  */
	private AlgoDiffusion algo;
	
	/**
	 * Un Integer  à visibilité privé
	 */
	private Integer value;
	
	 /**
	  *  Set de nos observeurs
	  */
	private Set<ObserverDeCapteur> observers;
	
	/**
	 * Un constructeur avec un algoDiffusion en paramètre
	 * @param algo
	 */
	public CapteurImpl(AlgoDiffusion algo) 
	{
		this.algo=algo;
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
		algo.execute(this);
		System.out.print("");//Juste pour que ça prenne un peu plus de temps
	}
	
	
	@Override
	public AlgoDiffusion getAlgo() {
		return algo;
	}

}
