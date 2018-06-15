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
		System.out.println("Movendo lolipop pra stop!");
		turnLollipop();
		sendStopMessageToPilot();
	}
	
	private void turnLollipop() {
		System.out.println(Constants.PILOT_COMMING_MESSAGE);
	}
	
	private void sendStopMessageToPilot() {
		
		AID pilotAID = Utils.getPilotAID(this.lollipopAgent);
		
		if(pilotAID != null) {
			System.out.println("Enviando mensagem pro piloto: Para por favor.");
			ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);
			aclMessage.setContent(Constants.TURNING_LOLLIPOP_TO_STOP_MESSAGE);
			aclMessage.addReceiver(pilotAID);
			this.lollipopAgent.send(aclMessage);
		}
	}

}
