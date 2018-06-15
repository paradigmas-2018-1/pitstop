package TyreCarrier;

import Utils.Constants;
import Utils.Utils;
import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class PutTyreBehaviour extends OneShotBehaviour{

	private TyreCarrierAgent tyreCarrierAgent;
	
	public PutTyreBehaviour(TyreCarrierAgent tyreCarrierAgent) {
		this.tyreCarrierAgent = tyreCarrierAgent;
	}

	@Override
	public void action() {
		putTyreBack();
		sendPutTyreBackMessageToChanger();
		
	}
	
	private void putTyreBack() {
		System.out.println(Constants.TYRE_PUT_BACK_MESSAGE);
	}
	
	private void sendPutTyreBackMessageToChanger() {
		AID tyreChangerAID = Utils.getTyreChangerAID();
		
		if(tyreChangerAID != null) {
			ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);
			aclMessage.addReceiver(tyreChangerAID);
			aclMessage.setContent(Constants.TYRE_PUT_BACK_MESSAGE);
			this.tyreCarrierAgent.send(aclMessage);
		}
		
	}

}
