package Lollipop;

import Utils.Constants;
import Utils.Utils;
import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
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
		AID pilotAID = getPilotAID();
		
		if(pilotAID != null) {
			aclMessage.addReceiver(pilotAID);
			this.lollipopAgent.send(aclMessage);
			System.out.println(Constants.TURNING_LOLLIPOP_TO_STOP_MESSAGE);
		}
	}
	
	private AID getPilotAID() {
		AID pilotAID = null;
		
		try {
			DFAgentDescription[] result = 
					Utils.searchForAgent(this.lollipopAgent, Constants.CAR_AGENT_NAME, Constants.CAR_AGENT_TYPE);
			pilotAID = result[0].getName();
		} catch (FIPAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pilotAID;
		
		
	}

}
