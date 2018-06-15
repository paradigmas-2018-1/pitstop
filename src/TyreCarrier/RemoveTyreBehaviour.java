package TyreCarrier;

import Utils.Constants;
import jade.core.behaviours.OneShotBehaviour;

public class RemoveTyreBehaviour extends OneShotBehaviour{

	private static final long serialVersionUID = 1L;
	private TyreCarrierAgent tyreCarrierAgent;
	
	public RemoveTyreBehaviour(TyreCarrierAgent tyreCarrierAgent) {
		this.tyreCarrierAgent = tyreCarrierAgent;
	}
	
	@Override
	public void action() {
		removeTyre();
		putTyreBack();
	}
	
	private void removeTyre() {
		System.out.println(Constants.TYRE_REMOVED_MESSAGE);
	}
	
	private void putTyreBack() {
		PutTyreBehaviour putTyreBehaviour = new PutTyreBehaviour(this.tyreCarrierAgent);
		this.tyreCarrierAgent.setPutTyreBehaviour(putTyreBehaviour);
		this.tyreCarrierAgent.addPutTyreBehaviour();
	}

	
}
