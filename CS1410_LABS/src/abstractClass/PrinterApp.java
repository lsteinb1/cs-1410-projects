package abstractClass;

/**
 * 
 * @author Lydia + CS
 */
public class PrinterApp {

	public static void main(String[] args) {
		Printer[] printers = {new InkjetPrinter("Canon TS202"), new LaserPrinter("Samsung Xpress")};
		
		for (Printer printer : printers) {
			System.out.println(printer.toString());
			for (int i = 0; i < 11; i++) {
				printer.print();
			}
			
			if (printer instanceof InkjetPrinter) {
				((InkjetPrinter) printer).refillCartridge();
			}
			else if (printer instanceof LaserPrinter) {
				((LaserPrinter)printer).refillToner();
			}
			
			/* the below statement prints at the end of each printer's section of printed lines, instead of both together at the end,
			* because that made more sense with my addition of the supplyType variable and getRemainingSupply() method.
			*/
			System.out.printf("Remaining %s after refilling: %d%%%n", printer.getSupplyType(), printer.getRemainingSupply());
			// [re]learned that to print a % literal in an fstring, use %%
			System.out.println();
		}
	}

}
