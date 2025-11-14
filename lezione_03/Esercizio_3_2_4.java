
/**
 * Programma che stampa tutti i numeri primi fino a un limite specificato.
 * Utilizza l'algoritmo di verifica: un numero primo è un numero naturale 
 * maggiore di 1 che è divisibile solo per 1 e per se stesso.
 */
public class Esercizio_3_2_4 {
	// Attributo privato: limite superiore per la ricerca dei numeri primi
	private int top;
	
	/**
	 * Costruttore: inizializza il limite superiore
	 * @param t il valore massimo fino al quale cercare numeri primi
	 */
	public Esercizio_3_2_4(int t) {
	  top = t;
  }
	
	/* Metodo che stampa tutti i numeri primi da 2 fino a top */
	public void show() {
		// Ciclo esterno: scorri tutti i numeri da 2 a top
		for(int i = 2; i <= top; i++) {
			// Assumi che il numero sia primo (true = ancora non ho trovato divisori)
			boolean divisibile = false;
			
			// Inizia a testare i divisori da 2
			int j = 2;
			
			// Ciclo interno: verifica se i è divisibile per qualche j
			// Continua finché j < i E il numero non è ancora stato marcato come divisibile
			while((j < i) && !divisibile) {
				// Se i è divisibile per j (resto = 0), allora non è primo
				if(i % j == 0) divisibile = true;
				j++;  // Passa al prossimo divisore
			}
			
			// Se divisibile rimane false, il numero è primo: stampalo
			if(!divisibile) System.out.println(i);
		}
	}

	/* Metodo principale: punto di ingresso del programma */
	public static void main(String[] args) {
		// Crea un oggetto e chiedi di stampare i numeri primi fino a 10
		Esercizio_3_2_4 x = new Esercizio_3_2_4(10);
		x.show();
	}

}