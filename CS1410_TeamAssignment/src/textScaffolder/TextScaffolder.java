package textScaffolder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;

/**
 * TextScaffolder is a program that works sort of like a written form -
 * the user can define a text structure they want to repeatedly fill in with different text,
 * like a form they want to fill out multiple times.
 * They can save a template to a file so they can use it any time they use the program,
 * and each time they fill it out, they can save the filled template to its own file.
 * 
 * This is the main class in TextScaffolder, by the same name. It allows the user to fill in an existing text structure.
 * By default, it reads from the file TextStructure.txt. The user can easily generate a TextStructure to their desired specifications
 * by running the other JFrame with a main() method, called TextStructureGenerator.
 * 
 * @author Lydia
 * 
 */

public class TextScaffolder extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private List<JPanel> linePanels;
	private TextStructure textStructure;
	private JPanel textLinesPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextScaffolder frame = new TextScaffolder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TextScaffolder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		// import a TextStructure object from a file.
		textStructure = importTextStructure("src\\TextScaffolder\\TextStructure.txt");
		
		JPanel textLinesPanel = newTextLinesPanel();
		contentPane.add(textLinesPanel, BorderLayout.WEST);
		
		if(textStructure != null) { // because newLblStructureName depends on textStructure.getStructureName()
			JLabel lblTitle = newLblStructureName();
			contentPane.add(lblTitle, BorderLayout.NORTH);
		}
		else {
			JLabel lblTitle = new JLabel("Text Structure");
			contentPane.add(lblTitle, BorderLayout.NORTH);
		}
	}
	
	private JLabel newLblStructureName() {
		JLabel lblStructureName = new JLabel(textStructure.getStructureName());
		lblStructureName.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		return lblStructureName;
	}

	private JPanel newTextLinesPanel() {
		textLinesPanel = new JPanel();
		textLinesPanel.setLayout(new GridLayout(5, 1, 0, 0));
		
		if(textStructure != null) {
			generateTextLines();
		}
		
		return textLinesPanel;
	}

	private void generateTextLines() {
		linePanels = new ArrayList<>();
		
		JPanel textLineBody1 = newTextLineBodyPanel(new JPanel());
		textLinesPanel.add(textLineBody1, BorderLayout.CENTER);
		linePanels.add(textLineBody1);
		newTextLine(textStructure.getStartFrom(), textLineBody1);
		
		if (textStructure.getNumberOfTextLines() > 1) {
			JPanel textLineBody2 = newTextLineBodyPanel(new JPanel());
			textLinesPanel.add(textLineBody2, BorderLayout.CENTER);
			linePanels.add(textLineBody2);
			newTextLine(textStructure.getStartFrom() + 1, textLineBody2);
			
			if(textStructure.getNumberOfTextLines() > 2) {
				JPanel textLineBody3 = newTextLineBodyPanel(new JPanel());
				textLinesPanel.add(textLineBody3, BorderLayout.CENTER);
				linePanels.add(textLineBody3);
				newTextLine(textStructure.getStartFrom() + 2, textLineBody3);
				
				if(textStructure.getNumberOfTextLines() > 3) {
					JPanel textLineBody4 = newTextLineBodyPanel(new JPanel());
					textLinesPanel.add(textLineBody4, BorderLayout.CENTER);
					linePanels.add(textLineBody4);
					newTextLine(textStructure.getStartFrom() + 3, textLineBody4);
					
					if(textStructure.getNumberOfTextLines() > 4) {
						JPanel textLineBody5 = newTextLineBodyPanel(new JPanel());
						textLinesPanel.add(textLineBody5, BorderLayout.CENTER);
						linePanels.add(textLineBody5);
						newTextLine(textStructure.getStartFrom() + 4, textLineBody5);
					}
				}
			}
			
		}
	}

	private JPanel newTextLineBodyPanel(JPanel textLineBody) {
		textLineBody.setBorder(new EmptyBorder(20, 10, 20, 10));
		textLineBody.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		return textLineBody;
	}

	/**
	 * Initializes generated components for a new TextLine the user can fill in (most of this is done in textLine.createLine()).
	 * When the button for submitting text is pressed, appends the associated line to the FilledTextStructure text file.
	 * @param iterator - variable to iterate for each line, if there are multiple
	 * @param textLineBody - which text line JPanel to add the TextLine's components to
	 */
	private void newTextLine(int iterator, JPanel textLineBody) {
		TextLine textLine = new TextLine(textStructure, textLineBody);
		List<Component> lineComponents = textLine.createLine(iterator);
		
		{
			JButton btnSubmitText = new JButton("Submit Text");
			btnSubmitText.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					for(Component c : lineComponents) {
						if (c instanceof JTextField) {
							writeToFile(((JTextField) c).getText(), "src\\TextScaffolder\\FilledTextStructure.txt", true); // writes the contents of the component to the file
						}
						if (c instanceof JLabel) {
							writeToFile(((JLabel) c).getText(), "src\\TextScaffolder\\FilledTextStructure.txt", true);
						}
					}
					writeToFile("\n", "src\\TextScaffolder\\FilledTextStructure.txt", true);
				}
			});
			textLineBody.add(btnSubmitText);
		}
	}
	
	/**
	 * Imports a TextStructure object from contents of the file path passed in.
	 * 
	 * Format of file contents (sensitive to number and order of lines):
	 * structureName
	 * structureDesc
	 * fillableSlotMark
	 * iteratorMark
	 * fillableText
	 * 
	 * @return TextStructure parsed from this input
	 */
	private TextStructure importTextStructure(String filePathStr) {
		// fileSource example: "src\\TextScaffolder\\TextStructure.txt"
		String structureName = null;
		String structureDesc = null;
		String fillableSlotMark = null;
		String iteratorMark = null;
		String fillableText = null;
		int numberOfTextLines = 5;
		int startFrom = 0;
		File file = new File(filePathStr);
		
		try(Scanner reader = new Scanner(file)){
			
			while (reader.hasNextLine()) {
				structureName = reader.nextLine(); // first line
				structureDesc = reader.nextLine(); // second line
				fillableSlotMark = reader.nextLine(); // third line, so on
				iteratorMark = reader.nextLine();
				fillableText = reader.nextLine();
				numberOfTextLines = reader.nextInt();
				startFrom = reader.nextInt();
			}
			if (structureName != null) {
				TextStructure textStructure1 = new TextStructure(structureName, structureDesc, fillableText, fillableSlotMark, iteratorMark, numberOfTextLines, startFrom);
				return textStructure1;
			}
			else {
				System.err.println("Text structure could not be filled because of a null field.");;
				return null;
			}
		}
		catch(Exception e) {
			System.out.print("Exception: " + e);
			System.err.println("Text structure could not be filled.");;
			return null;
		}
		
		
	}

	/**
	 * Writes text to file given with fileName. Writes to the file if append is false; appends to the file if append is true.
	 * 
	 * @param text
	 * @param fileName
	 * @param append
	 */
	static void writeToFile(String text, String fileName, Boolean append) {
		// fileName example: "src\\TextScaffolder\\FilledTextStructure.txt"
		
		if (!append) {
			try(PrintWriter writer = new PrintWriter(fileName)){
				writer.write(text);
			}
			catch(Exception e) {
				System.out.print("Exception: " + e);
			}
		}
		else if(append) { // solution for appending successfully: https://stackoverflow.com/questions/9961292/write-to-text-file-without-overwriting-in-java
			try(PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))){
				writer.append(text);
			}
			catch(Exception e) {
				System.out.print("Exception: " + e);
			}
		}
	}
}
