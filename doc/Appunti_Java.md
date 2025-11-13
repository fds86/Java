# Appunti Java - Concetti Fondamentali

## 1. Classe
Una classe è un modello (template) che definisce le caratteristiche e i comportamenti di un oggetto.
- È come un "progetto" per creare oggetti
- Inizia sempre con lettera maiuscola per convenzione
- Contiene attributi (dati) e metodi (comportamenti)

Esempio:
```java
public class Territorio {
    // Attributi (caratteristiche)
    double superficie;
    int abitanti;
    
    // Metodi (comportamenti)
    double densita() {
        return abitanti / superficie;
    }
}
```

## 2. Istanza (Oggetto)
Un'istanza è un oggetto specifico creato da una classe.
- È una "realizzazione concreta" della classe
- Viene creata usando la parola chiave `new`
- Ogni istanza ha i propri valori per gli attributi

Esempio:
```java
// Creazione di un'istanza
Territorio milano = new Territorio(181.8, 1352000);
Territorio roma = new Territorio(1285, 2873000);
// Ora milano e roma sono due oggetti diversi della stessa classe
```

## 3. Metodo
Un metodo è una funzione che definisce un comportamento della classe.
- Può accettare parametri
- Può restituire un valore (o void se non restituisce nulla)
- Definisce le azioni che un oggetto può compiere

Esempio:
```java
// Metodo che calcola la densità
double densita() {
    return abitanti / superficie;  // restituisce abitanti per km quadrato
}

// Metodo che non restituisce nulla (void)
void stampaInfo() {
    System.out.println("Superficie: " + superficie);
    System.out.println("Abitanti: " + abitanti);
}
```

## 4. Costruttore
Un metodo speciale che viene chiamato quando si crea una nuova istanza.
- Ha lo stesso nome della classe
- Non ha tipo di ritorno (neanche void)
- Inizializza gli attributi dell'oggetto

Esempio:
```java
public class Territorio {
    double superficie;
    int abitanti;
    
    // Costruttore
    Territorio(double s, int a) {
        superficie = s;
        abitanti = a;
    }
}
```

## 5. Commenti in Java
Esistono tre tipi di commenti:
1. Commento su una linea:
```java
// Questo è un commento su una linea
```

2. Commento su più linee:
```java
/* Questo è un commento
   che può occupare
   più linee */
```

3. Commento Javadoc (per la documentazione):
```java
/**
 * Questo è un commento Javadoc
 * @param parametro descrizione del parametro
 * @return descrizione del valore restituito
 */
```

## 6. Compilazione ed Esecuzione
Per compilare ed eseguire un programma Java:
1. Salvare il file con estensione `.java`
2. Compilare con il comando:
```powershell
javac NomeFile.java
```
3. Eseguire con il comando:
```powershell
java NomeFile
```

## 7. Modificatori di Accesso
Controllano la visibilità e l'accessibilità di attributi e metodi:

### `private`
- L'attributo/metodo è accessibile solo dentro la classe
- Protegge i dati da accessi non autorizzati dall'esterno
- Buona pratica: dichiarare gli attributi come `private` e fornire metodi pubblici per accedervi

```java
public class Territorio {
    private int dim;        // accessibile solo dentro questa classe
    
    public void show() {    // accessibile da fuori
        System.out.println(dim);
    }
}
```

### `public`
- L'attributo/metodo è accessibile da qualunque classe
- Usare con cautela per non esporre dati sensibili

## 8. Cicli in Java
Permettono di ripetere blocchi di codice più volte.

### Ciclo `for`
Usato quando conosci il numero di iterazioni.
```java
for(int i = 1; i <= 10; i++) {
    System.out.println("Iterazione: " + i);
}
```

Struttura: `for(inizializzazione; condizione; incremento)`

**Ciclo for annidato** (uno dentro l'altro):
```java
for(int i = 1; i <= 3; i++) {
    for(int j = 1; j <= 3; j++) {
        System.out.print(i * j + "\t");
    }
    System.out.println();
}
// Stampa una tabella 3x3
```

### Ciclo `while`
Usato quando non conosci il numero di iterazioni, continua finché la condizione è vera.
```java
int i = 1;
while(i <= 10) {
    System.out.println("Iterazione: " + i);
    i++;  // importante: incrementare per evitare loop infinito
}
```

### Ciclo `do-while`
Come `while`, ma esegue il codice almeno una volta, poi controlla la condizione.
```java
int i = 1;
do {
    System.out.println("Iterazione: " + i);
    i++;
} while(i <= 10);
```

La differenza da `while`:
```java
// while: controlla prima
while(false) {
    System.out.println("Non viene mai eseguito");
}

// do-while: esegue prima, poi controlla
do {
    System.out.println("Viene eseguito almeno una volta");
} while(false);
```

## 9. Operatori comuni
- **Incremento**: `i++` (aumenta di 1)
- **Decremento**: `i--` (diminuisce di 1)
- **Assegnazione**: `i = 5`
- **Moltiplicazione**: `i * j`
- **Confronto**: `i <= 10`, `i > 5`, `i == 3`

## Note Importanti
- Java è case-sensitive (maiuscole e minuscole sono diverse)
- Ogni file `.java` pubblico deve avere lo stesso nome della classe che contiene
- Il metodo `main` è il punto di ingresso del programma:
```java
public static void main(String[] args) {
    // Il programma inizia qui
}
```
- **Buona pratica**: usare `private` per gli attributi e `public` per i metodi che vuoi esporre
- **Evitare loop infiniti**: assicurati che la condizione del ciclo diventi falsa
- **Cicli annidati**: perfetti per lavorare con tabelle/matrici

---
*Questo documento verrà aggiornato man mano che impariamo nuovi concetti.*