
/**
 * Esercizio 4.2.1 - Confronto tra tipi primitivi e wrapper Integer
 *
 * Questo esempio mostra la differenza tra il confronto di valori primitivi
 * (es. `int`) e il confronto di riferimenti tra oggetti wrapper (`Integer`).
 * Inoltre dimostra l'uso di `Integer.valueOf(int)` che sfrutta il caching
 * dei wrapper per valori piccoli (tipicamente -128..127).
 */
public class Esercizio_4_2_1 {

	/**
	 * Punto d'ingresso dell'esercizio.
	 * - `x` e `y` sono primitivi: il confronto con `==` confronta i valori.
	 * - `z`, `w`, `v` sono riferimenti a oggetti `Integer`.
	 *   * `Integer.valueOf(int)` dovrebbe essere usato al posto del costruttore
	 *     `new Integer(int)` (deprecato) perché può restituire oggetti cacheati
	 *     e migliorare le prestazioni.
	 */
	public static void main(String[] args) {
		// confronto tra primitivi (confronto di valore)
		int x = 2;
		int y = 3;
		System.out.println("x == y ? " + (x == y)); // false: 2 != 3

		// confronto tra wrapper Integer (confronto di riferimento con '==')
		// Integer.valueOf usa un cache per valori piccoli (-128..127),
		// quindi per valori in quel range z e w possono riferire lo stesso oggetto.
		Integer z = Integer.valueOf(3);
		Integer w = Integer.valueOf(3);
		System.out.println("z == w ? " + (z == w)); // true in genere per piccoli valori

		// v punta allo stesso oggetto di z (aliasing)
		Integer v = z;
		System.out.println("z == v ? " + (z == v)); // true: stesso riferimento

		// Per confrontare i valori numerici dei wrapper usare equals() o
		// unboxing automatico (es. z.intValue() == w.intValue()).
		System.out.println("z.equals(w) ? " + z.equals(w)); // true: confronto valori
	}
}
