package activeObject;

public class Afficheur implements ObserverdeCapteur {
	private Integer value;

	@Override
	public void update(Capteur c) {
		value = c.getValue();
		// TODO Auto-generated method stub
	}
}