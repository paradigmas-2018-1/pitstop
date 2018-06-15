package TyreChanger;

import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import Utils.*;

public class UnscrewTyreBehaviour extends OneShotBehaviour{

	private static final long serialVersionUID = 1L;
	TyreChangerAgent tyreChangerAgent;
	
	public UnscrewTyreBehaviour(TyreChangerAgent tyreChangerAgent) {
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
		AID tyreCarrierAID = Utils.getTyreCarrierAID(this.tyreChangerAgent);
		
		if(tyreCarrierAID != null) {
			ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);
			
			aclMessage.setConversationId(Constants.TYRE_CHANGER_TO_TYRE_CARRIER);
			aclMessage.addReceiver(tyreCarrierAID);
			aclMessage.setContent(Constants.TYRE_UNSCREWED_MESSAGE);
			this.tyreChangerAgent.send(aclMessage);
		}
	}
	
	

}
