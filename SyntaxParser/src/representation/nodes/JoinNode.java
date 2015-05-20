package representation.nodes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import representation.Node;
import representation.Port;
import representation.values.Value;

public class JoinNode extends Node {

	private static int numberOfInstances = 0;
	private Map<Value, List<Port>> branchPorts;

	public JoinNode(List<String> inPorts) {
		super("join" + numberOfInstances, null);
		numberOfInstances++;
		this.outPorts = createPorts(inPorts);
		// TODO Auto-generated constructor stub
	}

	public void addCasePorts(Value value, List<String> portNames) {
		this.branchPorts.put(value, createPorts(portNames));
	}

	private List<Port> createPorts(List<String> portNames) {
		List<Port> ports = new ArrayList<Port>();
		for (String s : portNames) {
			ports.add(new Port(s, null));
		}
		return ports;
	}
}
