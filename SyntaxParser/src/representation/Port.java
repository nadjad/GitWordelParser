package representation;


public class Port {
	private String name;
	private Type type;

	public Port(String name, Type type) {
		super();
		this.name = name;
		// this.nature = nature;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public Type getType() {
		return type;
	}

	public boolean isCompatibleWith(Port second) {
		return this.type.equals(second.getType());
	}

	public boolean isCompatibleWith(Type type) {
		return this.type.equals(type);
	}

	@Override
	public String toString() {
		return this.name + "->" + this.type.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Port other = (Port) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
