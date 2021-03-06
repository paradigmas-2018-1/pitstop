package Car;

import Utils.Constants;
import Utils.Utils;
import jade.core.Agent;
import jade.domain.FIPAException;

public class CarAgent extends Agent {
	
	private static final long serialVersionUID = 1L;
	
	private int tyreQuality;
	private RunBehaviour runBehaviour;
	private WearTyreBehaviour wearTyreBehaviour;
	private GoToPitstopBehaviour goToPitstopBehaviour;
	private SearchForLollipopBehaviour searchForLollipopBehaviour;
	
	protected void setup() {
		this.tyreQuality = 100;
		
		runBehaviour = new RunBehaviour(this);
		
		insertIntoYellowPages();
		
		addBehaviour(runBehaviour);
	}
	
	private void insertIntoYellowPages() {
		try {
			Utils.insertAgentIntoYellowPages(this, getAID(), Constants.CAR_AGENT_NAME,
					Constants.CAR_AGENT_TYPE);
		} catch (FIPAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setTyreQuality(int tyreQuality) {
		if(tyreQuality <= 0) {
			tyreQuality = 0;
		}
		
		this.tyreQuality = tyreQuality;
	}
	
	public int getTyreQuality() {
		return this.tyreQuality;
	}
	
	public void informCurrentTyreQuality() {
		System.out.println("Qualidade dos pneus: " + getTyreQuality() + "!\n");
	}
	
	public void addRunBehaviour() {
		this.addBehaviour(runBehaviour);
	}
	
	public void removeRunBehaviour() {
		this.removeBehaviour(runBehaviour);
	}	
	
	public void addWearTyreBehaviour() {
		this.addBehaviour(wearTyreBehaviour);
	}
	
	public void removeWearTyreBehaviour() {
		this.removeBehaviour(wearTyreBehaviour);
	}	
	
	public void setWearTyreBehaviour(WearTyreBehaviour wearTyreBehaviour) {
		this.wearTyreBehaviour = wearTyreBehaviour;
	}
	
	public void addGoToPitstopBehaviour() {
		this.addBehaviour(goToPitstopBehaviour);
	}
	
	public void removeGoToPitstopBehaviour() {
		this.removeBehaviour(goToPitstopBehaviour);
	}
	
	public void setGoToPitstopBehaviour(GoToPitstopBehaviour goToPitstopBehaviour) {
		this.goToPitstopBehaviour = goToPitstopBehaviour;
	}

	public void setSearchForLollipopBehaviour(
			SearchForLollipopBehaviour searchForStopLollipopBehaviour) {
		this.searchForLollipopBehaviour = searchForStopLollipopBehaviour;
		
	}

	public void addSearchForLollipopBehaviour() {
		addBehaviour(this.searchForLollipopBehaviour);
	}
	
	public void startRunBehaviour() {
		addBehaviour(this.runBehaviour);
	}
	
	public SearchForLollipopBehaviour getSearchForLollipopBehaviour() {
		return this.searchForLollipopBehaviour;
	}

}
