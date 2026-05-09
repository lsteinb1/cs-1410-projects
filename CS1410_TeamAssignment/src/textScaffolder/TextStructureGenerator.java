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

public class TextStructureGenerator extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField structureFillableTextField;
	private JPanel entryPanel;
	private JTextField structureNameTextField;
	private JTextField structureDescTextField;
	private JTextField structureFillableSlotMarkField;
	private JTextField structureIteratorMarkField;
	private JTextField structureNumberOfTextLinesField;
	private TextStructure textStructure;
	private JButton btnRunTextScaffolder;

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
	
	private JPanel newStructurePanel() {
		JPanel structurePanel = new JPanel();
		structurePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		structurePanel.setLayout(new GridLayout(0, 2, 10, 10));
		{
			structureNameTextField = new JTextField();
			structureNameTextField.setText("Word Set");
			structureNameTextField.setToolTipText("Name of the TextStructure.");
			structurePanel.add(structureNameTextField);
			structureNameTextField.setColumns(10);
		}
		{
			structureDescTextField = new JTextField();
			structureDescTextField.setText("For adding Word Sets to JapaneseQuizGenerator.");
			structureDescTextField.setToolTipText("Description of the TextStructure.");
			structurePanel.add(structureDescTextField);
			structureDescTextField.setColumns(10);
		}
		{
			structureFillableTextField = new JTextField();
			structureFillableTextField.setText("q11.wl[^] = Word(\"*\", \"*\", \"*\", \"*\", [], [])");
			structureFillableTextField.setToolTipText("FillableText, including fillableSlotMarks indicating where a fillable slot would go.");
			structurePanel.add(structureFillableTextField);
			structureFillableTextField.setColumns(10);
		}
		{
			structureFillableSlotMarkField = new JTextField();
			structureFillableSlotMarkField.setText("*");
			structureFillableSlotMarkField.setToolTipText("Mark used to denote fillable slots in FillableText. Typically *.");
			structurePanel.add(structureFillableSlotMarkField);
			structureFillableSlotMarkField.setColumns(10);
		}
		{
			structureIteratorMarkField = new JTextField();
			structureIteratorMarkField.setText("^");
			structureIteratorMarkField.setToolTipText("Optional iterator mark to be iterated with each text line generated for this TextStructure. Typically ^.");
			structurePanel.add(structureIteratorMarkField);
			structureIteratorMarkField.setColumns(10);
		}
		{
			structureNumberOfTextLinesField = new JTextField();
			structureNumberOfTextLinesField.setToolTipText("The number of text lines to generate for this text structure.");
			structureNumberOfTextLinesField.setText("5");
			structurePanel.add(structureNumberOfTextLinesField);
			structureNumberOfTextLinesField.setColumns(10);
		}
		
		{
			JButton btnSubmitStructureText = new JButton("Submit & Parse TextStructure");
			btnSubmitStructureText.setToolTipText("Submit all the entered information for this TextStructure and generate a usable TextStructure object from it.");
			btnSubmitStructureText.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					textStructure = new TextStructure(structureNameTextField.getText(), structureDescTextField.getText(), structureFillableTextField.getText(),
							structureFillableSlotMarkField.getText(), structureIteratorMarkField.getText(), Integer.parseInt(structureNumberOfTextLinesField.getText()));
					TextScaffolder.writeToFile(textStructure.toString(), "src\\TextScaffolder\\TextStructure2.txt", false);
				}
			});
			structurePanel.add(btnSubmitStructureText);
		}
			
		return structurePanel;
	}

}
