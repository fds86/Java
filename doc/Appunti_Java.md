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

## 9. Operatori e Tipi di Dato Fondamentali

### Tipi di dato primitivi principali

Java ha diversi tipi primitivi. I più comuni usati negli esercizi:

**Tipi numerici interi:**
- **`int`** — numeri interi da -2.147.483.648 a 2.147.483.647 (usato in tutti gli esercizi)
- **`long`** — numeri interi più grandi (per valori molto grandi)

**Tipi numerici decimali:**
- **`double`** — numeri decimali (con precisione fino a 15 cifre)
- **`float`** — numeri decimali (precisione minore, usa meno memoria)

**Tipo logico:**
- **`boolean`** — `true` o `false` (usato in Esercizio_3_2_4)

**Tipo carattere:**
- **`char`** — un singolo carattere: `'a'`, `'Z'`, `'1'`

Esempio di dichiarazione:
```java
int numero = 42;           // numero intero
double decimale = 3.14;    // numero con decimali
boolean attivo = true;     // valore logico
char lettera = 'A';        // singolo carattere
```

### Tipo di dato `boolean`
Il tipo `boolean` può avere solo due valori: `true` (vero) o `false` (falso).

Usato per:
- Memorizzare risultati di condizioni
- Controllare il flusso di un programma
- Verificare stati (acceso/spento, valido/invalido, ecc.)

```java
boolean isPrimo = true;          // dichiarare una variabile booleana
boolean isEven = (5 % 2 == 0);   // assegnare il risultato di una condizione
boolean isBig = (10 > 5);        // true

if(isPrimo) {
    System.out.println("È un numero primo");
}
```

### Operatori aritmetici
Operatori per fare calcoli matematici:

- **Addizione**: `a + b`
- **Sottrazione**: `a - b`
- **Moltiplicazione**: `a * b`
- **Divisione**: `a / b` (restituisce intero se entrambi sono interi)
- **Modulo** (`%`): **restituisce il resto della divisione**
- **Incremento**: `i++` o `++i` (aumenta di 1)
- **Decremento**: `i--` o `--i` (diminuisce di 1)

### Operatore Modulo `%`
Restituisce il **resto** della divisione tra due numeri.

```java
10 % 3 = 1    // 10 diviso 3 = 3 resto 1
7 % 2 = 1     // 7 diviso 2 = 3 resto 1
6 % 2 = 0     // 6 diviso 2 = 3 resto 0 (perfettamente divisibile)
15 % 5 = 0    // 15 diviso 5 = 3 resto 0
```

**Utilizzo pratico:**
- Verificare se un numero è pari: `numero % 2 == 0`
- Verificare se un numero è divisibile: `numero % divisore == 0`
- Trovare il resto di una divisione

Esempio dal programma dei numeri primi:
```java
if(i % j == 0) divisibile = true;  // se i è perfettamente divisibile per j
```

### Operatori booleani (logici)
- `true` e `false` — valori letterali
- `!` (NOT) — nega il valore: `!true` = `false`
- `&&` (AND) — entrambi devono essere true: `true && false` = `false`
- `||` (OR) — almeno uno deve essere true: `true || false` = `true`

Esempio dal programma dei numeri primi:
```java
while((j < i) && !divisibile) {   // continua mentre j < i E divisibile è false
    // ...
}
```

### Operatori di confronto
- `==` — uguaglianza: `5 == 5` → `true`
- `!=` — diversità: `5 != 3` → `true`
- `<` — minore di: `5 < 10` → `true`
- `>` — maggiore di: `5 > 10` → `false`
- `<=` — minore o uguale: `5 <= 5` → `true`
- `>=` — maggiore o uguale: `10 >= 5` → `true`

## 10. Numeri Primi
Un **numero primo** è un numero naturale **maggiore di 1** che è divisibile **solo per 1 e per se stesso**.

**Esempi di numeri primi:**
- `2` (unico numero primo pari)
- `3, 5, 7, 11, 13, 17, 19, 23, 29, 31`...

**Numeri NON primi:**
- `1` (per definizione non è primo)
- `4` (divisibile per 2)
- `6` (divisibile per 2 e 3)
- `8, 9, 10, 12, 14, 15`... (numeri composti)

**Algoritmo di verifica (usato in Esercizio_3_2_4):**
```java
// Controlla se il numero i è primo
boolean isPrimo = true;
for(int j = 2; j < i; j++) {
    if(i % j == 0) {           // se i è divisibile per j
        isPrimo = false;        // allora non è primo
        break;                  // esci dal ciclo
    }
}
if(isPrimo) System.out.println(i);  // stampa se primo
```

## 11. Istruzione `switch` e `break`

Lo `switch` è un'istruzione di selezione che permette di eseguire codice diverso in base al valore di una variabile.

### Sintassi base

```java
switch (variabile) {
    case valore1:
        // codice se variabile == valore1
        break;
    case valore2:
        // codice se variabile == valore2
        break;
    default:
        // codice se nessun case corrisponde
}
```

### Cosa fa `break`

- **`break`** interrompe immediatamente l'esecuzione dello `switch`
- **Senza `break`** (fall-through): continua a eseguire i `case` successivi anche se non corrisponde

### Esempio pratico (Esercizio_3_2_5)

```java
int x = 4;
switch (x) {
    case 1: 
        System.out.println("dire"); 
        break;
    case 2: 
        System.out.println("fare"); 
        break;
    case 3: 
        System.out.println("baciare"); 
        break;
    case 4: 
        System.out.println("lettera");  // ← x=4, quindi esegue questo
        break;                          // ← e poi esce dallo switch
    case 5: 
        System.out.println("testamento"); 
        break;
    default: 
        System.out.println("non so...");
}
// Output: lettera
```

### Cosa succederebbe SENZA break

```java
int x = 4;
switch (x) {
    case 1: System.out.println("dire");      // non corrisponde, salta
    case 2: System.out.println("fare");      // non corrisponde, salta
    case 3: System.out.println("baciare");   // non corrisponde, salta
    case 4: System.out.println("lettera");   // CORRISPONDE, esegue
    case 5: System.out.println("testamento"); // CONTINUA (no break!)
    default: System.out.println("non so...");  // E CONTINUA ANCHE QUI!
}
// Output:
// lettera
// testamento
// non so...
```

Questo si chiama **fall-through** ed è quasi sempre un errore. Usa sempre `break`!

### Quando `break` non serve

- Nel `default` se è l'ultimo (esce comunque)
- Se intendi fare apposta il fall-through (raro, documenta bene!)

```java
switch (giorno) {
    case "lunedì":
    case "martedì":
    case "mercoledì":
    case "giovedì":
    case "venerdì":
        System.out.println("Giorno lavorativo");
        break;
    case "sabato":
    case "domenica":
        System.out.println("Weekend");
        break;
}
// Qui il fall-through è intenzionale e logico!
```

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