package balloon;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial") // we don't intend to serialize it
public class BalloonPanel extends JPanel {
	private Balloon balloon;
	private JLabel lblBalloon;
	private JLabel lblType;
	
	/**
	 * Creates a panel that displays an image corresponding to the
	 * size of the balloon and a label that displays whether the
	 * balloon is filled with Helium or air.
	 */
	public BalloonPanel(Balloon balloon) {
		this.balloon = balloon;
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblBalloon = newLblBalloon();
		add(lblBalloon, BorderLayout.CENTER);
		
		JLabel lblType = newLblType();
		add(lblType, BorderLayout.SOUTH);
		
	}
	
	/**
	 * @return the balloon
	 */
	public Balloon getBalloon() {
		return balloon;
	}
	
	public void updateBalloon(Balloon balloon) {
		this.balloon = balloon;
		lblBalloon.setIcon(getBalloonIcon());
		lblType.setText(balloon.getType().toString());
	}

	private JLabel newLblType() {
		lblType = new JLabel(balloon.getType().toString());
		lblType.setBorder(new EmptyBorder(10, 0, 10, 0));
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblType.setHorizontalAlignment(SwingConstants.CENTER);
		return lblType;
	}

	private JLabel newLblBalloon() {
		lblBalloon = new JLabel("");
		lblBalloon.setBackground(new Color(255, 255, 255));
		lblBalloon.setOpaque(true);
		lblBalloon.setIcon(getBalloonIcon());
		lblBalloon.setHorizontalAlignment(SwingConstants.CENTER);
		return lblBalloon;
	}

	private ImageIcon getBalloonIcon() {
		// my solution on my own
		/*
		ImageIcon balloonIcon;
		
		switch (balloon.getSize()) {
		  case XS:
			  balloonIcon = new ImageIcon(BalloonPanel.class.getResource("/balloon/Images/balloon20.jpg"));
			  return balloonIcon;
		  case S:
			  balloonIcon = new ImageIcon(BalloonPanel.class.getResource("/balloon/Images/balloon40.jpg"));
			  return balloonIcon;
		  case M:
			  balloonIcon = new ImageIcon(BalloonPanel.class.getResource("/balloon/Images/balloon60.jpg"));
			  return balloonIcon;
		  case L:
			  balloonIcon = new ImageIcon(BalloonPanel.class.getResource("/balloon/Images/balloon80.jpg"));
			  return balloonIcon;
		  case XL:
			  balloonIcon = new ImageIcon(BalloonPanel.class.getResource("/balloon/Images/balloon100.jpg"));
			  return balloonIcon;
		  default:
			  return null;
		}
		*/
		
		// her better solution
		String imagePath;
		
		switch (balloon.getSize()) {
		  case XS:
			  imagePath = "/balloon/Images/balloon20.jpg";
			  break;
		  case S:
			  imagePath = "/balloon/Images/balloon40.jpg";
			  break;
		  case M:
			  imagePath = "/balloon/Images/balloon60.jpg";
			  break;
		  case L:
			  imagePath = "/balloon/Images/balloon80.jpg";
			  break;
		  case XL:
			  imagePath = "/balloon/Images/balloon100.jpg";
			  break;
		  default:
			  imagePath = null; // confident that it will be one of those choices, and this will give us info if we haven't updated code as needed
			  break;
		}
		
		return new ImageIcon(BalloonPanel.class.getResource(imagePath));
	}

}
