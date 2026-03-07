package unitTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TreasureChestTest {
	private TreasureChest treasure;
	private TreasureChest emptyChest;
	
	@BeforeEach
	void setUp() throws Exception {
		treasure = new TreasureChest(10);
		emptyChest = new TreasureChest(0);
	}

	@Test
	void treasureChest_PositiveNumberOfCoins_AllCoinsStoredInTreasureChest() {
		TreasureChest treasure7 = new TreasureChest(7);
		int expected = 7;
		int actual = treasure7.getGold();
		assertEquals(expected, actual);
	}
	
	@Test
	void treasureChest_NoCoins_NoCoinsStoredInTreasureChest() {
		int expected = 0; // she made a new instance with 0 here, but I'm pretty sure you can just use emptyChest
		int actual = emptyChest.getGold();
		assertEquals(expected, actual);
	}
	
	@Test
	void treasureChest_NegativeCoins_ThrowsIllegalArgumentException() {
		// TreasureChest illegalTreasure = new TreasureChest(-1);
		assertThrows(IllegalArgumentException.class, () -> {new TreasureChest(-1);}); // lambda expression
	}

	@Test
	void addGold_PositiveAddedCoins_CoinValueUpdatesByAddedCoins() { // she wrote as AddingPositiveNumberOfCoins_IncreasesNumberOfCoinsInTreasureChest
		treasure.addGold(5);
		int expected = 15;
		int actual = treasure.getGold();
		assertEquals(expected, actual);
	}
	
	@Test
	void addGold_NoAddedCoins_CoinValueStaysTheSame() { // I didn't add this one to begin with. she wrote as AddingZeroCoins_LeaveNumberOfCoinsInTreasureChestUnchanged
		treasure.addGold(0);
		int expected = 10;
		int actual = treasure.getGold();
		assertEquals(expected, actual);
	}
	
	@Test
	void addGold_AddingNegativeCoins_ThrowsIllegalArgumentException() { // she wrote as AddingNegativeNumberOfCoins
		assertThrows(IllegalArgumentException.class, () -> {treasure.addGold(-5);}); // lambda expression
	}
	
	@Test
	void removeGold_PositiveTakenCoins_CoinValueUpdatesByTakenCoins() { // she wrote RemovingSomeOfTheAvailableCoins_ReducesNumberOfCoinsInTreasureChest
		treasure.removeGold(5);
		int expected = 5;
		int actual = treasure.getGold();
		assertEquals(5, treasure.removeGold(5));
	}
	
	@Test
	void removeGold_NoTakenCoins_CoinValueStaysTheSame() { // she wrote
		treasure.removeGold(0);
		int expected = 10;
		int actual = treasure.getGold();
		assertEquals(expected, actual);
	}
	
	@Test
	void removeGold_TakesAllCoins_EmptiesChest() { // I didn't include this one to begin with. she wrote
		treasure.removeGold(10);
		int expected = 0;
		int actual = treasure.getGold();
		assertEquals(expected, actual);
	}
	
	@Test
	void removeGold_TakingMoreCoinsThanInChest_ThrowsIllegalArgumentException() { // she wrote 
		assertThrows(IllegalArgumentException.class, () -> {treasure.removeGold(11);}); // lambda expression
	}
	
	@Test
	void removeGold_TakingNegativeCoins_ThrowsIllegalArgumentException() { // she wrote 
		assertThrows(IllegalArgumentException.class, () -> {treasure.removeGold(-5);}); // lambda expression
	}
	
	@Test
	void removeGold_ReturnCorrectValue_ReturnsChangedGoldAmount() { // I didn't add this one to begin with. she wrote as 
		int expected = 5;
		int actual = treasure.removeGold(5);
		assertEquals(expected, actual);
	}
	
	// 面倒くさい第一番め： test return for removing multiple, 

	@Test
	void testSetGoldPrice() {
		fail("Not yet implemented");
	}

	@Test
	void testValueInDollars() {
		fail("Not yet implemented");
	}

	@Test
	void toString_PositiveNumberOfCoins_ReturnNumberCoinsInBrackets() {
		String expected = "[ 10 coins ]";
		String actual = treasure.toString();
		assertEquals(expected, actual);
	}
	
	@Test
	void toString_NoCoins_Return0CoinsInBrackets() {
		String expected = "[ 0 coins ]";
		String actual = emptyChest.toString();
		assertEquals(expected, actual);
	}
	
	@Test
	void toString_ReturnCorrectValue_ReturnsValueOfGetGold() { // I didn't add this one to begin with. she wrote as 
		int expected = treasure.getGold();
		String actual = treasure.toString();
		assertEquals(expected, actual);
	}

}
