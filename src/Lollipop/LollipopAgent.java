package Lollipop;

import Utils.Constants;
import Utils.Utils;
import jade.core.Agent;
import jade.domain.FIPAException;

public class LollipopAgent extends Agent {
	private static final long serialVersionUID = 1L;
	private ListenForPilotCallBehaviour listenForPilotCallBehaviour;
	
	protected void setup() {
		insertIntoYellowPages();
		
		listenForPilotCallBehaviour = new ListenForPilotCallBehaviour(this);
		
		addBehaviour(listenForPilotCallBehaviour);
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
}
 