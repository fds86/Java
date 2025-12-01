package Progetto6;

public class Bicicletta {
	int velocita = 0;
	int rapporto = 1;

	public void setVelocita(int velocita) {
		this.velocita = velocita;
	}
	
	public int getVelocita() {
		return velocita;
	}

	public void setRapporto(int rapporto) {
		this.rapporto = rapporto;
	}

	public int getRapporto() {
		return rapporto;
	}

	void cambiaRapporto(int nuovoRapporto) {
		if (nuovoRapporto >= 1 && nuovoRapporto <= 6)
			rapporto = nuovoRapporto;
	}

	void accelera(int incremento) {
		velocita += incremento;
	}

	void frena(int decremento) {
		velocita -= decremento;
	}

	void printStato() {
		System.out.println("rapporto: " + rapporto + ", velocita: " + velocita);
	}
}
