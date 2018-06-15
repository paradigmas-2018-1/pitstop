package Car;

import jade.core.behaviours.CyclicBehaviour;

public class RunBehaviour extends CyclicBehaviour {
	
	private static final long serialVersionUID = 1L;
	CarAgent carAgent;
	private final int TYRE_QUALITY_LIMIT = 50;
	
	public RunBehaviour(CarAgent carAgent) {
		this.carAgent = carAgent;
		startWearingTyres();
	}
	
	@Override
	public void action() {
		run();
		
		int tyreQuality = this.carAgent.getTyreQuality();
		
		if (tyreQuality <= TYRE_QUALITY_LIMIT) {
			stopRunningBehaviour();
			goToPitstop();
			startSearchingForStopLollipop();
		}	
	}
	
	private void stopRunningBehaviour() {
		this.carAgent.removeRunBehaviour();
	}
	
	private void startSearchingForStopLollipop() { 
		SearchForLollipopBehaviour searchForStopLollipopBehaviour =
				new SearchForLollipopBehaviour(this.carAgent);
		this.carAgent.setSearchForLollipopBehaviour(searchForStopLollipopBehaviour);
		this.carAgent.addSearchForLollipopBehaviour();
	}
	
	private void goToPitstop() {
		System.out.println("goToPitstop");
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
		System.out.println(" Vruum! Vruum!");
		this.carAgent.informCurrentTyreQuality();
	}
}
