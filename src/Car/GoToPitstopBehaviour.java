package Car;

import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;


public class GoToPitstopBehaviour extends OneShotBehaviour{

	private static final long serialVersionUID = 1L;
	private CarAgent carAgent;
	private final String GOING_TO_PITSTOP_MESSAGE = "Tô indo pro pitstop, prepara aê!";
	
	public GoToPitstopBehaviour(CarAgent carAgent) {
		this.carAgent = carAgent;
	}
	
	@Override
	public void action() {
		// TODO Send message to everyone to prepare!
		
	}
	
	private void sendMessageToInformPitstop() {
		
		/*
		 * inform indicates that the sending agent
		 * holds something that is true,
		 *  intends that the receiving agent also comes to believe 
		 *  that the proposition is true, and,
		 *  does not already believe that the receiver has any 
		 *  knowledge of the truth of the proposition.
		 */
		ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);
		aclMessage.setSender(this.carAgent.getAID());
		aclMessage.setContent(GOING_TO_PITSTOP_MESSAGE);
	}
	
	

}
