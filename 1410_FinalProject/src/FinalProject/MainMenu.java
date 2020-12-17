package FinalProject;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MainMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
    
	String fileName = "C:\\Users\\User\\eclipse-workspace\\1410_FinalProject\\Stuff\\record";
	File record = new File(fileName);
	
	int oppChose;
	int playerChose;
	String result;
	int playWins;
	int playLosses;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		getRecord();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("Play");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							MainGame frame = new MainGame();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 65));
		contentPane.add(btnNewButton, BorderLayout.CENTER);
		
		JButton btnDwayneJohnson = new JButton("Challenge Dwayne Johnson!");
		btnDwayneJohnson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Champ frame = new Champ();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnDwayneJohnson.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		contentPane.add(btnDwayneJohnson, BorderLayout.SOUTH);
		
		JTextArea txtrCurrentRecord = new JTextArea();
		txtrCurrentRecord.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtrCurrentRecord.setText("Record: " + playWins + " - " + playLosses);
		contentPane.add(txtrCurrentRecord, BorderLayout.WEST);
		
		JLabel lblRockPaperScissors = new JLabel("Rock, Paper, Scissors");
		lblRockPaperScissors.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblRockPaperScissors.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblRockPaperScissors, BorderLayout.NORTH);
		
		JButton btnClearRecord = new JButton("Clear Record");
		btnClearRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playWins = 0;
				playLosses = 0;
				try {
					updateRecord();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				txtrCurrentRecord.setText("Record: " + playWins + " - " + playLosses);
				}
		});
		contentPane.add(btnClearRecord, BorderLayout.EAST);
	}

	public void getRecord() {
		BufferedReader br = null;
	    String line = "";
	    String cvsSplitBy = ",";
	    try {
			br = new BufferedReader(new FileReader(record));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			while ((line = br.readLine()) != null) 
			{
			String[] wLRecord = line.split(cvsSplitBy);
			playWins = Integer.parseInt(wLRecord[0]);
			playLosses = Integer.parseInt(wLRecord[1]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	public void updateRecord() throws IOException {
		FileWriter csvWriter = null;
		try {
			csvWriter = new FileWriter(fileName, false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			csvWriter.write(playWins + "," + playLosses);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		csvWriter.close();
	}
}
