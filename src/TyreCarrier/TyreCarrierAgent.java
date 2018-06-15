package TyreCarrier;

import jade.core.Agent;
import jade.domain.FIPAException;
import Utils.*;

public class TyreCarrierAgent extends Agent {
	
	private RemoveTyreBehaviour removeTyreBehaviour;
	private PutTyreBehaviour putTyreBehaviour;
	
	protected void setup() {
		insertAgentIntoYellowPages();
	}
	
	private void insertAgentIntoYellowPages() {
		try {
			Utils.insertAgentIntoYellowPages(this, getAID(), Constants.TYRE_CARRIER_AGENT_NAME,
					Constants.TYRE_CARRIER_AGENT_TYPE);
		} catch (FIPAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setRemoveTyreBehaviour(RemoveTyreBehaviour removeTyreBehaviour) {
		this.removeTyreBehaviour = removeTyreBehaviour;
		
	}
	
	public void addRemoveTyreBehaviour() {
		addBehaviour(this.removeTyreBehaviour);
	}

	public void setPutTyreBehaviour(PutTyreBehaviour putTyreBehaviour) {
		this.putTyreBehaviour = putTyreBehaviour;
		
	}
	
	public void addPutTyreBehaviour() {
		addBehaviour(this.putTyreBehaviour);
	}
}
