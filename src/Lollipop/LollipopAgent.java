package Lollipop;

import Utils.Constants;
import Utils.Utils;
import jade.core.Agent;
import jade.domain.FIPAException;

public class LollipopAgent extends Agent {
	private static final long serialVersionUID = 1L;
	private ListenForPilotMessageBehaviour listenForPilotCallBehaviour;
	private TurnLollipopToStopBehaviour turnLollipopToStopBehaviour;
	private ListenForTyreChangerMessageBehaviour listenForTyreChangerMessageBehaviour;
	private TurnLollipopToRunBehaviour turnLollipopToRunBehaviour;
	
	protected void setup() {
		insertIntoYellowPages();
		
		listenForPilotCallBehaviour = new ListenForPilotMessageBehaviour(this);
		listenForTyreChangerMessageBehaviour = new ListenForTyreChangerMessageBehaviour(this);
		
		addBehaviour(listenForPilotCallBehaviour);
		addBehaviour(listenForTyreChangerMessageBehaviour);
	}
	
	private void insertIntoYellowPages() {
		try {
			Utils.insertAgentIntoYellowPages(this, getAID(), Constants.LOLLIPOP_AGENT_NAME,
					Constants.LOLLIPOP_AGENT_TYPE);
		} catch (FIPAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void removeListenForPilotCallBehaviour() {
		removeBehaviour(listenForPilotCallBehaviour);
	}
	
	public void addListenForPilotCallBehaviour() {
		addBehaviour(listenForPilotCallBehaviour);
	}
	
	public void addTurnLollipopToStopBehaviour() {
		this.addBehaviour(this.turnLollipopToStopBehaviour);
	}
	
	public void setTurnLollipopToStopBehaviour(TurnLollipopToStopBehaviour turnLollipopToStopBehaviour) {
		this.turnLollipopToStopBehaviour = turnLollipopToStopBehaviour;
	}

	public void removeListenForTyreChangerMessageBehaviour() {
		removeBehaviour(listenForTyreChangerMessageBehaviour);
		
	}

	public void setTurnLollipopToRunBehaviour(TurnLollipopToRunBehaviour turnLollipopToRunBehaviour) {
		this.turnLollipopToRunBehaviour = turnLollipopToRunBehaviour;
	}
	
	public void addTurnLollipopToRunBehaviour() {
		addBehaviour(this.turnLollipopToRunBehaviour);
	}
	
}
 