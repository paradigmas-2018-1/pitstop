package Car;

import jade.core.Agent;

public class CarAgent extends Agent {
	
	private int tyreQuality;
	
	protected void setup() {
		setTyreQuality(100);
		
		RunBehaviour runBehaviour = new RunBehaviour();
		WearTyreBehaviour wearTyreBehaviour = new WearTyreBehaviour(this);
		
		addBehaviour(runBehaviour);
		addBehaviour(wearTyreBehaviour);
	}
	
	public void setTyreQuality(int tyreQuality) {
		if(tyreQuality <= 0) {
			tyreQuality = 0;
		}
		
		this.tyreQuality = tyreQuality;
	}
	
	public int getTyreQuality() {
		return this.tyreQuality;
	}
}
