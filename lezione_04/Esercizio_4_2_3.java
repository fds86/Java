
/**
 * Esercizio 4.2.3 - Stampa numeri e verifica pari/dispari
 *
 * Questo semplice programma itera i numeri da 1 a 10 e, per ogni numero,
 * stampa il valore seguito dalla parola "pari" o "dispari".
 *
 * Concetti mostrati:
 * - ciclo `for` per iterare un intervallo di valori
 * - operatore bitwise `&` per testare il bit meno significativo (veloce test
 *   di parità)
 * - operatore ternario `condizione ? valoreSeVero : valoreSeFalso`
 */
public class Esercizio_4_2_3 {

	/**
	 * Punto d'ingresso: stampa ogni numero da 1 a 10 e la sua parità.
	 */
	public static void main(String[] args) {
		// Ciclo for: inizializzazione; condizione; aggiornamento
		// i parte da 1 e continua finché i <= 10, incrementando i di 1 ogni
		// iterazione.
		for (int i = 1; i <= 10; i++) {
			// Stampa il numero e uno spazio senza andare a capo
			System.out.print(i + " ");

			// Test di parità usando l'operatore bitwise AND:
			// - (i & 1) restituisce 0 se il bit meno significativo è 0 (numero pari)
			// - restituisce 1 se il bit meno significativo è 1 (numero dispari)
			// Usiamo il ternario per scegliere la stringa corretta da stampare.
			System.out.println((i & 1) == 0 ? "pari" : "dispari");
		}
	}
}
