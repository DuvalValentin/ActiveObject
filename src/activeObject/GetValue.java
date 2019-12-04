package activeObject;

import java.util.concurrent.Callable;

public class GetValue implements Callable<Integer>
{
	/**
	  * 	Un capteur  
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
	 * @return  la valeur de capteur 
	 */
	@Override
	public Integer call() throws Exception 
	{
		return capteur.getAlgo().getValue();
	}

}
