package TyreCarrier;

import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.lang.acl.ACLMessage;
import Utils.*;

public class ListenForTyreChangerMessage extends CyclicBehaviour{

	private TyreCarrierAgent tyreCarrierAgent;
	
	public ListenForTyreChangerMessage(TyreCarrierAgent tyreCarrierAgent) {
		this.tyreCarrierAgent = tyreCarrierAgent;
	}
	
	@Override
	public void action() {
		String message = getTyreChangerMessage();
		boolean isUnscrewed = checkIfMessageWasTyreUnscrewed(message);
		
		if(isUnscrewed) {
			removeTyre();
		}
	}
	
	private void removeTyre() {
		RemoveTyreBehaviour removeTyreBehaviour = new RemoveTyreBehaviour(this.tyreCarrierAgent);
		this.tyreCarrierAgent.setRemoveTyreBehaviour(removeTyreBehaviour);
		this.tyreCarrierAgent.addRemoveTyreBehaviour();
	}
	
	private boolean checkIfMessageWasTyreUnscrewed(String message) {
		if(message.equals(Constants.TYRE_UNSCREWED_MESSAGE)) {
			return true;
		} else {
			return false;
		}
	}
	
	private String getTyreChangerMessage() {
		ACLMessage aclMessage = this.tyreCarrierAgent.receive();
		
		String message = null;
		
		if(aclMessage != null) {
			message = aclMessage.getContent();
		}
		
		return message;
	}
	
}
