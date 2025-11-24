package Progetto6;

public class DemoBicicletta {

	public static void main(String[] args) {
		// crea due oggetti diversi
		Bicicletta b1 = new Bicicletta();
		Bicicletta b2 = new Bicicletta();

		// usa i metodi
		b1.cambiaRapporto(2);
		b1.accelera(10);
		b1.printStato();

		b2.cambiaRapporto(2);
		b2.accelera(10);
		b2.cambiaRapporto(3);
		b2.accelera(10);
		b2.printStato();
	}
}
