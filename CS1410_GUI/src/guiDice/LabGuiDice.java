package guiDice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.util.Random;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Rolls simulated dice.
 * 
 * @author Lydia
 * 
 */
public class LabGuiDice extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblDiceImage;
	private Random rand; // to hold new Random() objects
	private int rolledNum; // to store different numbers rolled on dice and store them for the next roll

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LabGuiDice frame = new LabGuiDice();
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
	public LabGuiDice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JButton btnRollDice = newBtnRollDice();
		contentPane.add(btnRollDice, BorderLayout.SOUTH);
		
		lblDiceImage = newLblDiceImage();
		contentPane.add(lblDiceImage, BorderLayout.CENTER);

	}

	private JLabel newLblDiceImage() {
		rand = new Random();
		int rolledNum = rand.nextInt(6); // starting number
		rolledNum++; // to make it a range from 1-6 instead of 0-5
		
		JLabel lblDiceImage = new JLabel("");
		lblDiceImage.setToolTipText("Dice image");
		lblDiceImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiceImage.setIcon(new ImageIcon(LabGuiDice.class.getResource("/Images/die-" + rolledNum + ".png")));
		return lblDiceImage;
	}
	
	private void rollDice() {
		int lastNum = rolledNum;
		Random rand = new Random();
		rolledNum = rand.nextInt(6);
		rolledNum++; // to make it a range from 1-6 instead of 0-5
		
		// ensures roll can't be the same twice in a row
		if (lastNum != rolledNum){
			lblDiceImage.setIcon(new ImageIcon(LabGuiDice.class.getResource("/Images/die-" + rolledNum + ".png")));
		}
		else{
			rollDice();
		}
	}

	private JButton newBtnRollDice() {
		JButton btnRollDice = new JButton("Roll 'Em");
		btnRollDice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rollDice();
			}
		});
		btnRollDice.setBackground(new Color(0, 128, 128));
		btnRollDice.setForeground(new Color(240, 230, 140));
		btnRollDice.setFont(new Font("Broadway", Font.PLAIN, 26));
		return btnRollDice;
	}

}
