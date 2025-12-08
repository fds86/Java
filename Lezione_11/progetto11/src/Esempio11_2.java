package progetto11;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Esempio11_2 extends JFrame {
	private JButton bottone;
	private JLabel etichetta;

	public Esempio11_2(String titolo) {
		super(titolo);
		bottone = new JButton("Premi qui");
		etichetta = new JLabel("Sto aspettando...");
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(bottone);
		getContentPane().add(etichetta);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String args[]) {
		new Esempio11_2("Prova");
	}
}
