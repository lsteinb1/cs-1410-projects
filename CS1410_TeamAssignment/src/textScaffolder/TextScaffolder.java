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
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;

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
		
		//textStructure = newTextStructure();
		textStructure = importTextStructure("src\\TextScaffolder\\TextStructure1.txt");
		
		initializeTextLinesAndTitle();
	}
	
	private JLabel newLblTitle() {
		JLabel lblTitle = new JLabel(textStructure.getStructureName());
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		return lblTitle;
	}
	
	private void initializeTextLinesAndTitle() {
		if(textStructure != null) {
			JPanel textLinesPanel = newTextLinesPanel();
			contentPane.add(textLinesPanel, BorderLayout.WEST);
			
			JLabel lblTitle = newLblTitle();
			contentPane.add(lblTitle, BorderLayout.NORTH);
		}
		else {
			JPanel textLinesPanel = newTextLinesPanel();
			contentPane.add(textLinesPanel, BorderLayout.WEST);
			
			JLabel lblTitle = new JLabel("Text Structure");
			contentPane.add(lblTitle, BorderLayout.NORTH);
		}
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
		
		newTextLine(0, textLineBody1);
		
		JPanel textLineBody2 = newTextLineBodyPanel(new JPanel());
		textLinesPanel.add(textLineBody2, BorderLayout.CENTER);
		linePanels.add(textLineBody2);
		newTextLine(1, textLineBody2);
		
		JPanel textLineBody3 = newTextLineBodyPanel(new JPanel());
		textLinesPanel.add(textLineBody3, BorderLayout.CENTER);
		linePanels.add(textLineBody3);
		newTextLine(2, textLineBody3);
		
		JPanel textLineBody4 = newTextLineBodyPanel(new JPanel());
		textLinesPanel.add(textLineBody4, BorderLayout.CENTER);
		linePanels.add(textLineBody4);
		newTextLine(3, textLineBody4);
		
		JPanel textLineBody5 = newTextLineBodyPanel(new JPanel());
		textLinesPanel.add(textLineBody5, BorderLayout.CENTER);
		linePanels.add(textLineBody5);
		newTextLine(4, textLineBody5);
	}

	private JPanel newTextLineBodyPanel(JPanel textLineBody) {
		textLineBody.setBorder(new EmptyBorder(20, 10, 20, 10));
		textLineBody.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		return textLineBody;
	}

	private void newTextLine(int iterator, JPanel textLineBody) {
		//int lineNum = iterator - 1; // because this is based on indexes of the List linePanels, which starts at 0, while iterators within this project start at 1
		//TextStructure wordSet = newTextStructure();
		TextLine textLine = new TextLine(textStructure, textLineBody);
		List<Component> lineComponents = textLine.createLine(iterator);
		
		{
			JButton btnSubmitText = new JButton("Submit Text");
			btnSubmitText.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//Component[] components = textLineBody.getComponents();
					for(Component c : lineComponents) {
						if (c instanceof JTextField) {
							writeToFile(((JTextField) c).getText(), "src\\TextScaffolder\\FilledTextStructure.txt"); // writes the contents of the component to the file
						}
						if (c instanceof JLabel) {
							writeToFile(((JLabel) c).getText(), "src\\TextScaffolder\\FilledTextStructure.txt");
						}
					}
					writeToFile("\n", "src\\TextScaffolder\\FilledTextStructure.txt");
				}
			});
			textLineBody.add(btnSubmitText);
		}
	}
	
	/*
	private TextStructure newTextStructure() {
		List<String> structureTemplate = new ArrayList<>();
		Collections.addAll(structureTemplate, "q11.wl[^] = Word(\"", "*", "\", \"", "*", "\", \"", "*", "\", \"", "*", "\", [], [])");
		TextStructure textStructure1 = new TextStructure("Word Set", "For adding Word Sets to JapaneseQuizGenerator", structureTemplate, "*", "^", 5);
		
		writeToFile(textStructure1.toString(), "src\\TextScaffolder\\TextStructure1.txt");
		
		return textStructure1;
	}
	*/
	
	/**
	 * Format:
	 * structureName
	 * structureDesc
	 * fillableSlotMark
	 * iteratorMark
	 * fillableText
	 * @return
	 */
	// TODO figure out why this isn't implementing dynamic components correctly
	private TextStructure importTextStructure(String fileSource) {
		// String fileSource = "src\\TextScaffolder\\TextStructure1.txt";
		String structureName = null;
		String structureDesc = null;
		String fillableSlotMark = null;
		String iteratorMark = null;
		String fillableText = null;
		File file = new File(fileSource);
		
		try(Scanner reader = new Scanner(file)){
			
			while (reader.hasNextLine()) {
				structureName = reader.nextLine(); // first line
				structureDesc = reader.nextLine(); // second line
				fillableSlotMark = reader.nextLine(); // third line, so on
				iteratorMark = reader.nextLine();
				fillableText = reader.nextLine();
			}
			/*
			for(int i = 0; i < 5; i++) {
				if(reader.hasNextLine()) {
					switch(i){
						case(0):
							structureName = reader.nextLine();
						case(1):
							structureDesc = reader.nextLine();
						case(2):
							fillableSlotMark = reader.nextLine();
						case(3):
							iteratorMark = reader.nextLine();
						case(4):
							fillableText = reader.nextLine();
					}
				}
				else {
					System.out.println("No next line.");
				}
			}
			*/
			if (structureName != null) {
				TextStructure textStructure1 = new TextStructure(structureName, structureDesc, fillableText, fillableSlotMark, iteratorMark, 5);
				return textStructure1;
			}
			else {
				System.err.println("Text structure could not be filled because of a null field.");;
				return null;
			}
		}
		catch(Exception e) {
			System.out.print("huh. " + e);
			System.err.println("Text structure could not be filled");;
			return null;
		}
		
		
	}

	static void writeToFile(String text, String fileName) {
		//String fileName = "src\\TextScaffolder\\FilledTextStructure.txt";
		
		// solution for appending successfully: https://stackoverflow.com/questions/9961292/write-to-text-file-without-overwriting-in-java
		// new FileWriter(fileName, true))
		try(PrintWriter writer = new PrintWriter(fileName)){
			writer.write(text);
			//System.out.print(text);
		}
		catch(Exception e) {
			System.out.print("huh. " + e);
		}
	}
}
