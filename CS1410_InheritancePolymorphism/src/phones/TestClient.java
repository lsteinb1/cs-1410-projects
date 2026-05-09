package phones;

import java.util.Random;

/**
 * For testing different types of Phones.
 * 
 * @author Lydia
 * 
 */
public class TestClient {

	public static void main(String[] args) {
		RotaryPhone model500 = new RotaryPhone("Model 500", new Dimension(143, 208, 119), Voltage.V110);
		PushButtonPhone cortelco = new PushButtonPhone("Cortelco 2500", new Dimension(178, 228, 127), Voltage.DUAL);
		SmartPhone pixel3 = new SmartPhone("Pixel3", new Dimension(145.6, 68.2, 7.9), 128);
		SmartPhone iphone8 = new SmartPhone("iPhone8", new Dimension(138.4, 67.3, 7.3), 64);
		
		Phone[] phones = {model500, cortelco, pixel3, iphone8};
		System.out.println("Various Phones:");
		
		for (Phone phone : phones) {
			System.out.println(phone);
		}
		System.out.println();
		
		model500.plugIn();
		cortelco.plugIn();
		
		Random rand = new Random();
		int randValue = rand.nextInt(2);
		
		if (randValue == 0) {
			model500.unplug();
		}
		else {
			cortelco.unplug();
		}
		
		System.out.println("Array Elements:");
		
		for (Phone phone : phones) {
			System.out.println(phone.toString());
			System.out.println(phone.call(8019574111L));
			// reason for the L: https://stackoverflow.com/questions/28325023/range-of-primitive-type-long-in-java
			if (phone instanceof SmartPhone) {
				System.out.println(((SmartPhone)phone).browse());
				System.out.println(((SmartPhone)phone).takePicture());
			}
			System.out.println();
		}
	}
}