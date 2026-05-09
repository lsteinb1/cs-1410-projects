package final_test;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Writes a file with a pattern made of 'x's, reads that file,
 * and writes text files with patterns that add a vertical or horizontal mirrored version to the original pattern.
 * 
 * @author Lydia
 */

public class PatternApp {

	private static List<String> horizontalMirror;
	private static List<String> verticalMirror;

	public static void main(String[] args) {
		List<String> lines = new ArrayList<>();
		try(Scanner reader = new Scanner(PatternApp.class.getResourceAsStream("Pattern.txt"))){
			while(reader.hasNextLine()) {
				lines.add(reader.nextLine());
				//lines.add("\n");
			}
		}
		catch(Exception e) {
			System.out.println("Exception: " + e);
		}
		
		//System.out.println(lines);
		horizontalMirror = lines.reversed();
		verticalMirror = new ArrayList<>();
		
		/*
		 * solution I tried that wasn't working
		for(String line : lines) {
			for (int i = (line.length() - 1); i >= 0; i--) {
				verticalMirror.add(Character.toString(line.charAt(i)));
			}
		}*/
		
		for (String line : lines) {
			StringBuilder sb = new StringBuilder(line);
			sb.reverse();
			verticalMirror.add(sb.toString());
		}
		
		// if needed, solution to appending successfully: https://stackoverflow.com/questions/9961292/write-to-text-file-without-overwriting-in-java
		writeToFileName(lines, "verticalMirror", "src\\final_test\\Pattern1.txt");
		writeToFileName(lines, "horizontalMirror", "src\\final_test\\Pattern2.txt");
	}

	private static void writeToFileName(List<String> lines, String writeTo,
			String writeFileName) {
		try(PrintWriter writer = new PrintWriter(writeFileName)){
			if(writeTo == "verticalMirror") {
				writeVerticalMirror(lines, writer);
			}
			else if (writeTo == "horizontalMirror") {
				writeHorizontalMirror(lines, writer);
			}
		}
		catch(Exception e) {
			System.out.println("Exception: " + e);
		}
	}

	private static void writeHorizontalMirror(List<String> lines, PrintWriter writer) {
		for(int i = 0; i < lines.size(); i++) {
			writer.write(lines.get(i) + "\n");
		}
		for(int i = 0; i < horizontalMirror.size(); i++) {
			if(i + 1 != horizontalMirror.size()){ // if not at last run of loop
				writer.write(horizontalMirror.get(i) + "\n");
			}
			else { // if at last run of loop
				writer.write(horizontalMirror.get(i));
			}
		}
	}

	private static void writeVerticalMirror(List<String> lines, PrintWriter writer) {
		for(int i = 0; i < verticalMirror.size(); i++) {
			if(i + 1 != verticalMirror.size()){ // if not at last run of loop
				writer.write(lines.get(i) + verticalMirror.get(i) + "\n");
			}
			else { // if at last run of loop
				writer.write(lines.get(i) + verticalMirror.get(i));
			}
		}
	}

}
