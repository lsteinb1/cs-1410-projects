package nuisance;

public class Telemarketer extends Person implements Nuisance {
	
	/**
	 * 
	 * @param name
	 * @param age
	 */
	public Telemarketer(String name, int age) {
		super(name, age);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @return
	 */
	public String giveSalesPitch() {
		return this.getName() + " pressures others to buy stuff";
	}

	/**
	 * 
	 */
	@Override
	public String annoy() {
		return this.getName() + " annoys by giving a sales pitch";
	}
}
