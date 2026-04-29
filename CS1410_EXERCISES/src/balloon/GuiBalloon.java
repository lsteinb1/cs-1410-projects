package balloon;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

/*
 * From Balloon Tutorial: https://www.youtube.com/watch?v=WB-j-ssHelQ&t=2s
 * 
 * @author Lydia + MargretPosch
 */
@SuppressWarnings("serial") // we don't intend to serialize it
public class GuiBalloon extends JFrame {

	private JPanel contentPane;
	private BalloonPanel leftBalloonPanel;
	private BalloonPanel rightBalloonPanel;
	private final Random rand = new Random(); // added based on instruction. 'final' is important here;
	// doesn't use up a lot of memory by making a new one each time, and improves the randomness, I assume bc of nextInt()

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiBalloon frame = new GuiBalloon();
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
	public GuiBalloon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitle = newLblTitle();
		contentPane.add(lblTitle, BorderLayout.NORTH); // this kept for readability/clarity
		
		JPanel displayPanel = newDisplayPanel(); // need to initialize displayPanel before controlPanel! this was the reason behind the NullPointerException earlier
		contentPane.add(displayPanel, BorderLayout.CENTER);
		
		JPanel controlPanel = newControlPanel();
		contentPane.add(controlPanel, BorderLayout.SOUTH);
	}

	private JPanel newDisplayPanel() {
		JPanel displayPanel = new JPanel();
		displayPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		displayPanel.setLayout(new GridLayout(1, 0, 10, 0));
		
		leftBalloonPanel = new BalloonPanel(getRandomBalloon());
		displayPanel.add(leftBalloonPanel);
		rightBalloonPanel = new BalloonPanel(getRandomBalloon());
		displayPanel.add(rightBalloonPanel);
		
		return displayPanel;
	}

	private Balloon getRandomBalloon() {
		// better to make an array here and use that directly
		BalloonSize[] allSizes = BalloonSize.values();
		int randomIndex = rand.nextInt(allSizes.length);
		BalloonSize randSize = allSizes[randomIndex];
		
		BalloonType[] allTypes = BalloonType.values();
		randomIndex = rand.nextInt(allTypes.length);
		BalloonType randType = allTypes[randomIndex];
		
		// my initial solution
		/*
		int randSizeNum = rand.nextInt(BalloonSize.values().length); // based on number of values in the enum BalloonSize; should be 5 for our purposes
		int randTypeNum = rand.nextInt(BalloonType.values().length); // based on possible values in enum BalloonType; should be 2 for our purposes
		BalloonSize randSize;
		BalloonType randType;
		
		switch(randSizeNum) {
			case 0:
				randSize = BalloonSize.XS;
				break;
			case 1:
				randSize = BalloonSize.S;
				break;
			case 2:
				randSize = BalloonSize.M;
				break;
			case 3:
				randSize = BalloonSize.L;
				break;
			case 4:
				randSize = BalloonSize.XL;
				break;
			default:
				return null;
		}
		
		switch(randTypeNum) {
			case 0:
				randType = BalloonType.HELIUM;
				break;
			case 1:
				randType = BalloonType.AIR;
				break;
			default:
				return null;
		}
		*/
		
		return new Balloon(randSize, randType);
	}

	private JPanel newControlPanel() {
		JPanel controlPanel = new JPanel();
		
		// didn't make this a field bc I can just declare it a little earlier in the same method
		JLabel lblEqual = new JLabel();
		updateLblEqual(lblEqual);
		controlPanel.add(lblEqual);
		
		JButton btnCompare = new JButton("Compare");
		btnCompare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateLblEqual(lblEqual);
			}
		});
		controlPanel.add(btnCompare);
		
		return controlPanel;
	}

	private JLabel newLblTitle() {
		JLabel lblTitle = new JLabel("Balloon Demo");
		lblTitle.setBorder(new EmptyBorder(8, 10, 8, 10));
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		return lblTitle;
	}

	private void updateLblEqual(JLabel lblEqual) {
		leftBalloonPanel.updateBalloon(getRandomBalloon());
		rightBalloonPanel.updateBalloon(getRandomBalloon());
		
		// I think some of my code here is better than the example. Just slightly more concise
		if (leftBalloonPanel.getBalloon().equals(rightBalloonPanel.getBalloon())){
			lblEqual.setText("EQUAL");
		}
		else {
			lblEqual.setText("Not Equal");
		}
	}

}
