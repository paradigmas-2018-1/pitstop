package TyreChanger;

import Utils.Constants;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

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
				stopListeningForLollipopMessage();
				startChangingTyres();
			}	
		}
	}
	
	private void stopListeningForLollipopMessage() {
		this.tyreChangerAgent.removeListenForLollipopMessageBehaviour();
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
		ACLMessage aclMessage = this.tyreChangerAgent.receive();
		
		String message = null;
		
		if(aclMessage != null) {
			message = aclMessage.getContent();
		}
		
		return message;
	}

}
