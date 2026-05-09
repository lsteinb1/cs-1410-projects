package windowBuilder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DemoWindowBuilder extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemoWindowBuilder frame = new DemoWindowBuilder();
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
	public DemoWindowBuilder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);
		
		JLabel lblHelloWorld = newLblHelloWorld();
		contentPane.add(lblHelloWorld, BorderLayout.NORTH);
		
		JButton btnButton = new JButton("Button 1");
		contentPane.add(btnButton, BorderLayout.WEST);
		
		JButton btn2Button = new JButton("Button 2");
		btn2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(btn2Button, BorderLayout.NORTH);
		
		JButton btnEast3 = new JButton("Button East 3");
		contentPane.add(btnEast3, BorderLayout.EAST);
		
		JButton btnLong4 = new JButton("A Very Long Button Name 4");
		contentPane.add(btnLong4, BorderLayout.SOUTH);
		
		JPanel mainPanel = new JPanel();
		contentPane.add(mainPanel, BorderLayout.CENTER);
		
		JButton btnContent1 = new JButton("Content 1");
		mainPanel.add(btnContent1);
		
		JButton btnContent2 = new JButton("Content 2");
		mainPanel.add(btnContent2);
		
		JButton btnBtwen = new JButton("Between 2 and 3");
		mainPanel.add(btnBtwen);
		
		JButton btnContentLong = new JButton("A Content with a long name 3");
		mainPanel.add(btnContentLong);
		
		JButton btnCont4 = new JButton("Cont 4");
		mainPanel.add(btnCont4);
		
		JButton btnCont5 = new JButton("Cont 5");
		btnCont5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mainPanel.add(btnCont5);
		
		JButton btnContent6 = new JButton("Content6");
		mainPanel.add(btnContent6);

	}

	private JLabel newLblHelloWorld() {
		JLabel lblHelloWorld = new JLabel("Hello World");
		lblHelloWorld.setEnabled(false);
		lblHelloWorld.setOpaque(true);
		lblHelloWorld.setBackground(new Color(255, 215, 0));
		lblHelloWorld.setToolTipText("hehe");
		lblHelloWorld.setForeground(new Color(0, 0, 128));
		lblHelloWorld.setHorizontalAlignment(SwingConstants.CENTER);
		lblHelloWorld.setFont(new Font("Georgia", Font.BOLD, 24));
		
		return lblHelloWorld;
	}
}
