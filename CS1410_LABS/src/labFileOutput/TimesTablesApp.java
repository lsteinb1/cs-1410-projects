package labFileOutput;

import java.io.PrintWriter;

public class TimesTablesApp {

	public static void main(String[] args) {
		String writeFile = "src\\labFileOutput\\TimesTables.txt";
		try(PrintWriter writer = new PrintWriter(writeFile)){
			for(int i = 1; i <= 10; i++) {
				if(i % 2 == 0) {
					multiplesToTen(writer, i, "		");
				}
				else {
					multiplesToTen(writer, i, "");
				}
			}
		}
		catch(Exception e) {
			System.err.print("Error: " + e);
		}
	}
	
	public static void multiplesToTen(PrintWriter writer, int multiplicand, String indent) {
		for(int multiplier = 1; multiplier <= 10; multiplier++) {
			writer.write(indent);
			System.out.print(indent);
			writer.write(multiplicand + " * " + multiplier + " = " + multiplicand * multiplier + "\n");
			System.out.print((multiplicand + " * " + multiplier + " = " + multiplicand * multiplier + "\n"));
		}
	}

}
