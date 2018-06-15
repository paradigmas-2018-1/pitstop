package Car;

import java.util.Random;

import jade.core.behaviours.CyclicBehaviour;

public class WearTyreBehaviour extends CyclicBehaviour {
	
	private static final long serialVersionUID = 1L;
	CarAgent carAgent;
	
	public WearTyreBehaviour(CarAgent carAgent) {
		this.carAgent = carAgent;
	}

	@Override
	public void action() {
		try {
			sleepThreeSeconds();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int amountToWear = generateRandomWearAmount();
		removeFromTyreQuality(amountToWear);
	}
	
	private void sleepThreeSeconds() throws InterruptedException {
		Thread.sleep(3000);
	}
	
	private int generateRandomWearAmount() {
		Random random = new Random();
		
		int amountToWear = random.nextInt(5) + 1;
		
		return amountToWear;
	}
	
	private void removeFromTyreQuality(int amount) {
		int quality = this.carAgent.getTyreQuality();
		
		int newQuality = quality - amount;
		
		this.carAgent.setTyreQuality(newQuality);
	}

}
