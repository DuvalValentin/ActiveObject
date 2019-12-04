package activeObject;

import java.util.Set;

public interface Capteur 
{
	
	/**
	 * rajout de l'observeur à notre liste observeurs
	 */
	void attach(ObserverDeCapteur o);
	
	/**
	 * supprimé  l'observeur de notre liste observeurs  
	 */
	void detach(ObserverDeCapteur o);
	Set<ObserverDeCapteur> getObervers();
	
	/**
	 *@return  valeur du capteur
	 */
	Integer getValue();
	/**
	 * modifie la valeur de capteur  et fait appel a l'algo pour qu'il s'éxécute
	 */
	void tick();
	
	
	
	/**
	 * 
	 * @return lago de diffusion
	 */
	AlgoDiffusion getAlgo();
	void setAlgo(AlgoDiffusion algo);
}