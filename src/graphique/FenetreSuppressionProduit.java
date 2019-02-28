package graphique;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import controleur.ctrlProduit;

public class FenetreSuppressionProduit extends JFrame implements ActionListener {

	private JButton btSupprimer;
	private JComboBox<String> combo;
	private ctrlProduit controleurProduit;
	
	public FenetreSuppressionProduit() {
		
		controleurProduit = new ctrlProduit();
		
		setTitle("Suppression produit");
		setBounds(500, 500, 200, 105);
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		btSupprimer = new JButton("Supprimer");

		combo = new JComboBox<String>(controleurProduit.getStockInTab());
		combo.setPreferredSize(new Dimension(100, 20));
		contentPane.add(new JLabel("Produit"));
		contentPane.add(combo);
		contentPane.add(btSupprimer);

		btSupprimer.addActionListener(this);

		this.setVisible(true);
		
		controleurProduit = new ctrlProduit();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btSupprimer && combo.getSelectedItem() != null) {
			System.out.println("supression " + String.valueOf(combo.getSelectedItem()));
			controleurProduit.removeProduit(String.valueOf(combo.getSelectedItem()));
		}
		this.dispose();
	}
}
