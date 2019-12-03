package activeObject;

import java.util.HashSet;
import java.util.Set;

public class CapteurImpl implements Capteur {

	private AlgoDiffusion algo;
	private Integer value;
	private Set<ObserverDeCapteur> observers;
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
