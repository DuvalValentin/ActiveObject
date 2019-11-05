package activeObject;

import java.util.concurrent.Callable;

public class Update<T> implements Callable<T> 
{
	private Canal canal ;
	private Afficheur afficheur;
	
	public Update(Canal canal, Afficheur afficheur) {
		this.canal=canal;
		this.afficheur=afficheur;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public T call() {
		// TODO Auto-generated method stub
		afficheur.update(canal);
		return null;
		
	}
	

}
