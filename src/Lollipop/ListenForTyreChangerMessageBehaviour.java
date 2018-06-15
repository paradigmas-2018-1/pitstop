package Lollipop;

import Utils.Constants;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class ListenForTyreChangerMessageBehaviour extends CyclicBehaviour{

	private LollipopAgent lollipopAgent;
	
	public ListenForTyreChangerMessageBehaviour(LollipopAgent lollipopAgent) {
		this.lollipopAgent = lollipopAgent;
	}
	
	@Override
	public void action() {
		String message = getTyreChangerMessage();
		
		if(message != null) {
			boolean isMessageTyreChanged = checkIfMessageIsTyreChanged(message);
			
			if(isMessageTyreChanged) {
				// TODO Send message to pilot start running;
			}
		}
		
	}
	
	private boolean checkIfMessageIsTyreChanged(String message) {
		if(message.equals(Constants.TYRE_CHANGED_MESSAGE) {
			return true;
		} else {
			return false;
		}
	}
	
	private String getTyreChangerMessage() {
		String message = null;
		ACLMessage aclMessage = this.lollipopAgent.receive();
		
		if(aclMessage != null) {
			message = aclMessage.getContent();
		}
		
		return message;
	}

}
