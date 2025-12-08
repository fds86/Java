package progetto11;

import javax.swing.JFrame;

public class Esempio11_1 extends JFrame {

	public Esempio11_1(String titolo) {
		super(titolo);
		/*
		 * Qui il codice che costruisce l'applicazione.
		 */
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String args[]) {
		new Esempio11_1("Prova");
	}
}
