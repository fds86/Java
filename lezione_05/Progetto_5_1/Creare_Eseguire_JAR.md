# Creare ed Eseguire un JAR fuori da VS Code

Questo documento mostra i passaggi per compilare sorgenti Java, creare un JAR eseguibile e avviarlo dalla Command Window / PowerShell (ossia fuori da VS Code).

**Prerequisiti**
- JDK installato (controlla con `java -version` e `javac -version`).
- Variabili PATH aggiornate in modo che `java`, `javac`, `jar` siano raggiungibili.

---

## 1) Individua la classe `main`
Cerca quale classe contiene `public static void main(String[] args)`. Esempio (PowerShell):

```powershell
Select-String -Path .\src\**\*.java -Pattern "public static void main"
```

Prendi nota del nome completo della classe (fully-qualified) es.: `Progetto_5_1.App`.

---

## 2) Compila i sorgenti
Dalla root del progetto (dove si trova `src`) compila tutte le classi nella cartella `classes`:

```powershell
cd C:\Francesco\Git_Repos\Java\lezione_05\Progetto_5_1
javac -d classes src\**\*.java
```

- L'opzione `-d classes` posiziona i `.class` nella gerarchia di package dentro `classes`.

---

## 3A) Crea un manifest (opzione esplicita)
Crea un file `manifest.txt` che dichiari la `Main-Class`. Il file DEVE terminare con una newline.

Esempio PowerShell (assicura la newline finale):

```powershell
@"
Main-Class: Progetto_5_1.App

"@ | Out-File -Encoding ASCII manifest.txt
```

Controlla che il contenuto sia corretto:

```powershell
Get-Content manifest.txt
```

Poi crea il JAR inserendo il manifest:

```powershell
jar cfm app.jar manifest.txt -C classes .
```

---

## 3B) Creare il JAR senza file manifest separato (più semplice)
In alternativa non serve creare `manifest.txt`: usa `jar cfe` per specificare la Main-Class direttamente.

```powershell
jar cfe app.jar Progetto_5_1.App -C classes .
```

Questa opzione è comoda e rapida: `jar` creerà automaticamente il manifest e imposterà `Main-Class`.

---

## 4) Eseguire il JAR
Dalla directory che contiene `app.jar`:

```powershell
java -jar app.jar
```

Con argomenti:

```powershell
java -jar app.jar arg1 arg2
```

Con opzioni di memoria:

```powershell
java -Xmx512m -jar app.jar
```

---

## Verifiche e troubleshooting
- Controlla il contenuto del JAR e la presenza del manifest:

```powershell
jar tf app.jar
# estrai e leggi il manifest
jar xf app.jar META-INF/MANIFEST.MF
Get-Content META-INF/MANIFEST.MF
```

- Se vedi l'errore `no main manifest attribute` o "nessun attributo manifest principale":
  - Assicurati che `MANIFEST.MF` contenga `Main-Class: <fully-qualified-name>` e che ci sia una newline finale.
  - Oppure ricrea il JAR usando `jar cfe` (vedi 3B) per evitare problemi di manifest.

- Per verificare che la compilazione abbia prodotto `.class`:

```powershell
Get-ChildItem -Recurse classes | Select-String "App.class"
```

---

## JAR con dipendenze (fat/uber JAR)
Se il tuo progetto usa librerie esterne (jar in `lib/`), è preferibile creare un JAR che contenga tutte le dipendenze:

- Con **Maven**: usa il plugin Shade o Assembly. Esegui `mvn clean package` e configura lo Shade per produrre il JAR con dipendenze.
- Con **Gradle**: usa il plugin `shadow` e `gradlew shadowJar`.

Esempio rapido (Maven shade) nel `pom.xml`:
```xml
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-shade-plugin</artifactId>
  <version>3.4.1</version>
  <!-- configurazione per mainClass -->
</plugin>
```

---

## Script di comodo
- `run.bat` (Windows):

```bat
@echo off
java -jar app.jar %*
pause
```

- `run.ps1` (PowerShell):

```powershell
java -jar app.jar @args
Read-Host "Premi invio per uscire"
```

---

## Note importanti
- Usa il nome della classe `Main-Class` completamente qualificato se la classe è in un package (es. `it.example.App`).
- Il manifest richiede la newline finale: senza di essa la voce potrebbe non essere letta.
- Per progetti con dipendenze, preferisci Maven/Gradle per gestire automaticamente la build e la generazione del JAR eseguibile.

---

Se vuoi, preparo anche uno script PowerShell che compila e crea il JAR automaticamente (ad esempio `build.ps1`). Vuoi che lo aggiunga nel progetto?