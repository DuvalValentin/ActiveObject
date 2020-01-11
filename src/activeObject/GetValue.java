package activeObject;

import java.util.concurrent.Callable;


/**
 * Retourne la valeur du capteur renvoyée par l'algorithme de diffusion lorsque call() est appellée
 * @author Valentin
 * @author Fares
 * 
 */
public class GetValue implements Callable<Integer>
{
	/**
	  * 	Le capteur dont on doit récupérer la valeur
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
		return capteur.getAlgorithme().getValue();
	}

}
