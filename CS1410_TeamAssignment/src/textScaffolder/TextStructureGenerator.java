package textScaffolder;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;

/**
 * Allows the user to create a TextStructure and save it to a text file.
 * 
 * @author Lydia
 * 
 */
public class TextStructureGenerator extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField structureFillableTextField;
	private JTextField structureNameTextField;
	private JTextField structureDescTextField;
	private JTextField structureFillableSlotMarkField;
	private JTextField structureIteratorMarkField;
	private JTextField structureNumberOfTextLinesField;
	private TextStructure textStructure;
	private JButton btnRunTextScaffolder;
	private JTextField structureStartFromField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextStructureGenerator frame = new TextStructureGenerator();
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
	public TextStructureGenerator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel structurePanel = newStructurePanel();
		contentPane.add(structurePanel);
		{
			btnRunTextScaffolder = new JButton("Run TextScaffolder");
			btnRunTextScaffolder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TextScaffolder.main(null);
				}
			});
			btnRunTextScaffolder.setBounds(new Rectangle(0, 0, 50, 50));
			btnRunTextScaffolder.setBorder(new EmptyBorder(0, 50, 0, 50));
			contentPane.add(btnRunTextScaffolder, BorderLayout.SOUTH);
		}
		
		//TextScaffolder.main(null);
	}
	
	/**
	 * The main panel that holds each of the fields the user uses to input the information about their TextStructure.
	 * 
	 * @return structurePanel
	 */
	private JPanel newStructurePanel() {
		JPanel structurePanel = new JPanel();
		structurePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		structurePanel.setLayout(new GridLayout(0, 2, 10, 10));
		{
			structureNameTextField = new JTextField();
			structureNameTextField.setText("[text structure name]"); // example: "Word Set"
			structureNameTextField.setToolTipText("Name of the TextStructure. Example: Word Set");
			structurePanel.add(structureNameTextField);
			structureNameTextField.setColumns(10);
		}
		{
			structureDescTextField = new JTextField();
			structureDescTextField.setText("[text structure description]"); // example: "For adding Word Sets to JapaneseQuizGenerator."
			structureDescTextField.setToolTipText("Description of the TextStructure. Example: For adding Word Sets to JapaneseQuizGenerator.");
			structurePanel.add(structureDescTextField);
			structureDescTextField.setColumns(10);
		}
		{
			structureFillableSlotMarkField = new JTextField();
			structureFillableSlotMarkField.setText("*"); // example: "*"
			structureFillableSlotMarkField.setToolTipText("Mark used to denote fillable slots in FillableText. Typically *.");
			structurePanel.add(structureFillableSlotMarkField);
			structureFillableSlotMarkField.setColumns(10);
		}
		{
			structureIteratorMarkField = new JTextField();
			structureIteratorMarkField.setText("^"); // example: "^"
			structureIteratorMarkField.setToolTipText("Optional iterator mark to be iterated with each text line generated for this TextStructure. Typically ^.");
			structurePanel.add(structureIteratorMarkField);
			structureIteratorMarkField.setColumns(10);
		}
		{
			structureFillableTextField = new JTextField();
			structureFillableTextField.setText("[fillable text]"); // example: "q11.wl[^] = Word(\"*\", \"*\", \"*\", \"*\", [], [])"
			structureFillableTextField.setToolTipText("FillableText, including fillableSlotMarks indicating where a fillable slot would go. Example: q11.wl[^] = Word(\"*\", \"*\", \"*\", \"*\", [], [])");
			structurePanel.add(structureFillableTextField);
			structureFillableTextField.setColumns(10);
		}
		{
			structureNumberOfTextLinesField = new JTextField();
			structureNumberOfTextLinesField.setText("5"); // example: "5"
			structureNumberOfTextLinesField.setToolTipText("The number of text lines to generate for this text structure. Commonly around 5.");
			structurePanel.add(structureNumberOfTextLinesField);
			structureNumberOfTextLinesField.setColumns(10);
		}
		
		{
			JButton btnSubmitStructureText = new JButton("Submit & Parse TextStructure");
			btnSubmitStructureText.setToolTipText("Submit all the entered information for this TextStructure to a text file.");
			btnSubmitStructureText.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					textStructure = new TextStructure(structureNameTextField.getText(), structureDescTextField.getText(), structureFillableTextField.getText(),
							structureFillableSlotMarkField.getText(), structureIteratorMarkField.getText(), Integer.parseInt(structureNumberOfTextLinesField.getText()), Integer.parseInt(structureStartFromField.getText()));
					TextScaffolder.writeToFile(textStructure.toString(), "src\\TextScaffolder\\TextStructure.txt", false);
				}
			});
			{
				structureStartFromField = new JTextField();
				structureStartFromField.setToolTipText("The number to start counting an iterator from; defaults to 0.");
				structureStartFromField.setText("0");
				structurePanel.add(structureStartFromField);
				structureStartFromField.setColumns(10);
			}
			structurePanel.add(btnSubmitStructureText);
		}
			
		return structurePanel;
	}
}
