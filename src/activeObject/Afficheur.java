package activeObject;

import java.util.concurrent.ExecutionException;

public class Afficheur implements ObserverdeCapteur,ObserverDeCanal{
	private Integer value;
	



	@Override
	public void update(Capteur c) 
	{
		// TODO Auto-generated method stub
		//canal.getValue(c);
	}



	@Override
	public void update(Canal c) throws InterruptedException, ExecutionException {
		value=c.getValue();
		System.out.println(value);
	}
}