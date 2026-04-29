package labInterface;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PlaneTest {
	private static ByteArrayOutputStream message;
	private static PrintStream consoleOutput;
	private Plane myPlane = new Plane(2, "A320"); 

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		consoleOutput = System.out;
		
		// redirect System.out to write to a byteArray instead
		message = new ByteArrayOutputStream();
		PrintStream newOutput = new PrintStream(message);
		System.setOut(newOutput);
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		// set System.out back to console output
		System.setOut(consoleOutput);
	}

	@Test
	void launch_ValidatePrintedMessage() {
		myPlane.launch();
		
		String expected = "Rolling until take-off" + System.lineSeparator();
		String actual = message.toString();
		assertEquals(expected, actual);
		
		// Prevent accidentally checking messages from this test in other tests
		message.reset();
	}

	@Test
	void land_SuccessfulLand_PrintPlaneLandMessage() {
		myPlane.land();
		
		String expected = "Rolling to a stop" + System.lineSeparator();
		String actual = message.toString();
		assertEquals(expected, actual);
		
		// Prevent accidentally checking messages from this test in other tests
		message.reset();
	}
	
	@Test
	void ToString_MethodOverridden_PrintPlaneToStringMessage() {
		String expected = "A320 with 2 engines";
		String actual = myPlane.toString();
		assertEquals(expected, actual);
	}
}