package exam;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WordPowerPlantTest {
	WordPowerPlant hydroTest = new HydroWordPlant(300, true);
	WordPowerPlant solarTest = new SolarWordPlant(200);
	WordPowerPlant plantTest = new WordPowerPlant(100);
	
	@Test
	void generatesElectricity_HydroVersion_FromWater() {
		String expected = "generating electricity from water";
		String actual = hydroTest.generatesElectricity();
		assertEquals(expected, actual);
	}
	
	@Test
	void generatesElectricity_SolarVersion_FromTheSun() {
		assertEquals("generating electricity from the sun", solarTest.generatesElectricity());
	}
	
	@Test
	void generatesElectricity_RegularVersion_GeneratingElectricity() {
		assertEquals("generating electricity", plantTest.generatesElectricity());
	}
	
	@Test
	void transform_IsNull_ReturnsNull() {
		assertNull(plantTest.transform(null));
	}
	
	@Test
	void transform_IsEmpty_ReturnsEmpty() {
		assertEquals("", plantTest.transform(""));
	}
	
	@Test
	void transform_UnderscoresInWord_RemovesUnderscores() {
		assertEquals(false, plantTest.transform("hi_ho").contains("_"));
	}
	
	@Test
	void transform_StartsWithA_StartsWithUppercaseA() {
		assertEquals(true, plantTest.transform("apple").startsWith("A"));
	}
	
	@Test
	void transform_EndsWithZ_EndsWithUppercaseZ() {
		assertEquals(true, plantTest.transform("fez").contains("feZ"));
	}
	
	@Test
	void transform_ReversedAppend_EndsWithReversed() {
		assertEquals(true, plantTest.transform("hiho").endsWith("ohih"));
	}
	
	@Test
	void countLetters_NullHandling_ThrowsException() {
		assertThrows(IllegalArgumentException.class, () -> {plantTest.countLetters(null);});
	}
	
	@Test
	void countLetters_NormalWord_CountsLetters() {
		assertEquals(5, plantTest.countLetters("apple"));
	}
	
	@Test
	void countLetters_WordWithAe_CountsAeAsOne() {
		assertEquals(5, plantTest.countLetters("aether"));
	}
	
	@Test
	void countLetters_WordWithOe_CountsOeAsOne() {
		assertEquals(3, plantTest.countLetters("toes"));
	}
	
	@Test
	void countLetters_WordWithUe_CountsUeAsOne() {
		assertEquals(4, plantTest.countLetters("fuego"));
	}
	
	@Test
	void countLetters_WordWithEu_CountsEuAsOne() {
		assertEquals(5, plantTest.countLetters("Eugene"));
	}
}
