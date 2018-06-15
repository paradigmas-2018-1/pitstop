package TyreChanger;

import jade.core.Agent;
import jade.domain.FIPAException;
import Utils.*;

public class TyreChangerAgent extends Agent{

	private ListenForLollipopMessageBehaviour listenForLollipopMessageBehaviour;
	
	protected void setup() {
		insertAgentIntoYellowPages();
		
		listenForLollipopMessageBehaviour = new ListenForLollipopMessageBehaviour(this);
		
		addBehaviour(listenForLollipopMessageBehaviour);
	}
	
	private void insertAgentIntoYellowPages() {
		try {
			Utils.insertAgentIntoYellowPages(this, getAID(), Constants.TYRE_CHANGER_AGENT_NAME,
					Constants.TYRE_CHANGER_AGENT_TYPE);
		} catch (FIPAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void removeListenForLollipopMessageBehaviour() {
		removeBehaviour(listenForLollipopMessageBehaviour);
	}

	public void addChangeTyreBehaviour(ChangeTyreBehaviour changeTyreBehaviour) {
		addBehaviour(changeTyreBehaviour);
	}
}
