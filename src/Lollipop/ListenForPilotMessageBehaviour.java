package Lollipop;

import Utils.Constants;
import Utils.Utils;
import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class ListenForPilotMessageBehaviour extends CyclicBehaviour{

	private static final long serialVersionUID = 1L;
	private LollipopAgent lollipopAgent;
	
	public ListenForPilotMessageBehaviour(LollipopAgent lollipopAgent) {
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
			} 
			
			boolean isStopped = checkIfPilotStopped(message);
			
			if(isStopped) {
				sendMessageToAllCrew();
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
	
	private boolean checkIfPilotStopped(String message) {
		if(message.equals(Constants.CAR_STOP_MESSAGE)) {
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
	
	private void sendMessageToAllCrew() {
		sendMessageToTyreChanger();
	}
	
	private void sendMessageToTyreChanger() {
		AID tyreChangerAID = Utils.getTyreChangerAID(this.lollipopAgent);
		
		if(tyreChangerAID != null) {
			ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);
			aclMessage.addReceiver(tyreChangerAID);
			aclMessage.setContent(Constants.CHANGE_TYRE_MESSAGE);
			this.lollipopAgent.send(aclMessage);
		}
		
	}

}
