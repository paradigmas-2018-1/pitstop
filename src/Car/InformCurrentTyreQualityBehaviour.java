package Car;

import jade.core.behaviours.OneShotBehaviour;

public class InformCurrentTyreQualityBehaviour extends OneShotBehaviour {
	
	CarAgent carAgent;
	
	public InformCurrentTyreQualityBehaviour(CarAgent carAgent) {
		this.carAgent = carAgent;
	}

	@Override
	public void action() {
		informCurrentTyreQuality();
		
	}
		
	private void informCurrentTyreQuality() {
		System.out.println("Qualidade dos pneus: " + this.carAgent.getTyreQuality() + "!\n");
	}


}
