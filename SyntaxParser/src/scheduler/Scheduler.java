package scheduler;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import representation.Connection;
import representation.ConnectionEnd;
import representation.nodes.FlowNode;
import representation.nodes.Simulation;
import scheduler.datamodel.OpElement;

public class Scheduler {

	public List<String> schedule(Simulation sim) {

		return null;
	}

	private Set<OpElement> getFirstLevelNodes(FlowNode flow) {
		Set<OpElement> firstLevel = new HashSet<OpElement>();
		Map<String, Connection> inConns = flow.getInConnections();
		Collection<Connection> conns = inConns.values();
		for (Connection con : conns) {
			List<ConnectionEnd> destinations = con.getDestinations();
			// for (ConnectionEnd destiantion : destinations)
			// firstLevel.add(new OpElement(destiantion.ge, identifier));
		}
		return firstLevel;
	}
}
