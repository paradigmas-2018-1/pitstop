package Lollipop;

import Utils.Constants;
import Utils.Utils;
import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class TurnLollipopToRunBehaviour extends OneShotBehaviour{

	private static final long serialVersionUID = 1L;
	private LollipopAgent lollipopAgent;
	
	public TurnLollipopToRunBehaviour(LollipopAgent lollipopAgent) {
		this.lollipopAgent = lollipopAgent;
	}
	
	@Override
	public void action() {
		turnLollipopToRun();
		sendRunMessageToPilot();
		startListeningToPilot();
	}
	
	private void turnLollipopToRun() {
		System.out.println(Constants.TURNING_LOLLIPOP_TO_RUN_MESSAGE);
	}
	
	private void sendRunMessageToPilot() {
		AID pilotAID = Utils.getPilotAID(this.lollipopAgent);
		
		
		if(pilotAID!= null) {
			ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);
			
			aclMessage.setConversationId(Constants.LOLLIPOP_TO_CAR);
			aclMessage.addReceiver(pilotAID);
			aclMessage.setContent(Constants.TURNING_LOLLIPOP_TO_RUN_MESSAGE);
			lollipopAgent.send(aclMessage);
		}
	}
	
	private void startListeningToPilot() {
		this.lollipopAgent.addListenForPilotCallBehaviour();
	}

}
