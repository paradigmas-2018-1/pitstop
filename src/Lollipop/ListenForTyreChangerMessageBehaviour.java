package Lollipop;

import Utils.Constants;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.tools.sniffer.Message;

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
			System.out.println("Mensagem para TyreChanger recebida" + message);
			boolean isMessageTyreChanged = checkIfMessageIsTyreChanged(message);
			
			if(isMessageTyreChanged) {
				turnLollipopToRun();
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
		if(message.equals(Constants.TYRE_SCREWED_MESSAGE)){
			return true;
		} else {
			return false;
		}
	}
	
	private String getTyreChangerMessage() {
		String message = null;
		
		MessageTemplate messagetemplate = 
				MessageTemplate.MatchConversationId(Constants.TYRE_CHANGER_TO_LOLLIPOP);
		ACLMessage aclMessage = this.lollipopAgent.receive(messagetemplate);
		
		if(aclMessage != null) {
			message = aclMessage.getContent();
		}
		
		return message;
	}

}
