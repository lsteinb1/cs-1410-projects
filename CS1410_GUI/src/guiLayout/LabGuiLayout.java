package guiLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;

/**
 * 
 * 
 * @author Lydia
 */
public class LabGuiLayout extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel controlPanel_1;
	private JLabel lblTile1;
	private JLabel lblTile2;
	private JLabel lblTile3;
	private JLabel lblTile4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LabGuiLayout frame = new LabGuiLayout();
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
	public LabGuiLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(600, 300));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitle = newLblTitle();
		contentPane.add(lblTitle, BorderLayout.NORTH);
		
		JPanel controlPanel = newControlPanel();
		contentPane.add(controlPanel, BorderLayout.WEST);
		controlPanel_1.setLayout(new GridLayout(2, 1, 10, 10));
		
		JButton btnBack = newBackBtn();
		controlPanel.add(btnBack);
		
		JButton btnForward = newForwardBtn();
		controlPanel.add(btnForward);
		{
			JPanel mainPanel = newMainPanel();
			contentPane.add(mainPanel, BorderLayout.CENTER);
			{
				lblTile1 = newLblTile1(); // lblTile1 initialized as a field
				mainPanel.add(lblTile1);

				lblTile2 = newLblTile2();
				mainPanel.add(lblTile2);

				lblTile3 = newLblTile3();
				mainPanel.add(lblTile3);

				lblTile4 = newLblTile4();
				mainPanel.add(lblTile4);
			}
		}
		

	}

	private JLabel newLblTile4() {
		JLabel lblTile4 = new JLabel("4");
		lblTile4.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblTile4.setOpaque(true);
		lblTile4.setBackground(new Color(255, 215, 0));
		lblTile4.setHorizontalAlignment(SwingConstants.CENTER);
		return lblTile4;
	}

	private JLabel newLblTile3() {
		JLabel lblTile3 = new JLabel("3");
		lblTile3.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblTile3.setOpaque(true);
		lblTile3.setBackground(new Color(255, 215, 0));
		lblTile3.setHorizontalAlignment(SwingConstants.CENTER);
		return lblTile3;
	}

	private JLabel newLblTile2() {
		JLabel lblTile2 = new JLabel("2");
		lblTile2.setBorder(new EmptyBorder(0, 20, 0, 20));
		lblTile2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblTile2.setOpaque(true);
		lblTile2.setBackground(new Color(65, 105, 225));
		lblTile2.setHorizontalAlignment(SwingConstants.CENTER);
		return lblTile2;
	}

	private JLabel newLblTile1() {
		JLabel lblTile1 = new JLabel("1");
		lblTile1.setBorder(new EmptyBorder(0, 70, 0, 70));
		lblTile1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblTile1.setOpaque(true);
		lblTile1.setBackground(new Color(255, 215, 0));
		lblTile1.setHorizontalAlignment(SwingConstants.CENTER);
		return lblTile1;
	}
	
	/*
	// I'm not sure why this wasn't working
	private void newLblTile(JLabel lblTile, Color bgColor) {
		lblTile.setOpaque(true);
		lblTile.setBackground(bgColor);
		lblTile.setHorizontalAlignment(SwingConstants.CENTER);
	}
	*/

	private JPanel newMainPanel() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(1, 4, 20, 10));
		return mainPanel;
	}
	
	/**
	 * Finds the index of the tile with a blue background, based on the keys in possibleTiles.
	 * @param possibleTiles
	 * @return
	 */
	private int blueLocation(Map<Integer, JLabel> possibleTiles) {
		for (int i = 1; i <= possibleTiles.size(); i++) {
			if (possibleTiles.get(i).getBackground().equals(new Color(65, 105, 225))) {
				return i;
			}
		}
		
		return 0; // if no blue tile found; this shouldn't happen
	}
	
	/**
	 * Updates the blue background to a position one step forward/back of the current position, based on whether the user pressed the forward or back button.
	 * @param isForward
	 */
	private void blueUpdate(boolean isForward) {
		Color regularTileColor = new Color(255, 215, 0); // gold
		Color specialColor = new Color(65, 105, 225); // royal blue
		
		Map<Integer, JLabel> possibleTiles = new HashMap<>();
		possibleTiles.put(1, lblTile1);
		possibleTiles.put(2, lblTile2);
		possibleTiles.put(3, lblTile3);
		possibleTiles.put(4, lblTile4);
		
		int blueIndex = blueLocation(possibleTiles);
		
		if (blueIndex != 0) {
			possibleTiles.get(blueIndex).setBackground(regularTileColor); // set original blue tile to the regular tile color

			if (isForward) {
				blueIndex++; // iterate the blueIndex to be the new one (one step forward)
				if (possibleTiles.containsKey(blueIndex)) {
					possibleTiles.get(blueIndex).setBackground(specialColor);
				}
				else {
					possibleTiles.get(1).setBackground(specialColor); // wrap around to tile 1
					blueIndex = 1;
				}
			}
			else { // is backward otherwise
				blueIndex--; // iterate the blueIndex to be the new one (one step back)
				if (possibleTiles.containsKey(blueIndex)) {
					possibleTiles.get(blueIndex).setBackground(specialColor);
				}
				else {
					possibleTiles.get(4).setBackground(specialColor); // wrap around to tile 4
					blueIndex = 4;
				}
			}
		}
	}

	private JButton newForwardBtn() {
		JButton btnForward = new JButton("-->");
		btnForward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				blueUpdate(true);
			}
		});
		return btnForward;
	}

	private JButton newBackBtn() {
		JButton btnBack = new JButton("<--");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				blueUpdate(false);
			}
		});
		btnBack.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnBack.setPreferredSize(new Dimension(30, 15));
		btnBack.setMinimumSize(new Dimension(30, 15));
		btnBack.setMaximumSize(new Dimension(30, 15));
		btnBack.setBounds(new Rectangle(0, 0, 30, 30));
		return btnBack;
	}

	private JPanel newControlPanel() {
		controlPanel_1 = new JPanel();
		controlPanel_1.setBorder(new EmptyBorder(0, 20, 100, 20));
		controlPanel_1.setBounds(new Rectangle(60, 60, 30, 30));
		return controlPanel_1;
	}

	private JLabel newLblTitle() {
		JLabel lblTitle = new JLabel("Demo Layout");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 26));
		return lblTitle;
	}

}
