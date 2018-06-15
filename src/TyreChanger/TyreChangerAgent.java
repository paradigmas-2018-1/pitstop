package TyreChanger;

import jade.core.Agent;
import jade.domain.FIPAException;
import Utils.*;

public class TyreChangerAgent extends Agent{

	private static final long serialVersionUID = 1L;
	private ListenForLollipopMessageBehaviour listenForLollipopMessageBehaviour;
	private ListenForTyreCarrierMessage listenForTyreCarrierMessage;
	private ScrewTyreBehaviour screwTyreBehaviour;
	
	protected void setup() {
		insertAgentIntoYellowPages();
		
		listenForLollipopMessageBehaviour = new ListenForLollipopMessageBehaviour(this);
		listenForTyreCarrierMessage = new ListenForTyreCarrierMessage(this);
		
		addBehaviour(listenForLollipopMessageBehaviour);
		addBehaviour(listenForTyreCarrierMessage);
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

	public void addChangeTyreBehaviour(UnscrewTyreBehaviour changeTyreBehaviour) {
		addBehaviour(changeTyreBehaviour);
	}

	public void setScrewTyreBehaviour(ScrewTyreBehaviour screwTyreBehaviour) {
		this.screwTyreBehaviour = screwTyreBehaviour;
		
	}

	public void addScrewTyreBehaviour() {
		addBehaviour(this.screwTyreBehaviour);
	}

	public void removeListenForTyreCarrierMessageBehaviour() {
		this.removeBehaviour(this.listenForTyreCarrierMessage);
		
	}
}
