package Car;

import Utils.Constants;
import Utils.Utils;
import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;


public class GoToPitstopBehaviour extends OneShotBehaviour{

	private static final long serialVersionUID = 1L;
	private CarAgent carAgent;
	
	public GoToPitstopBehaviour(CarAgent carAgent) {
		this.carAgent = carAgent;
	}
	
	@Override
	public void action() {
		sendMessageToInformPitstop();
		
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
		
		
		AID lollipopAgentAID = Utils.getLollipopAID(this.carAgent);
		
		if(lollipopAgentAID != null) {
			ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);
			aclMessage.setConversationId(Constants.CAR_TO_LOLLIPOP);
			
			aclMessage.addReceiver(lollipopAgentAID);
			aclMessage.setContent(Constants.GOING_TO_PITSTOP_MESSAGE);
			this.carAgent.send(aclMessage);
		}
		
	}
	
	

}
