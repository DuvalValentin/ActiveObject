package activeObject;

import java.util.concurrent.Callable;

public class GetValue implements Callable<Integer>
{
	private Capteur capteur;
	

	public GetValue(Capteur capteur) 
	{
		this.capteur = capteur;
	}


	@Override
	public Integer call() throws Exception 
	{
		return capteur.getValue();
	}

}
