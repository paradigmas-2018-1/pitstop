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
		sendStopMessageToPilot();
	}
	
	private void sendStopMessageToPilot() {
		ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);
		aclMessage.setContent(Constants.TURNING_LOLLIPOP_TO_STOP_MESSAGE);
		AID pilotAID = Utils.getPilotAID(this.lollipopAgent);
		
		if(pilotAID != null) {
			aclMessage.addReceiver(pilotAID);
			this.lollipopAgent.send(aclMessage);
			System.out.println(Constants.TURNING_LOLLIPOP_TO_STOP_MESSAGE);
		}
	}

}
