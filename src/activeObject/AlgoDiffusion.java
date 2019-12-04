package activeObject;

public interface AlgoDiffusion 
{
	
	/**
	 * indique a l'ago le capteur qu'il doit ecouter
	 * @param campteur 
	 */
	void configure(Capteur c);
	
	/**
	 * execute l'algo de diffusion
	 */
	void execute();
	
	/**
	 * 
	 * @return la valeur de capteur 
	 */
	Integer getValue();
}