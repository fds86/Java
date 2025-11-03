/* Istanza di una classe che rappresenta un territorio con attributi di superficie e numero di abitanti. */

/* Definizione della classe Territorio (lettere maiuscole per convenzione). */
public class Territorio 
{ 
    double superficie; // Attributo per la superficie del territorio (lettere minuscole per convenzione).
    int abitanti;      // Attributo per il numero di abitanti del territorio (lettere minuscole per convenzione).

    /**
     * Costruttore della classe Territorio.
     *
     * @param superficie La superficie del territorio.
     * @param abitanti   Il numero di abitanti del territorio.
     */
    Territorio(double s, int a) 
    {
        superficie = s; // Inizializzazione dell'attributo superficie.
        abitanti = a;   // Inizializzazione dell'attributo abitanti.
    }

    /* Metodo per calcolare la densità di popolazione */
    double densita()
    { 
        return abitanti / superficie; 
    }

    /* Metodo principale per eseguire il programma. */
    public static void main(String args[]) 
    { 
        Territorio t = new Territorio(257.3, 12250); // Creazione di un'istanza della classe Territorio
        System.out.println(t.superficie); 
        System.out.println(t.abitanti); 
        System.out.println(t.densita());
    }
}
