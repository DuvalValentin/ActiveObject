package activeObject;

public class CapteurImpl implements Capteur {

	//private AlgoDiffusion algo;
	private Canal canal; 
	
	public CapteurImpl(/*AlgoDiffusion algo*/Canal canal) 
	{
		//this.algo=algo;
		this.canal=canal;
	}
	@Override
	public void attach(ObserverdeCapteur o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detach(ObserverdeCapteur o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void tick() 
	{
		//algo.execute();
		canal.update(this);
	}

}
