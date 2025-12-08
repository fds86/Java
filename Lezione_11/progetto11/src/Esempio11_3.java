package progetto11;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Esempio11_3 extends JFrame {
	private JButton bottone;
	private JLabel etichetta;

	public Esempio11_3(String titolo) {
		super(titolo);
		bottone = new JButton("Premi qui");
		etichetta = new JLabel("Sto aspettando...");
		bottone.addActionListener(new Ascoltatore(etichetta));
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(bottone);
		getContentPane().add(etichetta);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String args[]) {
		new Esempio11_3("Prova");
	}
}

class Ascoltatore implements ActionListener {
	JLabel etic;
	static int nVolte = 0;

	Ascoltatore(JLabel l) {
		etic = l;
	}

	public void actionPerformed(ActionEvent e) {
		nVolte++;
		etic.setText("Bottone premuto " + nVolte + " volte");
	}
}
