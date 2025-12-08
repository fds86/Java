# Ereditarietà in Java - La Parola Chiave `extends`

## Indice

1. [Definizione](#definizione)
2. [Sintassi e Concetti Base](#sintassi-e-concetti-base)
3. [Relazione IS-A](#relazione-is-a)
4. [Cosa si Eredita](#cosa-si-eredita)
5. [Il Costruttore e super()](#il-costruttore-e-super)
6. [Sovrascrittura dei Metodi (Override)](#sovrascrittura-dei-metodi-override)
7. [Modificatori di Accesso nell'Ereditarietà](#modificatori-di-accesso-nellereditarietà)
8. [Polimorfismo](#polimorfismo)
9. [Classi Abstract](#classi-abstract)
10. [Classi Final](#classi-final)
11. [Gerarchia di Ereditarietà](#gerarchia-di-ereditarietà)
12. [Esempi Pratici](#esempi-pratici)
13. [Best Practices](#best-practices)

---

## Definizione

**`extends`** è la parola chiave Java che implementa l'**ereditarietà** (inheritance), uno dei pilastri della programmazione orientata agli oggetti (OOP).

**Ereditarietà**: meccanismo che permette a una classe (sottoclasse o classe figlia) di **ereditare** attributi e metodi da un'altra classe (superclasse o classe padre).

```java
public class ClasseFiglia extends ClassePadre {
    // La ClasseFiglia eredita tutto da ClassePadre
}
```

---

## Sintassi e Concetti Base

### Sintassi Generale

```java
public class Sottoclasse extends Superclasse {
    // Corpo della classe
}
```

### Terminologia

| Termine | Significato | Sinonimi |
|---------|-------------|----------|
| **Superclasse** | Classe che viene estesa | Classe padre, classe base |
| **Sottoclasse** | Classe che estende | Classe figlia, classe derivata |
| **extends** | Parola chiave per l'ereditarietà | - |
| **super** | Riferimento alla superclasse | - |

### Esempio nel Progetto11

```java
public class Esempio11_1 extends JFrame {
    // Esempio11_1 è la sottoclasse
    // JFrame è la superclasse
}
```

**Significato**: `Esempio11_1` eredita tutte le funzionalità di `JFrame` (finestra Swing).

---

## Relazione IS-A

L'ereditarietà crea una relazione **"è un"** (IS-A):

```java
Esempio11_1 finestra = new Esempio11_1("Prova");

// Esempio11_1 IS-A JFrame
JFrame frame = finestra;  // ✅ OK - conversione implicita (upcasting)
```

### Esempio Concettuale

```java
class Animale { }
class Cane extends Animale { }
class Gatto extends Animale { }

// Un Cane È-UN Animale
// Un Gatto È-UN Animale

Cane fido = new Cane();
Animale a = fido;  // ✅ OK - Cane è un Animale
```

---

## Cosa si Eredita

### 1. Attributi (Campi)

```java
class Veicolo {
    protected String marca;
    protected int anno;
}

class Auto extends Veicolo {
    // Eredita: marca, anno
    
    public void mostraInfo() {
        System.out.println("Marca: " + marca);  // Ereditato
        System.out.println("Anno: " + anno);    // Ereditato
    }
}
```

### 2. Metodi

```java
class Veicolo {
    public void accendi() {
        System.out.println("Veicolo acceso");
    }
    
    public void spegni() {
        System.out.println("Veicolo spento");
    }
}

class Auto extends Veicolo {
    // Eredita: accendi(), spegni()
    
    public void guida() {
        accendi();  // Metodo ereditato
        System.out.println("Auto in movimento");
        spegni();   // Metodo ereditato
    }
}
```

### 3. Costruttori (NON si ereditano, ma si possono chiamare)

```java
class Persona {
    private String nome;
    
    public Persona(String nome) {
        this.nome = nome;
    }
}

class Studente extends Persona {
    private int matricola;
    
    public Studente(String nome, int matricola) {
        super(nome);  // Chiama il costruttore di Persona
        this.matricola = matricola;
    }
}
```

### Tabella Ereditarietà per Modificatore

| Modificatore | Ereditato dalla Sottoclasse? |
|--------------|------------------------------|
| `public` | ✅ Sì |
| `protected` | ✅ Sì |
| package-private (default) | ✅ Sì (se stesso package) |
| `private` | ❌ No (ma accessibile tramite metodi pubblici) |

---

## Il Costruttore e super()

### Regola Fondamentale

Il costruttore della sottoclasse **deve chiamare** il costruttore della superclasse usando `super()`.

### Sintassi

```java
public class Sottoclasse extends Superclasse {
    public Sottoclasse(parametri) {
        super(parametri);  // DEVE essere la PRIMA istruzione
        // Poi il resto del codice
    }
}
```

### Esempio dal Progetto11

```java
public class Esempio11_1 extends JFrame {
    public Esempio11_1(String titolo) {
        super(titolo);  // Chiama il costruttore JFrame(String title)
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);
    }
}
```

### Super Implicito

Se non chiami `super()` esplicitamente, Java chiama automaticamente `super()` (costruttore senza parametri):

```java
class Padre {
    public Padre() {
        System.out.println("Costruttore Padre");
    }
}

class Figlio extends Padre {
    public Figlio() {
        // super() viene chiamato automaticamente qui
        System.out.println("Costruttore Figlio");
    }
}

// Output:
// Costruttore Padre
// Costruttore Figlio
```

### Errore Comune

```java
class Padre {
    public Padre(String nome) { }  // NESSUN costruttore senza parametri!
}

class Figlio extends Padre {
    public Figlio() {
        // ❌ ERRORE! Non esiste super() senza parametri in Padre
    }
}

// Soluzione:
class Figlio extends Padre {
    public Figlio() {
        super("nome");  // ✅ OK
    }
}
```

---

## Sovrascrittura dei Metodi (Override)

### Definizione

**Override**: ridefinire un metodo ereditato per cambiarne il comportamento.

### Sintassi

```java
class Animale {
    public void faiVerso() {
        System.out.println("Verso generico");
    }
}

class Cane extends Animale {
    @Override  // Annotazione (consigliata)
    public void faiVerso() {
        System.out.println("Bau Bau!");
    }
}

class Gatto extends Animale {
    @Override
    public void faiVerso() {
        System.out.println("Miao!");
    }
}
```

### Chiamare il Metodo della Superclasse

Usa `super.nomeMetodo()` per chiamare la versione della superclasse:

```java
class Veicolo {
    public void descrivi() {
        System.out.println("Questo è un veicolo");
    }
}

class Auto extends Veicolo {
    @Override
    public void descrivi() {
        super.descrivi();  // Chiama Veicolo.descrivi()
        System.out.println("Nello specifico, un'auto");
    }
}

// Output:
// Questo è un veicolo
// Nello specifico, un'auto
```

### Regole per l'Override

1. **Stessa firma**: nome, parametri e tipo di ritorno devono essere identici
2. **Visibilità uguale o maggiore**: non puoi ridurre la visibilità
3. **Stesso tipo di ritorno o sottotipo** (covariant return type)
4. **Non può lanciare eccezioni più ampie**

```java
class Padre {
    protected String metodo() throws IOException {
        return "Padre";
    }
}

class Figlio extends Padre {
    @Override
    public String metodo() throws FileNotFoundException {  // ✅ OK
        // public >= protected ✅
        // FileNotFoundException è sottoclasse di IOException ✅
        return "Figlio";
    }
}
```

### @Override Annotation

**Sempre consigliata**: aiuta il compilatore a verificare che stai davvero sovrascrivendo:

```java
class Padre {
    public void metodo(int x) { }
}

class Figlio extends Padre {
    @Override
    public void metodo(double x) { }  // ❌ ERRORE! Non è override (firma diversa)
}
```

---

## Modificatori di Accesso nell'Ereditarietà

### Visibilità degli Attributi Ereditati

```java
class Padre {
    public int pubblico = 1;
    protected int protetto = 2;
    int packagePrivate = 3;
    private int privato = 4;
}

class Figlio extends Padre {
    public void accedi() {
        System.out.println(pubblico);       // ✅ OK
        System.out.println(protetto);       // ✅ OK
        System.out.println(packagePrivate); // ✅ OK (stesso package)
        System.out.println(privato);        // ❌ ERRORE! private non accessibile
    }
}
```

### Protected: Il Modificatore dell'Ereditarietà

`protected` permette l'accesso a:
- Classi nello stesso package
- Sottoclassi (anche in package diversi)

```java
package pacchetto1;
public class Padre {
    protected void metodoProtetto() {
        System.out.println("Metodo protetto");
    }
}

package pacchetto2;
import pacchetto1.Padre;

public class Figlio extends Padre {
    public void usa() {
        metodoProtetto();  // ✅ OK - sottoclasse può accedere a protected
    }
}
```

---

## Polimorfismo

### Definizione

**Polimorfismo**: la capacità di un oggetto di assumere molte forme. Con l'ereditarietà, un oggetto della sottoclasse può essere trattato come oggetto della superclasse.

### Esempio Base

```java
class Animale {
    public void faiVerso() {
        System.out.println("Verso generico");
    }
}

class Cane extends Animale {
    @Override
    public void faiVerso() {
        System.out.println("Bau!");
    }
}

class Gatto extends Animale {
    @Override
    public void faiVerso() {
        System.out.println("Miao!");
    }
}

// Polimorfismo in azione:
Animale a1 = new Cane();   // Cane trattato come Animale
Animale a2 = new Gatto();  // Gatto trattato come Animale

a1.faiVerso();  // Output: Bau!  (metodo di Cane)
a2.faiVerso();  // Output: Miao! (metodo di Gatto)
```

### Polimorfismo in Array

```java
Animale[] zoo = new Animale[3];
zoo[0] = new Cane();
zoo[1] = new Gatto();
zoo[2] = new Animale();

for (Animale a : zoo) {
    a.faiVerso();  // Polimorfismo: chiama il metodo corretto per ogni tipo
}

// Output:
// Bau!
// Miao!
// Verso generico
```

### Casting

```java
Animale a = new Cane();

// Downcasting (da superclasse a sottoclasse) - richiede cast esplicito
Cane c = (Cane) a;  // ✅ OK - a è effettivamente un Cane

// Verifica tipo prima del cast
if (a instanceof Cane) {
    Cane cane = (Cane) a;
    // Usa metodi specifici di Cane
}
```

---

## Classi Abstract

### Definizione

Una **classe astratta** non può essere istanziata direttamente, ma serve come base per altre classi.

### Sintassi

```java
abstract class Forma {
    protected String colore;
    
    // Metodo astratto (senza implementazione)
    public abstract double calcolaArea();
    
    // Metodo concreto (con implementazione)
    public void stampaColore() {
        System.out.println("Colore: " + colore);
    }
}

class Cerchio extends Forma {
    private double raggio;
    
    public Cerchio(double raggio) {
        this.raggio = raggio;
    }
    
    @Override
    public double calcolaArea() {
        return Math.PI * raggio * raggio;
    }
}

class Rettangolo extends Forma {
    private double base, altezza;
    
    public Rettangolo(double base, double altezza) {
        this.base = base;
        this.altezza = altezza;
    }
    
    @Override
    public double calcolaArea() {
        return base * altezza;
    }
}

// Utilizzo
Forma f1 = new Cerchio(5);       // ✅ OK
Forma f2 = new Rettangolo(3, 4); // ✅ OK
Forma f3 = new Forma();          // ❌ ERRORE! Classe astratta non istanziabile
```

### Quando Usare Classi Abstract

- Vuoi definire un **contratto** che le sottoclassi devono rispettare
- Vuoi fornire **implementazione parziale** (alcuni metodi concreti)
- Vuoi **impedire l'istanziazione diretta** della classe base

---

## Classi Final

### Classe Final

Una classe `final` **non può essere estesa**:

```java
public final class MiaClasseFinale {
    // Codice
}

class Sottoclasse extends MiaClasseFinale {  // ❌ ERRORE!
    // Non puoi estendere una classe final
}
```

### Esempio: String è Final

```java
// String è dichiarata final
public final class String { ... }

// Non puoi fare:
class MiaStringa extends String { }  // ❌ ERRORE!
```

### Metodo Final

Un metodo `final` **non può essere sovrascritto**:

```java
class Padre {
    public final void metodoFinale() {
        System.out.println("Non modificabile");
    }
}

class Figlio extends Padre {
    @Override
    public void metodoFinale() {  // ❌ ERRORE!
        // Non puoi sovrascrivere un metodo final
    }
}
```

---

## Gerarchia di Ereditarietà

### Ogni Classe Eredita da Object

In Java, **tutte le classi** ereditano implicitamente da `java.lang.Object`:

```java
class MiaClasse {
    // Implicitamente: extends Object
}

// È equivalente a:
class MiaClasse extends Object {
}
```

### Metodi Ereditati da Object

Tutte le classi ereditano questi metodi:

```java
toString()       // Rappresentazione stringa dell'oggetto
equals(Object)   // Confronto per uguaglianza
hashCode()       // Codice hash per collezioni
getClass()       // Informazioni sulla classe
clone()          // Copia dell'oggetto
finalize()       // Chiamato prima della garbage collection (deprecato)
```

### Esempio Gerarchia JFrame

```
java.lang.Object
    └── java.awt.Component
            └── java.awt.Container
                    └── java.awt.Window
                            └── java.awt.Frame
                                    └── javax.swing.JFrame
                                            └── Esempio11_1
```

**Esempio11_1** eredita da **tutta la catena**!

---

## Esempi Pratici

### Esempio 1: Sistema di Gestione Dipendenti

```java
// Classe base
class Dipendente {
    protected String nome;
    protected double stipendioBase;
    
    public Dipendente(String nome, double stipendioBase) {
        this.nome = nome;
        this.stipendioBase = stipendioBase;
    }
    
    public double calcolaStipendio() {
        return stipendioBase;
    }
    
    public void stampaInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("Stipendio: €" + calcolaStipendio());
    }
}

// Sottoclasse 1
class Manager extends Dipendente {
    private double bonus;
    
    public Manager(String nome, double stipendioBase, double bonus) {
        super(nome, stipendioBase);
        this.bonus = bonus;
    }
    
    @Override
    public double calcolaStipendio() {
        return stipendioBase + bonus;
    }
}

// Sottoclasse 2
class Programmatore extends Dipendente {
    private int oreExtra;
    private double pagaOraria = 50.0;
    
    public Programmatore(String nome, double stipendioBase, int oreExtra) {
        super(nome, stipendioBase);
        this.oreExtra = oreExtra;
    }
    
    @Override
    public double calcolaStipendio() {
        return stipendioBase + (oreExtra * pagaOraria);
    }
}

// Utilizzo con polimorfismo
public class TestDipendenti {
    public static void main(String[] args) {
        Dipendente[] dipendenti = new Dipendente[3];
        dipendenti[0] = new Dipendente("Mario", 1500);
        dipendenti[1] = new Manager("Laura", 2000, 500);
        dipendenti[2] = new Programmatore("Paolo", 1800, 20);
        
        for (Dipendente d : dipendenti) {
            d.stampaInfo();
            System.out.println("---");
        }
    }
}
```

### Esempio 2: Forme Geometriche

```java
abstract class Forma {
    protected String colore;
    
    public Forma(String colore) {
        this.colore = colore;
    }
    
    // Metodo astratto
    public abstract double calcolaArea();
    public abstract double calcolaPerimetro();
    
    // Metodo concreto
    public void descrivi() {
        System.out.println("Forma di colore " + colore);
        System.out.println("Area: " + calcolaArea());
        System.out.println("Perimetro: " + calcolaPerimetro());
    }
}

class Cerchio extends Forma {
    private double raggio;
    
    public Cerchio(String colore, double raggio) {
        super(colore);
        this.raggio = raggio;
    }
    
    @Override
    public double calcolaArea() {
        return Math.PI * raggio * raggio;
    }
    
    @Override
    public double calcolaPerimetro() {
        return 2 * Math.PI * raggio;
    }
}

class Rettangolo extends Forma {
    private double base, altezza;
    
    public Rettangolo(String colore, double base, double altezza) {
        super(colore);
        this.base = base;
        this.altezza = altezza;
    }
    
    @Override
    public double calcolaArea() {
        return base * altezza;
    }
    
    @Override
    public double calcolaPerimetro() {
        return 2 * (base + altezza);
    }
}

class Quadrato extends Rettangolo {
    public Quadrato(String colore, double lato) {
        super(colore, lato, lato);  // Quadrato è un Rettangolo con base = altezza
    }
}
```

### Esempio 3: Veicoli

```java
class Veicolo {
    protected String marca;
    protected int anno;
    protected double velocitaMax;
    
    public Veicolo(String marca, int anno, double velocitaMax) {
        this.marca = marca;
        this.anno = anno;
        this.velocitaMax = velocitaMax;
    }
    
    public void accendi() {
        System.out.println(marca + " acceso");
    }
    
    public void descrivi() {
        System.out.println("Marca: " + marca);
        System.out.println("Anno: " + anno);
        System.out.println("Velocità massima: " + velocitaMax + " km/h");
    }
}

class Auto extends Veicolo {
    private int numeroPorte;
    
    public Auto(String marca, int anno, double velocitaMax, int numeroPorte) {
        super(marca, anno, velocitaMax);
        this.numeroPorte = numeroPorte;
    }
    
    @Override
    public void descrivi() {
        super.descrivi();  // Chiama descrivi() di Veicolo
        System.out.println("Numero porte: " + numeroPorte);
    }
    
    public void suonaClacson() {
        System.out.println("Beep beep!");
    }
}

class Moto extends Veicolo {
    private boolean hasBauletto;
    
    public Moto(String marca, int anno, double velocitaMax, boolean hasBauletto) {
        super(marca, anno, velocitaMax);
        this.hasBauletto = hasBauletto;
    }
    
    @Override
    public void descrivi() {
        super.descrivi();
        System.out.println("Bauletto: " + (hasBauletto ? "Sì" : "No"));
    }
    
    public void impennata() {
        System.out.println("Vroom! Impennata!");
    }
}
```

---

## Best Practices

### 1. Preferisci la Composizione all'Ereditarietà

**Problema con ereditarietà eccessiva:**

```java
// ❌ Ereditarietà rigida
class Stack extends ArrayList {
    // Stack È-UN ArrayList? Semanticamente no!
}
```

**Soluzione con composizione:**

```java
// ✅ Composizione flessibile
class Stack {
    private ArrayList list = new ArrayList();
    
    public void push(Object o) {
        list.add(o);
    }
    
    public Object pop() {
        return list.remove(list.size() - 1);
    }
}
```

### 2. Usa @Override

```java
class Padre {
    public void metodo() { }
}

class Figlio extends Padre {
    @Override  // ✅ Sempre!
    public void metodo() {
        // Se cambi la firma per errore, il compilatore ti avvisa
    }
}
```

### 3. Mantieni la Coerenza IS-A

```java
// ✅ Buon design: un Quadrato È-UN Rettangolo
class Quadrato extends Rettangolo { }

// ❌ Cattivo design: una Stack NON-È-UNA ArrayList
class Stack extends ArrayList { }
```

### 4. Usa super() Correttamente

```java
public class Sottoclasse extends Superclasse {
    public Sottoclasse(parametri) {
        super(parametri);  // ✅ Prima istruzione
        // Poi inizializza gli attributi della sottoclasse
    }
}
```

### 5. Non Abusare dell'Ereditarietà

- Usa l'ereditarietà solo per relazioni IS-A genuine
- Per riutilizzo del codice, considera la composizione
- Limita la profondità della gerarchia (max 3-4 livelli)

### 6. Documenta le Classi Base

```java
/**
 * Classe base per tutti i dipendenti dell'azienda.
 * Le sottoclassi devono implementare calcolaStipendio()
 * in base al loro tipo specifico.
 */
abstract class Dipendente {
    /**
     * Calcola lo stipendio totale del dipendente.
     * @return lo stipendio mensile in euro
     */
    public abstract double calcolaStipendio();
}
```

### 7. Considera le Interface per Contratti Multipli

Java non supporta ereditarietà multipla, ma puoi implementare più interfacce:

```java
interface Volante {
    void vola();
}

interface Nuotante {
    void nuota();
}

// ✅ Può implementare più interfacce
class Anatra extends Animale implements Volante, Nuotante {
    @Override
    public void vola() { }
    
    @Override
    public void nuota() { }
}
```

---

## Riepilogo Rapido

| Concetto | Descrizione |
|----------|-------------|
| `extends` | Parola chiave per l'ereditarietà |
| **Superclasse** | Classe che viene estesa |
| **Sottoclasse** | Classe che estende |
| `super()` | Chiama il costruttore della superclasse |
| `super.metodo()` | Chiama un metodo della superclasse |
| `@Override` | Indica sovrascrittura di un metodo |
| **IS-A** | Relazione semantica dell'ereditarietà |
| **Polimorfismo** | Un oggetto può assumere molte forme |
| `abstract` | Classe/metodo che richiede implementazione |
| `final` | Classe/metodo che non può essere esteso/sovrascritto |
| `protected` | Modificatore per l'ereditarietà |
| `instanceof` | Verifica il tipo di un oggetto |

---

## Regole Chiave da Ricordare

1. ✅ Java supporta solo **ereditarietà singola** (una classe può estendere solo un'altra classe)
2. ✅ Tutte le classi ereditano implicitamente da **Object**
3. ✅ I costruttori **non si ereditano**, ma si possono chiamare con `super()`
4. ✅ `super()` deve essere la **prima istruzione** nel costruttore
5. ✅ I membri `private` **non sono accessibili** nelle sottoclassi
6. ✅ Usa `@Override` per **verificare** la sovrascrittura
7. ✅ Una classe `final` **non può essere estesa**
8. ✅ Un metodo `final` **non può essere sovrascritto**
9. ✅ Classi `abstract` **non possono essere istanziate**
10. ✅ Usa l'ereditarietà per relazioni **IS-A** genuine

---

**Riferimenti**:
- Progetto11 - Esempio11_1.java (ereditarietà da JFrame)
- Oracle Java Tutorials: https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html
