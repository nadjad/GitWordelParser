package representation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Operator implements Serializable {

	protected String name;
	protected List<Port> inputs;
	protected List<Port> outputs;

	public Operator(String name) {
		super();
		this.name = name;
		this.inputs = new ArrayList<Port>();
		this.outputs = new ArrayList<Port>();
	}

	public Operator(String name, List<Port> inputs, List<Port> outputs) {
		super();
		this.name = name;
		this.inputs = inputs;
		this.outputs = outputs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Port> getInputs() {
		return inputs;
	}

	public void setInputs(List<Port> inputs) {
		this.inputs = inputs;
	}

	public List<Port> getOutputs() {
		return outputs;
	}

	public Port getInputPort(int nr) {
		return this.inputs.get(nr);
	}

	public Port getOutputPort(int nr) {
		return this.outputs.get(nr);
	}

	public void setOutputs(List<Port> outputs) {
		this.outputs = outputs;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Port p : this.inputs)
			sb.append(p.toString() + " ");
		sb.append("\n\t");
		for (Port p : this.outputs)
			sb.append(p.toString() + " ");
		String s = "op:" + this.name + "\n\t" + new String(sb);
		return s;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Operator other = (Operator) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
