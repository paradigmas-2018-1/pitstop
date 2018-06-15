package Car;

import jade.core.behaviours.OneShotBehaviour;

public class GoToPitstopBehaviour extends OneShotBehaviour{

	private static final long serialVersionUID = 1L;
	private CarAgent carAgent;
	
	public GoToPitstopBehaviour(CarAgent carAgent) {
		this.carAgent = carAgent;
	}
	
	@Override
	public void action() {
		// TODO Start other agents! 
	}
	
	

}
