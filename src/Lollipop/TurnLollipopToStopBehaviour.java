package Lollipop;

import Utils.Constants;
import Utils.Utils;
import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class TurnLollipopToStopBehaviour extends OneShotBehaviour{
	private static final long serialVersionUID = 1L;
	private LollipopAgent lollipopAgent;
	
	public TurnLollipopToStopBehaviour(LollipopAgent lollipopAgent) {
		this.lollipopAgent = lollipopAgent;
	}
	
	@Override
	public void action() {
		turnLollipop();
		sendStopMessageToPilot();
	}
	
	private void turnLollipop() {
		System.out.println(Constants.TURNING_LOLLIPOP_TO_STOP_MESSAGE);
	}
	
	private void sendStopMessageToPilot() {
		
		AID pilotAID = Utils.getPilotAID(this.lollipopAgent);
		
		if(pilotAID != null) {
			
			ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);
			aclMessage.setConversationId(Constants.LOLLIPOP_TO_CAR);
			aclMessage.setContent(Constants.TURNING_LOLLIPOP_TO_STOP_MESSAGE);
			aclMessage.addReceiver(pilotAID);
			this.lollipopAgent.send(aclMessage);
		}
	}

}
