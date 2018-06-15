package TyreChanger;

import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.lang.acl.ACLMessage;
import Utils.*;

public class ChangeTyreBehaviour extends OneShotBehaviour{

	TyreChangerAgent tyreChangerAgent;
	
	public ChangeTyreBehaviour(TyreChangerAgent tyreChangerAgent) {
		this.tyreChangerAgent = tyreChangerAgent;
	}
	
	@Override
	public void action() {
		tyreUnscrewedMessage();
		changeTyre();
	}
	
	private void changeTyre() {
		System.out.println(Constants.TYRE_UNSCREWED_MESSAGE);
	}
	
	private void tyreUnscrewedMessage() {
		ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);
		AID tyreCarrierAID = getTyreCarrierAID();
		
		if(tyreCarrierAID != null) {
			aclMessage.addReceiver(tyreCarrierAID);
			aclMessage.setContent(Constants.TYRE_UNSCREWED_MESSAGE);
			this.tyreChangerAgent.send(aclMessage);
		}
	}
	
	private AID getTyreCarrierAID() {
		AID tyreCarrierAID = null;
		try {
			tyreCarrierAID = 
					Utils.searchForAgent(this.tyreChangerAgent, Constants.TYRE_CARRIER_AGENT_NAME, 
							Constants.TYRE_CARRIER_AGENT_TYPE);
		} catch (FIPAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tyreCarrierAID;
	}

}
