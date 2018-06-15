package Lollipop;

import Utils.Constants;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class ListenForPilotCallBehaviour extends CyclicBehaviour{

	private static final long serialVersionUID = 1L;
	private LollipopAgent lollipopAgent;
	
	public ListenForPilotCallBehaviour(LollipopAgent lollipopAgent) {
		this.lollipopAgent = lollipopAgent;
	}
	
	@Override
	public void action() {
		String message = getMessages();
		
		if(message != null) {
			boolean isComming = checkIfPilotIsComming(message);
			
			if(isComming) {
				System.out.println(Constants.PILOT_COMMING_MESSAGE);
				turnLollipopToStop();
				stopListeningToPilot();
			}
		}
	}
	
	private void stopListeningToPilot() {
		this.lollipopAgent.removeListenForPilotCallBehaviour();
	}
	
	private void turnLollipopToStop() {
		TurnLollipopToStopBehaviour turnLollipopToStopBehaviour =
				new TurnLollipopToStopBehaviour(lollipopAgent);
		this.lollipopAgent.setTurnLollipopToStopBehaviour(turnLollipopToStopBehaviour);
		this.lollipopAgent.addTurnLollipopToStopBehaviour();
	}
	
	private boolean checkIfPilotIsComming(String message) {
		if(message.equals(Constants.GOING_TO_PITSTOP_MESSAGE)) {
			return true;
		} else {
			return false;
		}
	}
	
	private String getMessages() {
		ACLMessage aclMessage = this.lollipopAgent.receive();
		
		String message = null;
		
		if(aclMessage != null) {
			message = aclMessage.getContent();
		}
		
		return message;
	}

}
