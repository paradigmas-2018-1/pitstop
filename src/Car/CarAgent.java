package Car;

import jade.core.Agent;

public class CarAgent extends Agent {
	
	private int tyreQuality;
	private RunBehaviour runBehaviour;
	private WearTyreBehaviour wearTyreBehaviour;
	
	protected void setup() {
		setTyreQuality(100);
		
		runBehaviour = new RunBehaviour(this);
		
		
		addBehaviour(runBehaviour);
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
	
	public void informCurrentTyreQuality() {
		System.out.println("Qualidade dos pneus: " + getTyreQuality() + "!\n");
	}
	
	public void addRunBehaviour() {
		this.addBehaviour(runBehaviour);
	}
	
	public void addWearTyreBehaviour() {
		this.addBehaviour(wearTyreBehaviour);
	}
	
	public void removeRunBehaviour() {
		this.removeBehaviour(runBehaviour);
	}	
	
	public void removeWearTyreBehaviour() {
		this.removeBehaviour(wearTyreBehaviour);
	}	
	
	public void setWearTyreBehaviour(WearTyreBehaviour wearTyreBehaviour) {
		this.wearTyreBehaviour = wearTyreBehaviour;
	}

}
