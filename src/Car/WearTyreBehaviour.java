package Car;

import java.util.Random;

import jade.core.behaviours.CyclicBehaviour;

public class WearTyreBehaviour extends CyclicBehaviour {
	
	CarAgent carAgent;
	
	public WearTyreBehaviour(CarAgent carAgent) {
		this.carAgent = carAgent;
	}

	@Override
	public void action() {
		int amountToWear = generateRandomWearAmount();
		removeFromTyreQuality(amountToWear);
	}
	
	private int generateRandomWearAmount() {
		Random random = new Random();
		
		int amountToWear = random.nextInt(5);
		
		return amountToWear;
	}
	
	private void removeFromTyreQuality(int amount) {
		int quality = this.carAgent.getTyreQuality();
		
		int newQuality = quality - amount;
		
		this.carAgent.setTyreQuality(newQuality);
	}

}
