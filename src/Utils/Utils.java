package Utils;

import jade.core.AID;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public final class Utils {
	public static DFAgentDescription[] searchForAgent(Agent agent, String name,
			String type) throws FIPAException {
		System.out.println(name);
		DFAgentDescription dfAgentDescription = new DFAgentDescription();
		ServiceDescription serviceDescription = new ServiceDescription();

		serviceDescription.setType(type);
		serviceDescription.setName(name);

		dfAgentDescription.addServices(serviceDescription);

		DFAgentDescription[] result = DFService.search(agent, dfAgentDescription);

		return result;
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
}
