import java.util.Arrays;

public class Ship {

	private String name;
	private String[] boxes;
	
	public Ship(String name, String[] boxes) {
		super();
		this.name = name;
		this.boxes = boxes;
	}
	public Ship(String name) {
		super();
		this.name = name;
	}
	public Ship() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getBoxes() {
		return boxes;
	}
	public void setBoxes(String[] boxes) {
		this.boxes = boxes;
	}
	@Override
	public String toString() {
		return "Ship [name=" + name + ", boxes=" + Arrays.toString(boxes) + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(boxes);
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
		Ship other = (Ship) obj;
		if (!Arrays.equals(boxes, other.boxes))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}
