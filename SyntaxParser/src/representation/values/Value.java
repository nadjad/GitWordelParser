package representation.values;

import representation.Type;

public abstract class Value {
	protected Type type;

	public Type getType() {
		return this.type;
	}

	public abstract Object getValue();

	// @Override
	// public abstract String toString();
}
