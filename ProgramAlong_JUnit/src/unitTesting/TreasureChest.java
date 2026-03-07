package unitTesting;

import java.math.BigDecimal;

/**
 * 
 * @author LydiaS
 * 
 */
public class TreasureChest {
	/**
	 * Number of gold coins.
	 */
	private int gold; // these go here, not in the constructor
	/**
	 * Price of an ounce of gold.
	 */
	private static BigDecimal goldPrice;
	/**
	 * Amount of gold per coin measured in ounces.
	 */
	private static final BigDecimal GOLD_PER_COIN = new BigDecimal(0.9675);
	
	/**
	 * Initializes a newly created TreasureChest with the specified number of gold coins.
	 * <p>
	 * @param goldCoins the number of gold coins in the newly created treasure chest.
	 * @throws IllegalArgumentException if <code>goldCoins</code> is negative.
	 */
	public TreasureChest(int goldCoins)
	{
		if(goldCoins < 0)
			throw new IllegalArgumentException("The number of gold coins in the treasure chest can't be negative.");
		
		this.gold = goldCoins;
	}
	
	/**
	 * @return the amount of gold in this treasure chest
	 */
	public int getGold()
	{
		return gold;
	}
	
	/**
	 * Adds the specified number of coins to this treasure chest.
	 * <p>
	 * @param numberOfCoins number of coins to be added
	 * @throws IllegalArgumentException if the <code>numberOfCoins</code> is negative
	 */
	public void addGold(int numberOfCoins)
	{
		if(numberOfCoins < 0)
			throw new IllegalArgumentException("Adding a negative number of coins would be taking them away. This is for adding.");
		/* she wrote as:
		 * throw new IllegalArgumentException("The number of gold coins "
		 * + " added to the treasure chest can't be negative.");
		 */
		
		gold += numberOfCoins;
	}
	
	/**
	 * Removes the specified number of coins from this treasure chest.
	 * <p>
	 * @param numberOfCoins number of coins to be removed
	 * @return the number of gold coins left in the treasure chest
	 * @throws IllegalArgumentException if the <code>numberOfCoins</code> is negative
	 * 		or if the <code>numberOfCoins</code> exceeds the number of gold coins
	 * 		in this treasure chest.
	 */
	public int removeGold(int numberOfCoins)
	{
		if(numberOfCoins < 0) // you can also test for two conditions with || between them and make the error message reflect either, like she did
			throw new IllegalArgumentException("Taking away a negative number of coins would be adding them. This is for taking.");
		else if (numberOfCoins > gold)
			throw new IllegalArgumentException("These are more coins than the chest has in it.");
		
		gold -= numberOfCoins;
		int remainingGold = gold;
		
		return remainingGold;
	}
	
	/**
	 * @return the goldPrice
	 */
	public static BigDecimal getGoldPrice()
	{
		return goldPrice;
	}
	
	/**
	 * @param goldPrice
	 */
	public static void setGoldPrice(BigDecimal goldPrice)
	{
		// TODO
	}
	
	/**
	 * @return
	 */
	public BigDecimal valueInDollars()
	{
		return null; // TODO
	}
	
	/**
	 *
	 */
	
	@Override
	public String toString()
	{
		String goldIn = String.valueOf(getGold());
		String goldInChest = "[ " + goldIn + " coins ]";
		return goldInChest; // could have just been "[ " + gold + " coins ]";
	}
}
