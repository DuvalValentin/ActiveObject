package activeObject;

/**
 * Définit la manière dont les valeurs des capteurs sont diffusées jusqu'aux Afficheurs
 * @author Valentin
 * @author Fares
 * 
 */
public interface AlgorithmeDiffusion 
{
	
	/**
	 * indique a l'ago le capteur qu'il doit écouter
	 * @param capteur le capteur à écouter
	 */
	void configure(Capteur capteur);
	
	/**
	 * execute l'algo de diffusion
	 */
	void execute();
	
	/**
	 * retourne la valeur du capteur 
	 * @return la valeur du capteur 
	 */
	Integer getValue();
}