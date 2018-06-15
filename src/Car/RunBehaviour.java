package Car;

import jade.core.behaviours.CyclicBehaviour;

public class RunBehaviour extends CyclicBehaviour {
	
	private static final long serialVersionUID = 1L;
	CarAgent carAgent;
	private final int TYRE_QUALITY_LIMIT = 90;
	
	public RunBehaviour(CarAgent carAgent) {
		this.carAgent = carAgent;
		startWearingTyres();
	}
	
	@Override
	public void action() {
		run();
		
		int tyreQuality = this.carAgent.getTyreQuality();
		
		if (tyreQuality <= TYRE_QUALITY_LIMIT) {
			stop();
			goToPitstop();
		}
	}
	
	private void goToPitstop() {
		GoToPitstopBehaviour goToPitstopBehaviour = new GoToPitstopBehaviour(this.carAgent);
		this.carAgent.setGoToPitstopBehaviour(goToPitstopBehaviour);
		this.carAgent.addGoToPitstopBehaviour();
	}
	
	private void startWearingTyres() {
		WearTyreBehaviour wearTyreBehaviour = new WearTyreBehaviour(this.carAgent);
		this.carAgent.setWearTyreBehaviour(wearTyreBehaviour);
		this.carAgent.addWearTyreBehaviour();
	}
	
	private void run() {
		System.out.println(" Vruum! Vruum!\n");
		this.carAgent.informCurrentTyreQuality();
	}
	
	private void stop() {
		System.out.println("Parado!\n");
		this.carAgent.removeRunBehaviour();
		this.carAgent.removeWearTyreBehaviour();
	}

}
