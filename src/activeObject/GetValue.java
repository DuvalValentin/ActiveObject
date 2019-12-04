package activeObject;

import java.util.concurrent.Callable;

public class GetValue implements Callable<Integer>
{
	/**
	  * 	Un capteur  à visibilité privé
	  */
	private Capteur capteur;
	
    /**
     * Un constructeur avec un capteur en paramètre
     * @param capteur
     */
	public GetValue(Capteur capteur) 
	{
		this.capteur=capteur;
	}

	/**
	 * @return 
	 */
	@Override
	public Integer call() throws Exception 
	{
		return capteur.getAlgo().getValue();
	}

}
