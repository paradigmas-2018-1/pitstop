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
		
		AID agentsAID = result[0].getName();
		
		if(agentsAID == null) {
			System.out.println("Null AID:" + name + " and " + type);
		}
		

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
	
	public static AID getTyreChangerAID(Agent agent) {
		AID tyreChangerAID = null;
		try {
			tyreChangerAID = 
					searchForAgent(
							agent,
							Constants.TYRE_CHANGER_AGENT_NAME,
							Constants.TYRE_CHANGER_AGENT_TYPE);
		} catch (FIPAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tyreChangerAID;
	}
	
	public static AID getPilotAID(Agent agent) {
		AID pilotAID = null;
		
		try {
			pilotAID = 
					Utils.searchForAgent(
							agent,
							Constants.CAR_AGENT_NAME,
							Constants.CAR_AGENT_TYPE);
			
		} catch (FIPAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pilotAID;
	}
	
	public static AID getLollipopAID(Agent agent) {
		AID lollipopAID = null;
		
		try {
			lollipopAID = 
					Utils.searchForAgent(
							agent,
							Constants.LOLLIPOP_AGENT_NAME,
							Constants.LOLLIPOP_AGENT_TYPE);
			
		} catch (FIPAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lollipopAID;
	}
	
	public static AID getTyreCarrierAID(Agent agent) {
		AID tyreCarrierAID = null;
		try {
			tyreCarrierAID = 
					Utils.searchForAgent(agent, Constants.TYRE_CARRIER_AGENT_NAME, 
							Constants.TYRE_CARRIER_AGENT_TYPE);
		} catch (FIPAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tyreCarrierAID;
	}
}
