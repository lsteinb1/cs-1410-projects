package labPolymorphism;

/**
 * @author CSIS + Lydia
 */
public class Dog
{
    private final String breed;

    /**
     * @param String b The breed of the dog.
     */
    public Dog(String b)
    {
        breed = b;
    }

    /**
     * How the Dog communicates/the vocal sound they make.
     */
    public void communicate()
    {
        System.out.println("bark bark");
    }

    /**
     * The characteristic way the Dog moves.
     */
    public void move()
    {
        System.out.println("run");
    }

    /**
     * @return String The breed of the dog.
     */
    public String getBreed()
    {
        return breed;
    }
    
    @Override
    public String toString() {
    	String dogString = this.getClass().getSimpleName() + ": " + getBreed();
    	return dogString;
    }
}
