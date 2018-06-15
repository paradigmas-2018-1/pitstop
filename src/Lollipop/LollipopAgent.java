package Lollipop;

import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class LollipopAgent extends Agent {
	private final String NAME = "Lollipop";
	private final String TYPE = "Pitstop Crew";
	
	protected void setup() {
		insertIntoYellowPages();
	}
	
	private void insertIntoYellowPages() {
		DFAgentDescription dfAgentDescription = new DFAgentDescription();
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
}
