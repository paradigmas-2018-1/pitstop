package TyreChanger;

import Car.CarAgent;
import Utils.Constants;
import Utils.Utils;
import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.wrapper.AgentContainer;
import jade.wrapper.ControllerException;

public class ScrewTyreBehaviour extends OneShotBehaviour{

	private static final long serialVersionUID = 1L;
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
		updateTyres();
		
	}
	
	private void updateTyres() {
		
	}
	
	private void sendTyreScrewedMessageToLollipop() {
		AID lollipopAID = Utils.getLollipopAID(this.tyreChangerAgent);
		
		if(lollipopAID != null) {
			ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);
			
			aclMessage.addReceiver(lollipopAID);
			aclMessage.setContent(Constants.TYRE_SCREWED_MESSAGE);
			this.tyreChangerAgent.send(aclMessage);
		}
	}

}
