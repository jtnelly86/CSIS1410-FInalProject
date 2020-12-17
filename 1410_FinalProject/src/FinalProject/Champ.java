package FinalProject;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;

public class Champ extends MainGame {
	public Champ() {
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void oppThrows() {
		
		JLabel lblOppChoseIcon = new JLabel("");
		GridBagConstraints gbc_lblOppChoseIcon = new GridBagConstraints();
		gbc_lblOppChoseIcon.insets = new Insets(0, 0, 5, 5);
		gbc_lblOppChoseIcon.gridx = 8;
		gbc_lblOppChoseIcon.gridy = 2;
		contentPane.add(lblOppChoseIcon, gbc_lblOppChoseIcon);
		
		oppChose = 0;
		oppChoseIcon = "Stuff\\Rock(icon).png";
	}

	}


