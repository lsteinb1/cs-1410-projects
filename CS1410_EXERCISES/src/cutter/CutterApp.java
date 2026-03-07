package cutter;

public class CutterApp {
	
	public static void main(String[] args) {
		Pliers sideCutter = new Pliers(6, PliersType.SIDE_CUTTER);
		Pliers endNipper = new Pliers(1, PliersType.END_NIPPER);
		Pliers flushCutter = new Pliers(5, PliersType.FLUSH_CUTTER);
	
		PruningShears pruningShears = new PruningShears(9); // wrote as 11 in at first from misreading
		ElectricPruningShears electricShears1 = new ElectricPruningShears(11);
		ElectricPruningShears electricShears2 = new ElectricPruningShears(12);
	
		electricShears1.onOff();
		electricShears2.onOff();
		electricShears2.onOff(); // turns it back off, to test the toggle
		
		Cutter[] allCutters = {sideCutter, endNipper, flushCutter, pruningShears,
				electricShears1, electricShears2};
		for (Cutter cutter : allCutters) {
			System.out.printf("%s: %n", cutter);
			System.out.printf("Size: %d%n", cutter.getSize());
			if (cutter instanceof ElectricPruningShears) {
				System.out.printf("Power: %s%n", (((ElectricPruningShears)cutter).isOn() ? "on" : "off"));
			}
			System.out.printf("%s%n", cutter.cut());
			System.out.println();
		}
		
		// cutterArrayOperations(allCutters);
	}
}
