
/**
 * Esercizio 4.2.2 - Esempio di operatori composti e operatore ternario
 *
 * Questo breve programma mostra l'uso di:
 * - operatore di assegnamento con shift left: `<<=` (sposta i bit a sinistra)
 * - operatore di assegnamento divisione: `/=` (divide e assegna)
 * - operatore ternario `condizione ? valoreSeVero : valoreSeFalso`
 */
public class Esercizio_4_2_2 {

	public static void main(String[] args) {
		// Inizializza x con 3
		int x = 3;

		// x <<= 4 è equivalente a x = x << 4
		// operazione bitwise: sposta i bit di x di 4 posizioni a sinistra
		// 3 in binario:  0000 0011
		// 3 << 4  =>   0011 0000  (che è 48)
		x <<= 4; // ora x == 48

		// Stampa il valore attuale di x
		System.out.println(x); // stampa: 48

		// Esempio di operatore ternario: valuta la condizione e restituisce
		// la stringa corrispondente senza usare un if/else
		System.out.println(x < 10 ? "una cifra" : "due cifre"); // stampa: due cifre

		// Divisione con assegnamento: x /= 6 è equivalente a x = x / 6
		// Con x == 48, x / 6 = 8 (divisione intera)
		x /= 6; // ora x == 8

		// Stampa il nuovo valore di x
		System.out.println(x); // stampa: 8

		// Valuta di nuovo se il valore è di una cifra o due (usando ternario)
		System.out.println(x < 10 ? "una cifra" : "due cifre"); // stampa: una cifra
	}
}