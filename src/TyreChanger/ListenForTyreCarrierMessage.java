package TyreChanger;

import Utils.Constants;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class ListenForTyreCarrierMessage extends CyclicBehaviour {

	private TyreChangerAgent tyreChangerAgent;
	
	public ListenForTyreCarrierMessage(TyreChangerAgent tyreChangerAgent) {
		this.tyreChangerAgent = tyreChangerAgent;
	}
	
	@Override
	public void action() {
		String message = getTyreCarrierMessage();
		
		if(message != null) {
			boolean isTyrePutBack = checkIfMessageIsTyrePutBack(message);
			
			if(isTyrePutBack) {
				// TODO Screw tyre!
			}
		}
		
	}
	
	private boolean checkIfMessageIsTyrePutBack(String message) {
		if(message.equals(Constants.TYRE_PUT_BACK_MESSAGE)) {
			return true;
		} else {
			return false;
		}
	}
	
	private String getTyreCarrierMessage() {
		ACLMessage aclMessage = this.tyreChangerAgent.receive();
		
		String message = null;
		
		if(aclMessage != null) {
			message = aclMessage.getContent();
		}
		
		return message;
	}

}
