package FinalProject;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class MainGame extends MainMenu {

	String oppChoseIcon;
	
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MainGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblPlayerChoseIcon = new JLabel("");
		lblPlayerChoseIcon.setIcon(null);
		GridBagConstraints gbc_lblPlayerChoseIcon = new GridBagConstraints();
		gbc_lblPlayerChoseIcon.gridwidth = 3;
		gbc_lblPlayerChoseIcon.gridheight = 2;
		gbc_lblPlayerChoseIcon.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayerChoseIcon.gridx = 2;
		gbc_lblPlayerChoseIcon.gridy = 2;
		contentPane.add(lblPlayerChoseIcon, gbc_lblPlayerChoseIcon);
		
		JLabel lblOppChoseIcon = new JLabel("");
		GridBagConstraints gbc_lblOppChoseIcon = new GridBagConstraints();
		gbc_lblOppChoseIcon.gridwidth = 3;
		gbc_lblOppChoseIcon.gridheight = 2;
		gbc_lblOppChoseIcon.insets = new Insets(0, 0, 5, 5);
		gbc_lblOppChoseIcon.gridx = 8;
		gbc_lblOppChoseIcon.gridy = 2;
		contentPane.add(lblOppChoseIcon, gbc_lblOppChoseIcon);
		
		/**
		 * Had to refactor multiple times (moving code placement) for lblResult to display
		 * properly and update at correct times.
		 */
		
		JLabel lblResult = new JLabel("");
		lblResult.setText("");
		lblResult.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		GridBagConstraints gbc_lblResult = new GridBagConstraints();
		gbc_lblResult.gridwidth = 5;
		gbc_lblResult.gridx = 6;
		gbc_lblResult.gridy = 9;
		contentPane.add(lblResult, gbc_lblResult);
		
		/**
		 * Had to refactor each button (Rock, Paper, Scissors) placement so that game logic
		 * would work properly.
		 */
		
		JButton btnRock = new JButton("Rock");
		btnRock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerChose = 0;
				lblPlayerChoseIcon.setIcon(new ImageIcon("Stuff\\Rock(icon).png"));
				oppThrows();
				lblOppChoseIcon.setIcon(new ImageIcon(oppChoseIcon));
				try {
					compareThrows();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					updateRecord();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				lblResult.setText("Result: " + result);
				lblResult.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				
				gbc_lblResult.gridwidth = 5;
				gbc_lblResult.gridx = 6;
				gbc_lblResult.gridy = 9;
				contentPane.add(lblResult, gbc_lblResult);
			}
		});
		btnRock.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		GridBagConstraints gbc_btnRock = new GridBagConstraints();
		gbc_btnRock.gridheight = 2;
		gbc_btnRock.insets = new Insets(0, 0, 5, 5);
		gbc_btnRock.gridx = 0;
		gbc_btnRock.gridy = 0;
		contentPane.add(btnRock, gbc_btnRock);
		
		JButton btnPaper = new JButton("Paper");
		btnPaper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerChose = 1;
				lblPlayerChoseIcon.setIcon(new ImageIcon("Stuff\\Paper(icon).png"));
				oppThrows();
				lblOppChoseIcon.setIcon(new ImageIcon(oppChoseIcon));
				try {
					compareThrows();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					updateRecord();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				lblResult.setText("Result: " + result);
				lblResult.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				
				gbc_lblResult.gridwidth = 5;
				gbc_lblResult.gridx = 6;
				gbc_lblResult.gridy = 9;
				contentPane.add(lblResult, gbc_lblResult);
			}
		});
		btnPaper.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		GridBagConstraints gbc_btnPaper = new GridBagConstraints();
		gbc_btnPaper.gridheight = 2;
		gbc_btnPaper.insets = new Insets(0, 0, 5, 5);
		gbc_btnPaper.gridx = 0;
		gbc_btnPaper.gridy = 3;
		contentPane.add(btnPaper, gbc_btnPaper);
		
		JButton btnScissors = new JButton("Scissors");
		btnScissors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerChose = 2;
				lblPlayerChoseIcon.setIcon(new ImageIcon("Stuff\\Scissors(icon).png"));
				oppThrows();
				lblOppChoseIcon.setIcon(new ImageIcon(oppChoseIcon));
				try {
					compareThrows();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					updateRecord();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				lblResult.setText("Result: " + result);
				lblResult.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				
				gbc_lblResult.gridwidth = 5;
				gbc_lblResult.gridx = 6;
				gbc_lblResult.gridy = 9;
				contentPane.add(lblResult, gbc_lblResult);
			}
		});
		btnScissors.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		GridBagConstraints gbc_btnScissors = new GridBagConstraints();
		gbc_btnScissors.gridheight = 2;
		gbc_btnScissors.insets = new Insets(0, 0, 5, 5);
		gbc_btnScissors.gridx = 0;
		gbc_btnScissors.gridy = 5;
		contentPane.add(btnScissors, gbc_btnScissors);
		
		JButton btnExitToMain = new JButton("Main Menu");
		btnExitToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							MainMenu frame = new MainMenu();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					
					}
					
				});
			}
		});
		btnExitToMain.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		GridBagConstraints gbc_btnExitToMain = new GridBagConstraints();
		gbc_btnExitToMain.insets = new Insets(0, 0, 0, 5);
		gbc_btnExitToMain.gridx = 0;
		gbc_btnExitToMain.gridy = 9;
		contentPane.add(btnExitToMain, gbc_btnExitToMain);
		
	}

	public void oppThrows() {
		
		JLabel lblOppChoseIcon = new JLabel("");
		GridBagConstraints gbc_lblOppChoseIcon = new GridBagConstraints();
		gbc_lblOppChoseIcon.insets = new Insets(0, 0, 5, 5);
		gbc_lblOppChoseIcon.gridx = 8;
		gbc_lblOppChoseIcon.gridy = 2;
		contentPane.add(lblOppChoseIcon, gbc_lblOppChoseIcon);
		
		int max = 3;
		int min = 1;
		Random rand = new Random();
		oppChose = rand.nextInt((max - min)+1);
		if (oppChose == 0) {
			oppChoseIcon = "Stuff\\Rock(icon).png";
		}
		else if (oppChose == 1) {
			oppChoseIcon = "Stuff\\Paper(icon).png";
		}
		else if (oppChose == 2) {
			oppChoseIcon = "Stuff\\Scissors(icon).png";
		}
		else {
			lblOppChoseIcon.setText("Error");
		}
	}
	
	public void compareThrows() throws IOException {
		
		if (playerChose == 0) {
		
			switch(oppChose) {
			case 0: result = "Draw!";
			break;
			case 1: result = "Defeat!";
					playLosses ++;
			break;
			case 2: result = "Victory!";
					playWins ++;
			break;
			default:;
			}
		}
		
		else if (playerChose == 1) {
			switch(oppChose) {
			case 0: result = "Victory!";
					playWins ++;
			break;
			case 1: result = "Draw!";
			break;
			case 2: result = "Defeat!";
					playLosses ++;
			break;
			default:;
			}
		}
		else {
			switch(oppChose) {
			case 0: result = "Defeat!";
					playLosses ++;
			break;
			case 1: result = "Victory!";
					playWins ++;
			break;
			case 2: result = "Draw!";
			break;
			default:;
			}			
		}		
	}
}
