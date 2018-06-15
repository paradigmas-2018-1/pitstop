package Car;

import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class CarAgent extends Agent {
	
	private static final long serialVersionUID = 1L;
	
	private int tyreQuality;
	private RunBehaviour runBehaviour;
	private WearTyreBehaviour wearTyreBehaviour;
	private GoToPitstopBehaviour goToPitstopBehaviour;
	private final String NAME = "Car";
	private final String TYPE = "car";
	
	protected void setup() {
		setTyreQuality(100);
		
		runBehaviour = new RunBehaviour(this);
		
		insertIntoYellowPages();
		
		addBehaviour(runBehaviour);
	}
	
	private void insertIntoYellowPages() {
		DFAgentDescription dfAgentDescription = new DFAgentDescription();
		dfAgentDescription.setName(getAID());
		ServiceDescription serviceDescription = new ServiceDescription();
		serviceDescription.setName(NAME);
		serviceDescription.setType(TYPE);
		dfAgentDescription.addServices(serviceDescription);
		
		try {
			DFService.register(this, dfAgentDescription);
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

}
