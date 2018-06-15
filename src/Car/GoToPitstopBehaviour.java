package Car;

import Utils.Constants;
import Utils.Utils;
import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;


public class GoToPitstopBehaviour extends OneShotBehaviour{

	private static final long serialVersionUID = 1L;
	private CarAgent carAgent;
	
	public GoToPitstopBehaviour(CarAgent carAgent) {
		this.carAgent = carAgent;
	}
	
	@Override
	public void action() {
		// TODO Send message to everyone to prepare!
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
		ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);
		aclMessage.setSender(this.carAgent.getAID());
		aclMessage.setContent(Constants.GOING_TO_PITSTOP_MESSAGE);
		
		AID lollipopAgentAID = getLollipopAgentAID();
		
		if(lollipopAgentAID != null) {
			aclMessage.addReceiver(lollipopAgentAID);
		}
		
		this.carAgent.send(aclMessage);
		
	}
	
	private AID getLollipopAgentAID() {
		AID lollipopAgentAID = null;
		
		try {
			lollipopAgentAID =
					Utils.searchForAgent(this.carAgent, Constants.LOLLIPOP_AGENT_NAME,
							Constants.LOLLIPOP_AGENT_TYPE);
			
		} catch (FIPAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lollipopAgentAID;
		
	}
	

}
