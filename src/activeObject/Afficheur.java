package activeObject;

import java.util.concurrent.ExecutionException;

public class Afficheur implements ObserverDeCapteur{
	private Integer value;

	@Override
	public void update(Capteur c) throws InterruptedException, ExecutionException 
	{
		value=c.getValue();
		System.out.println(this+" : "+value);
	}
}