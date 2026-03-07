package labPolymorphism;

/**
 * @author CSIS + Lydia
 */
public class SledDog extends Dog
{
    /**
     * @param b The breed of the dog.
     */
    public SledDog(String b)
    {
        super(b);
    }

    /**
     * The SledDog pulls a sled.
     */
    public void pullSled()
    {
        System.out.println("pulling the sled");
    }
}
