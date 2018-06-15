package TyreCarrier;

import Utils.Constants;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class ListenForTyreChangerMessage extends CyclicBehaviour{

	private static final long serialVersionUID = 1L;
	private TyreCarrierAgent tyreCarrierAgent;
	
	public ListenForTyreChangerMessage(TyreCarrierAgent tyreCarrierAgent) {
		this.tyreCarrierAgent = tyreCarrierAgent;
	}
	
	@Override
	public void action() {
		String message = getTyreChangerMessage();
		
		if(message != null) {
			boolean isUnscrewed = checkIfMessageWasTyreUnscrewed(message);
			
			if(isUnscrewed) {
				removeTyre();
				stopListeningToTyreChanger();			
			}	
		}
	}
	
	private void stopListeningToTyreChanger() {
		this.tyreCarrierAgent.removeListenForTyreChangerMessageBehaviour();
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
