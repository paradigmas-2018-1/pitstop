package Car;

import jade.core.Agent;

public class CarAgent extends Agent {
	
	private static final long serialVersionUID = 1L;
	
	private int tyreQuality;
	private RunBehaviour runBehaviour;
	private WearTyreBehaviour wearTyreBehaviour;
	private GoToPitstopBehaviour goToPitstopBehaviour;
	
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
	
	public void removeRunBehaviour() {
		this.removeBehaviour(runBehaviour);
	}	
	
	public void addWearTyreBehaviour() {
		this.addBehaviour(wearTyreBehaviour);
	}
	
	public void removeWearTyreBehaviour() {
		this.removeBehaviour(wearTyreBehaviour);
	}	
	
	public void setWearTyreBehaviour(WearTyreBehaviour wearTyreBehaviour) {
		this.wearTyreBehaviour = wearTyreBehaviour;
	}
	
	public void addGoToPitstopBehaviour() {
		this.addBehaviour(goToPitstopBehaviour);
	}
	
	public void removeGoToPitstopBehaviour() {
		this.removeBehaviour(goToPitstopBehaviour);
	}
	
	public void setGoToPitstopBehaviour(GoToPitstopBehaviour goToPitstopBehaviour) {
		this.goToPitstopBehaviour = goToPitstopBehaviour;
	}

}
