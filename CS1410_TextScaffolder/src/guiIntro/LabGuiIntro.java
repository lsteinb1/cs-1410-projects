package guiIntro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Dimension;

public class LabGuiIntro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameTextField;
	/**
	 * @wbp.nonvisual location=111,8
	 */

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LabGuiIntro frame = new LabGuiIntro();
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
	public LabGuiIntro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout()); // this was important, but not included in the instructions or setup.
		// I figured out the last step here:
		// https://stackoverflow.com/questions/72237283/how-can-i-create-a-frame-with-a-borderlayout-and-assign-each-space-a-component
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		
		JButton btnWest = newWestBtn();
		contentPane.add(btnWest, BorderLayout.WEST);
		
		final JLabel lblTitle = newLblTitle();
		
		contentPane.add(lblTitle, BorderLayout.NORTH);
		
		JLabel lblHi = newLblHi();
		contentPane.add(lblHi, BorderLayout.CENTER);
		
		{
			newTextPanel();
		}

		btnWest.setBorder(new EmptyBorder(100, 20, 100, 20));
		lblTitle.setBorder(new EmptyBorder(0, 60, 0, 60));
		lblHi.setBorder(new EmptyBorder(60, 60, 60, 60));
	}

	private void newTextPanel() {
		JPanel textPanel = new JPanel();
		textPanel.setBackground(new Color(128, 128, 128));
		contentPane.add(textPanel, BorderLayout.SOUTH);
		{
			JLabel lblName = new JLabel("Name:");
			lblName.setVerticalAlignment(SwingConstants.BOTTOM);
			lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
			textPanel.add(lblName);
		}
		{
			nameTextField = new JTextField();
			nameTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
			textPanel.add(nameTextField);
			nameTextField.setColumns(16);
		}
	}

	private JLabel newLblHi() {
		JLabel lblHi = new JLabel("Hi");
		lblHi.setOpaque(true);
		lblHi.setBackground(new Color(255, 0, 0));
		lblHi.setForeground(new Color(255, 165, 0));
		lblHi.setFont(new Font("Papyrus", Font.PLAIN, 77));
		return lblHi;
	}

	private JButton newWestBtn() {
		JButton btnWest = new JButton("West");
		btnWest.setHorizontalAlignment(SwingConstants.LEFT);
		return btnWest;
	}

	private JLabel newLblTitle() {
		JLabel lblTitle = new JLabel("My First GUI");
		lblTitle.setMinimumSize(new Dimension(60, 14));
		lblTitle.setVerticalAlignment(SwingConstants.TOP);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblTitle.setForeground(new Color(0, 255, 0));
		lblTitle.setOpaque(true);
		lblTitle.setBackground(new Color(0, 0, 255));
		
		return lblTitle;
	}

}
