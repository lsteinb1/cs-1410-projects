package redCounter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.FlowLayout;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;

/**
 * A GUI with a button that randomly changes color when clicked. Every time the button color turns to red,
 * a counter on a label is updated by one.
 * 
 * @author Lydia
 * 
 */
public class Counter extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel counterPanel;
	private Random rand; // to hold new Random() objects
	private int randNum; // to store different random numbers and store them to make sure they aren't successively the same
	private int counter = 0;
	private JLabel lblRedCounter = newLblRedCounter(); // needs to be changeable from other methods
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Counter frame = new Counter();
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
	public Counter() {
		setMinimumSize(new Dimension(500, 200));
		setPreferredSize(new Dimension(500, 200));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.shadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblMyGui = newLblMyGUI();
		contentPane.add(lblMyGui, BorderLayout.SOUTH);
		
		// what are these auto-generated {} sections for? I removed another one that seemed unnecessary
		{
			JPanel counterPanel = newPanel();
			contentPane.add(counterPanel, BorderLayout.CENTER);
			counterPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			counterPanel.add(lblRedCounter); // label initialized as a field
			
			JButton btnClickMe = newBtnRandBg();
			counterPanel.add(btnClickMe);
		}
	}

	/**
	 * Initializes a panel to hold the redCounter label and the button.
	 * @return counterPanel (new panel to go in contentPane)
	 */
	private JPanel newPanel() {
		counterPanel = new JPanel();
		counterPanel.setBackground(UIManager.getColor("Button.shadow"));
		counterPanel.setBorder(new EmptyBorder(15, 0, 15, 0));
		return counterPanel;
	}

	/**
	 * Initializes a label for whose GUI this is.
	 * @return lblMyGui
	 */
	private JLabel newLblMyGUI() {
		JLabel lblMyGui = new JLabel("Lydia's GUI");
		
		lblMyGui.setBorder(new EmptyBorder(15, 0, 10, 0));
		lblMyGui.setOpaque(true);
		lblMyGui.setBackground(UIManager.getColor("CheckBox.background"));
		lblMyGui.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lblMyGui.setHorizontalAlignment(SwingConstants.CENTER);
		
		return lblMyGui;
	}

	/**
	 * Returns a random color from among the HashMap of possible colors, and updates the redCounter by one if the random color is red.
	 * @param possibleColors - a HashMap of the possible colors to randomly pick from
	 * @return the color in possibleColors associated with the randomly selected number
	 */
	private Color randomColor(Map<Integer, Color> possibleColors) {
		int prevNum = randNum; // previous random number
		rand = new Random();
		randNum = rand.nextInt(possibleColors.size()); // if possibleColors is unchanged, returns one of five numbers between 0 and 4 (inclusive).
		
		// ensures randomly chosen number can't be the same twice in a row
		if (prevNum != randNum){
			if (possibleColors.get(randNum) == Color.RED) {
				lblRedCounter.setText("Red Counter: " + ++counter + " "); // needs to be ++counter so it updates counter before displaying it
			}
			return possibleColors.get(randNum);
		}
		else {
			return randomColor(possibleColors);
		}
	}
	
	/**
	 * Initializes the button that randomly changes background color when clicked.
	 * @return btnRandBg - the button with a randomly changeable background color
	 */
	private JButton newBtnRandBg() {
		JButton btnRandBg = new JButton("Click Me");
		btnRandBg.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnRandBg.setBackground(new Color(0, 191, 255));
		btnRandBg.setForeground(new Color(255, 255, 255));
		
		Map<Integer, Color> possibleColors = new HashMap<>();
		possibleColors.put(0, Color.RED);
		possibleColors.put(1, Color.BLUE);
		possibleColors.put(2, Color.GREEN);
		possibleColors.put(3, Color.ORANGE);
		possibleColors.put(4, Color.MAGENTA);
		// possibleColors.put(5, Color.CYAN);
		// cyan used to test if more colors can be added easily and still work with rand
		
		btnRandBg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRandBg.setBackground(randomColor(possibleColors));
			}
		});
		return btnRandBg;
	}

	/**
	 * Initializes the label for counting how many times the randomly changed button is red.
	 * @return lblRedCounter
	 */
	private JLabel newLblRedCounter() {
		JLabel lblRedCounter = new JLabel("Red Counter: " + counter + " ");
		
		lblRedCounter.setHorizontalAlignment(SwingConstants.CENTER);
		lblRedCounter.setBorder(new EmptyBorder(10, 10, 5, 5));
		lblRedCounter.setOpaque(true);
		lblRedCounter.setBackground(new Color(211, 211, 211));
		lblRedCounter.setFont(new Font("Consolas", Font.PLAIN, 20));
		
		return lblRedCounter;
	}

}
