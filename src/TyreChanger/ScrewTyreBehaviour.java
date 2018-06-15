package TyreChanger;

import Utils.Constants;
import Utils.Utils;
import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class ScrewTyreBehaviour extends OneShotBehaviour{

	private TyreChangerAgent tyreChangerAgent;
	
	public ScrewTyreBehaviour(TyreChangerAgent tyreChangerAgent) {
		this.tyreChangerAgent = tyreChangerAgent;
	}
	
	@Override
	public void action() {
		screwTyre();
		sendTyreScrewedMessageToLollipop();
	}
	
	private void screwTyre() {
		System.out.println(Constants.TYRE_SCREWED_MESSAGE);
	}
	
	private void sendTyreScrewedMessageToLollipop() {
		AID lollipopAID = Utils.getLollipopAID();
		
		if(lollipopAID != null) {
			ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);
			
			aclMessage.addReceiver(lollipopAID);
			aclMessage.setContent(Constants.TYRE_SCREWED_MESSAGE);
			this.tyreChangerAgent.send(aclMessage);
		}
	}

}