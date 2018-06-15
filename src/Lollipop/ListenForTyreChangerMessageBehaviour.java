package Lollipop;

import Utils.Constants;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class ListenForTyreChangerMessageBehaviour extends CyclicBehaviour{

	private static final long serialVersionUID = 1L;
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
				turnLollipopToRun();
				stopListeningForTyreChangerMessage();
			}
		}
		
	}
	
	private void turnLollipopToRun() {
		TurnLollipopToRunBehaviour turnLollipopToRunBehaviour = 
				new TurnLollipopToRunBehaviour(this.lollipopAgent);
		this.lollipopAgent.setTurnLollipopToRunBehaviour(turnLollipopToRunBehaviour);
		this.lollipopAgent.addTurnLollipopToRunBehaviour();
	}
	
	private boolean checkIfMessageIsTyreChanged(String message) {
		if(message.equals(Constants.TYRE_CHANGED_MESSAGE)){
			return true;
		} else {
			return false;
		}
	}
	
	private void stopListeningForTyreChangerMessage() {
		this.lollipopAgent.removeListenForTyreChangerMessageBehaviour();
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
