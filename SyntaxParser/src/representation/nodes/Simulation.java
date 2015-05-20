package representation.nodes;

import java.util.List;

import representation.values.Value;

public class Simulation {
	private String userID;
	private String simID;
	private FlowNode flow;
	private List<Value> inputs;
	private List<Value> outputs;

	public Simulation(String userID, String simID, FlowNode flow,
			List<Value> inputs, List<Value> outputs) {
		super();
		this.userID = userID;
		this.simID = simID;
		this.flow = flow;
		this.inputs = inputs;
		this.outputs = outputs;
	}

	public Simulation(FlowNode flow, List<Value> inputs, List<Value> outputs) {
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

	public FlowNode getFlow() {
		return flow;
	}

	public List<Value> getInputs() {
		return inputs;
	}

	public List<Value> getOutputs() {
		return outputs;
	}

}
