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

## Note Importanti
- Java è case-sensitive (maiuscole e minuscole sono diverse)
- Ogni file `.java` pubblico deve avere lo stesso nome della classe che contiene
- Il metodo `main` è il punto di ingresso del programma:
```java
public static void main(String[] args) {
    // Il programma inizia qui
}
```

---
*Questo documento verrà aggiornato man mano che impariamo nuovi concetti.*