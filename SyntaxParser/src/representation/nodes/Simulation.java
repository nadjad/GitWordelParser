package representation.nodes;

import java.util.List;

import representation.Node;
import representation.values.Value;

public class Simulation {
	private String userID;
	private String simID;
	private FlowNode flow;
	private Node node;
	private List<Value> inputs;
	private List<String> outputs;

	public Simulation(String userID, String simID, FlowNode flow,
			List<Value> inputs, List<String> outputs) {
		this(flow, inputs, outputs);
		this.userID = userID;
		this.simID = simID;
	}

	public Simulation(FlowNode flow, List<Value> inputs, List<String> outputs) {
		super();
		this.flow = flow;
		this.inputs = inputs;
		this.outputs = outputs;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getSimID() {
		return simID;
	}

	public void setSimID(String simID) {
		this.simID = simID;
	}

	public FlowNode getFlowNode() {
		return flow;
	}

	public List<Value> getInputs() {
		return inputs;
	}

	public List<String> getOutputs() {
		return outputs;
	}

}
