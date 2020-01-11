package activeObject;

import java.util.Set;

/**
 * Contient une valeur qui se modifie au cours du temps
 * @author Valentin
 * @author Fares
 */
public interface Capteur 
{
	
	/**
	 * rajoute un observeur à notre Set d'observeurs
	 * @param observer l'observeur que l'on souhaite ajouter
	 */
	void attach(ObserverDeCapteur observer);
	
	/**
	 * supprime un observeur de notre Set d'observeurs  
	 * @param observer l'observeur que l'on souhaite supprime
	 */
	void detach(ObserverDeCapteur observer);
	/**
	 * Retourne les Observeurs
	 * @return le set des observeurs du capteur
	 */
	Set<ObserverDeCapteur> getObervers();
	
	/**
	 * Retourne la valeur du capteur
	 *@return  valeur du capteur
	 */
	Integer getValue();
	/**
	 * modifie la valeur de capteur  et fait appel a l'algo pour qu'il s'éxécute
	 */
	void tick();
	/**
	 * Retourne l'algorithme de diffusion
	 * @return l'algorithme de diffusion
	 */
	AlgorithmeDiffusion getAlgorithme();
	/**
	 * modifie l'algorithme de diffusion
	 * @param algorithme le nouvel algorithme de diffusion
	 */
	void setAlgo(AlgorithmeDiffusion algorithme);
}