package graphique;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import controleur.ctrlAchat;

public class FenetreAchat extends JFrame implements ActionListener {

	private JButton btAchat;
	private JTextField txtQuantite;
	private JComboBox<String> combo;
	private ctrlAchat controleurAchat;

	public FenetreAchat() {

		controleurAchat = new ctrlAchat();
		
		setTitle("Achat");
		setBounds(500, 500, 200, 125);
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		btAchat = new JButton("Achat");
		txtQuantite = new JTextField(5);
		txtQuantite.setText("0");

		combo = new JComboBox<String>(controleurAchat.getStockInTab());
		combo.setPreferredSize(new Dimension(100, 20));
		contentPane.add(new JLabel("Produit"));
		contentPane.add(combo);
		contentPane.add(new JLabel("Quantité a acheter"));
		contentPane.add(txtQuantite);
		contentPane.add(btAchat);

		btAchat.addActionListener(this);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btAchat) {
			controleurAchat.acheterStock(combo.getSelectedItem().toString(),
					Integer.valueOf(txtQuantite.getText()));
		}
		this.dispose();
	}

}
