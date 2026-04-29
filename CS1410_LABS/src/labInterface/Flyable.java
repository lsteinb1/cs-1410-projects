package labInterface;

/**
 * An interface for objects that can fly, by first launching (taking off), and at the end landing.
 * 
 * @author Lydia
 */
public interface Flyable {
	
	/**
	 * Prints a message describing how the given object takes off.
	 */
	void launch();
	
	/**
	 * Prints a message describing how the given object lands.
	 */
	void land();
}
