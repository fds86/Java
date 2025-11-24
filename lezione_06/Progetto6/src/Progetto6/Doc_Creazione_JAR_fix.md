# Crea la cartella classes dentro Progetto6
cd C:\Francesco\Git_Repos\Java\lezione_06
New-Item -ItemType Directory -Force .\Progetto6\classes

# Compila mettendo i .class dentro Progetto6\classes
javac -encoding UTF-8 -d .\Progetto6\classes Progetto6\src\Progetto6\Bicicletta.java Progetto6\src\Progetto6\DemoBicicletta.java

# Verifica
Get-ChildItem .\Progetto6\classes\Progetto6\*.class

# Esegui (ora il classpath punta a Progetto6\classes)
java -cp .\Progetto6\classes Progetto6.DemoBicicletta

# Crea il JAR dalla nuova posizione
cd C:\Francesco\Git_Repos\Java\lezione_06\Progetto6
jar cfe Progetto6.jar Progetto6.DemoBicicletta -C classes .

# Esegui da qualsiasi posizione
java -jar .\Progetto6.jar

# Estrai il manifest dal JAR
jar xf Progetto6.jar META-INF/MANIFEST.MF

# Leggi il contenuto
Get-Content META-INF/MANIFEST.MF


# Passo 1: Crea il file manifest
cd C:\Francesco\Git_Repos\Java\lezione_06\Progetto6

# Crea manifest.txt con Main-Class (assicura newline finale)
@"
Main-Class: Progetto6.DemoBicicletta

"@ | Out-File -Encoding ASCII manifest.txt

# Passo 2: Verifica il contenuto del manifest
Get-Content manifest.txt

# Passo 3: Crea il JAR usando il manifest
jar cfm Progetto6.jar manifest.txt -C classes .

# Passo 4: Verifica il JAR
# Elenca il contenuto
jar tf Progetto6.jar

# Estrai e leggi il manifest generato
jar xf Progetto6.jar META-INF/MANIFEST.MF
Get-Content META-INF/MANIFEST.MF

# Passo 5: Esegui il JAR
java -jar Progetto6.jar

# Il più semplice e affidabile (Metodo 1 espanso) per compilare tanti sorgenti:
cd C:\Francesco\Git_Repos\Java\lezione_06\Progetto6

# Pulisci e ricrea classes
Remove-Item -Recurse -Force classes -ErrorAction SilentlyContinue
New-Item -ItemType Directory -Force classes

# Compila tutti i sorgenti
$sources = Get-ChildItem -Path src -Filter *.java -Recurse
javac -encoding UTF-8 -d classes $sources.FullName

# Verifica
Get-ChildItem -Recurse classes\*.class

# Crea JAR
jar cfe Progetto6.jar Progetto6.DemoBicicletta -C classes .

# Esegui
java -jar Progetto6.jar