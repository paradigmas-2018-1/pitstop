package Utils;

import jade.core.AID;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public final class Utils {
	
	public static AID searchForAgent(Agent agent, String name,
			String type) throws FIPAException {
		DFAgentDescription dfAgentDescription = new DFAgentDescription();
		ServiceDescription serviceDescription = new ServiceDescription();

		serviceDescription.setType(type);
		serviceDescription.setName(name);

		dfAgentDescription.addServices(serviceDescription);

		DFAgentDescription[] result = DFService.search(agent, dfAgentDescription);
		
		

		return result[0].getName();
	}

	public static void insertAgentIntoYellowPages(Agent agent, AID aid, String name,
			String type) throws FIPAException {
		DFAgentDescription dfAgentDescription = new DFAgentDescription();
		dfAgentDescription.setName(aid);

		ServiceDescription serviceDescription = new ServiceDescription();
		serviceDescription.setName(name);
		serviceDescription.setType(type);

		dfAgentDescription.addServices(serviceDescription);

		DFService.register(agent, dfAgentDescription);

	}
	
	public static AID getTyreChangerAID() {
		AID tyreChangerAID = null;
		try {
			tyreChangerAID = 
					Utils.searchForAgent(
							new Agent(),
							Constants.TYRE_CHANGER_AGENT_NAME,
							Constants.TYRE_CHANGER_AGENT_TYPE);
		} catch (FIPAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tyreChangerAID;
	}
	
	public static AID getPilotAID() {
		AID pilotAID = null;
		
		try {
			pilotAID = 
					Utils.searchForAgent(
							new Agent(),
							Constants.CAR_AGENT_NAME,
							Constants.CAR_AGENT_TYPE);
			
		} catch (FIPAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pilotAID;
	}
	
	public static AID getLollipopAID() {
		AID lollipopAID = null;
		
		try {
			lollipopAID = 
					Utils.searchForAgent(
							new Agent(),
							Constants.LOLLIPOP_AGENT_NAME,
							Constants.LOLLIPOP_AGENT_TYPE);
			
		} catch (FIPAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lollipopAID;
	}
}
