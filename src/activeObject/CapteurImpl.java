package activeObject;

public class CapteurImpl implements Capteur {

	//private AlgoDiffusion algo;
	private Canal canal;
	private Integer value;
	
	public CapteurImpl(/*AlgoDiffusion algo*/Canal canal) 
	{
		//this.algo=algo;
		this.canal=canal;
		this.value=100;
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
	public Integer getValue() 
	{
		return value;
	}

	@Override
	public void tick() 
	{
		//algo.execute();
		canal.update(this);
	}

}
