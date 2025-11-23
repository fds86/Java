@echo off
REM Esegue il JAR specificando il percorso completo. 
REM Il batch funzion anche se posizionato in una cartella diversa.
java -jar "C:\Francesco\Git_Repos\Java\lezione_05\Progetto_5_1\app.jar"
pause

@REM @echo off
@REM REM Per eseguire il JAR da una cartella diversa da quella in cui si trova il batch,
@REM REM è necessario creare un collegamento e posizionarlo nella cartella desiderata.
@REM REM In questo modo, il batch verrà eseguito nella cartella del collegamento.
@REM REM Ottieni la cartella dove si trova il batch

@REM set SCRIPT_DIR=%~dp0

@REM REM Esegui il JAR relativo a quella cartella
@REM java -jar "%SCRIPT_DIR%app.jar"
@REM pause