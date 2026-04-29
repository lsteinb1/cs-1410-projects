package balloon;

import java.util.Objects;

public class Balloon {
	private BalloonSize size;
	private BalloonType type;
	
	/**
	 * @param size
	 * @param type
	 */
	public Balloon(BalloonSize size, BalloonType type) {
		this.size = size;
		this.type = type;
	}

	/**
	 * @return the size
	 */
	public BalloonSize getSize() {
		return size;
	}

	/**
	 * @return the type
	 */
	public BalloonType getType() {
		return type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(size, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Balloon other = (Balloon) obj;
		return size == other.size && type == other.type;
	}

	@Override
	public String toString() {
		return type + " " + size;
	}
}
