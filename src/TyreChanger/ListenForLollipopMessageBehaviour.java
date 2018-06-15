package TyreChanger;

import Utils.Constants;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class ListenForLollipopMessageBehaviour extends CyclicBehaviour {
	
	private static final long serialVersionUID = 1L;
	private TyreChangerAgent tyreChangerAgent;
	
	public ListenForLollipopMessageBehaviour(TyreChangerAgent tyreChangerAgent) {
		this.tyreChangerAgent = tyreChangerAgent;
	}
	
	@Override
	public void action() {
		String message = getLollipopMessage();
		
		if(message != null) {
			boolean isChangeTyreMessage = checkIfIsChangeTyreMessage(message);
			
			if(isChangeTyreMessage) {
				startChangingTyres();
			}	
		}
	}
	
	private void startChangingTyres() {
		UnscrewTyreBehaviour changeTyreBehaviour = new UnscrewTyreBehaviour(this.tyreChangerAgent);
		this.tyreChangerAgent.addChangeTyreBehaviour(changeTyreBehaviour);
	}
	
	private boolean checkIfIsChangeTyreMessage(String message) {
		if(message.equals(Constants.CHANGE_TYRE_MESSAGE)) {
			return true;
		} else {
			return false;			
		}
		
	}

	private String getLollipopMessage() {
		MessageTemplate messageTemplate = MessageTemplate.MatchConversationId(Constants.LOLLIPOP_TO_TYRE_CHANGER);
		ACLMessage aclMessage = this.tyreChangerAgent.receive(messageTemplate);
		
		String message = null;
		
		if(aclMessage != null) {
			message = aclMessage.getContent();
		}
		
		return message;
	}

}
