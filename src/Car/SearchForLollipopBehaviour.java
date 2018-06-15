package Car;

import Utils.Constants;
import Utils.Utils;
import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class SearchForLollipopBehaviour extends CyclicBehaviour {

	private static final long serialVersionUID = 1L;
	private CarAgent carAgent;
	
	public SearchForLollipopBehaviour(CarAgent carAgent) {
		this.carAgent = carAgent;
	}
	
	@Override
	public void action() {
		String message = getLollipopMessage();
		
		if(message != null) {
			boolean isStop = checkIfMessageIsStop(message);
			
			if(isStop) {
				stop();
				sendStopMessageToLollipop();
			} else {
				boolean isRun = checkIfMessageIsRun(message);
				if(isRun) {
					run();
				}
			}
		}
		
	}
	
	private boolean checkIfMessageIsStop(String message) {
		if(message.equals(Constants.TURNING_LOLLIPOP_TO_STOP_MESSAGE)) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean checkIfMessageIsRun(String message) {
		if(message.equals(Constants.TURNING_LOLLIPOP_TO_RUN_MESSAGE)) {
			return true;
		} else {
			return false;
		}
	}
	
	private String getLollipopMessage() {
		ACLMessage aclMessage = this.carAgent.receive();
		
		String message = null;
		if(aclMessage != null) {
			message = aclMessage.getContent();
		}
		
		return message;
	}
	
	private void sendStopMessageToLollipop() {
		AID lollipopAID = Utils.getLollipopAID(this.carAgent);
		
		if(lollipopAID != null) {
			ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);
			aclMessage.addReceiver(lollipopAID);
			aclMessage.setContent(Constants.CAR_STOP_MESSAGE);
			this.carAgent.send(aclMessage);
		}
	}
	
	private void stop() {
		System.out.println("PAREI!");
		this.carAgent.removeRunBehaviour();
		this.carAgent.removeWearTyreBehaviour();
	}
	
	private void run() {
		this.carAgent.startRunBehaviour();	
	}

}
