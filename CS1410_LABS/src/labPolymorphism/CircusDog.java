package labPolymorphism;

/**
 * @author CSIS + Lydia
 */
public class CircusDog extends Dog
{
    /**
     * @param b The breed of the dog.
     */
    public CircusDog(String b)
    {
        super(b);
    }

    @Override
    public void move()
    {
        System.out.println("tightrope walking");
    }
}
