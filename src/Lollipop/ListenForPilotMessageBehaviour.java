package Lollipop;

import Utils.Constants;
import Utils.Utils;
import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

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
			System.out.println("Mensagem para o Lollipop!");
			boolean isComming = checkIfPilotIsComming(message);
			
			if(isComming) {
				System.out.println("Mensagem recebida: O piloto vem.");
				turnLollipopToStop();
			} else {
				boolean isStopped = checkIfPilotStopped(message);
				
				if(isStopped) {
					System.out.println("Mensagem recebida: O piloto parou");
					sendMessageToAllCrew();
				}
			}
		}
	}
	
	private void turnLollipopToStop() {
		this.lollipopAgent.remoteTurnLollipopToStopBehaviour();
		
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
		MessageTemplate messageTemplate = MessageTemplate.MatchConversationId(Constants.CAR_TO_LOLLIPOP);
		ACLMessage aclMessage = this.lollipopAgent.receive(messageTemplate);
		
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
			System.out.println("Enviando mensagem ao Tyre Changer.");
			
			ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);
			aclMessage.setConversationId(Constants.LOLLIPOP_TO_TYRE_CHANGER);
			aclMessage.addReceiver(tyreChangerAID);
			aclMessage.setContent(Constants.CHANGE_TYRE_MESSAGE);
			
			this.lollipopAgent.send(aclMessage);
		}
		
	}

}
