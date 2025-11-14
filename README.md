# AutorennenFX

Ein kleines JavaFX-Spiel, in dem zwei Autos und ein Fahrrad auf einer Fahrbahn fahren können.  
Die Fahrzeuge werden mit Buttons gesteuert, besitzen eine einfache Physik (Beschleunigen, Bremsen) sowie Soundeffekte (Hupe/Klingel) und reagieren aufeinander.

## Features

- Zwei Autos (`Auto` und `Auto2`) und ein Fahrrad (`Fahrrad`)
- Steuerung über Buttons (Gas, Bremse, Hupe/Klingel)
- Einfache Geschwindigkeitsphysik:
  - Beschleunigen mit Obergrenze
  - Bremsen bis zum Stillstand
- Laufende Animationsschleife:
  - Fahrzeuge bewegen sich kontinuierlich über die Fahrbahn
  - Runden werden beendet (Fahrzeug erscheint wieder links, wenn es rechts herausfährt)
- Soundeffekte:
  - Autos hupen mit `hupe.wav`
  - Fahrrad klingelt mit `klingel.wav`
- Visuelle Darstellung mit Bildern:
  - Auto- und Fahrrad-Grafiken aus `auto.png` und `fahrrad.png`
  - Bilder werden skalierend gezeichnet (konstante Höhe, Seitenverhältnis bleibt erhalten)
- Schock-Effekt:
  - Wenn ein Fahrzeug hupt/klingelt, wird **nur das nächstgelegene andere** Fahrzeug in Reichweite stark abgebremst
  - Der Auslöser selbst bleibt von diesem Effekt **unberührt**

## Projektstruktur
```
text
AutorennenFX_Start/
  src/
    main/
      java/
        com/example/autorennenfx/
          Application.java      // JavaFX Application, Einstiegspunkt
          Controller.java       // UI-Logik, Update-Loop, Button-Handler
          Auto.java             // Erstes Auto
          Auto2.java            // Zweites Auto, basiert auf Auto
          Fahrrad.java          // Fahrrad
          Fahrzeug.java         // Abstrakte Basisklasse für Fahrzeuge
          Flotte.java           // Verwaltung aller Fahrzeuge (Liste, Shock-Logik)
          EventDispatcher.java  // Allgemeiner Event-Dispatcher (optional)
        module-info.java        // Java-Moduldefinition
      resources/
        com/example/autorennenfx/
          autorennen.fxml       // UI-Layout
          auto.png              // Bild für Autos
          fahrrad.png           // Bild für Fahrrad
          hupe.wav              // Hup-Sound
          klingel.wav           // Klingel-Sound
  pom.xml                       // Maven-Konfiguration
  mvnw, mvnw.cmd                // Maven Wrapper
```
## Voraussetzungen

- Java Development Kit (JDK) 19 oder höher
- Maven (lokal installiert oder über Maven Wrapper `mvnw`)
- JavaFX-Bibliotheken werden über Maven eingebunden (Controls, FXML, Media, Graphics)

## Build & Run

### Mit Maven Wrapper (empfohlen)

Im Projektverzeichnis:
```
bash
# Unter Linux / macOS
./mvnw clean javafx:run

# Unter Windows
mvnw.cmd clean javafx:run
```
### Mit lokal installiertem Maven
```
bash
mvn clean javafx:run
```
Das JavaFX-Fenster geöffnet sich mit der Fahrbahn und den Bedien-Panels.

## Steuerung

Im UI gibt es drei Kontrollbereiche: **Auto 1**, **Auto 2** und **Fahrrad**.

- **Auto 1**
  - `Gas`: Auto 1 beschleunigt
  - `Bremse`: Auto 1 bremst ab
  - `Hupe`: spielt Hup-Sound, löst Schock-Effekt bei dem nächstgelegenen anderen Fahrzeug aus

- **Auto 2**
  - `Gas`: Auto 2 beschleunigt
  - `Bremse`: Auto 2 bremst ab
  - `Hupe`: spielt Hup-Sound, löst Schock-Effekt bei dem nächstgelegenen anderen Fahrzeug aus

- **Fahrrad**
  - `Treten`: Fahrrad beschleunigt
  - `Bremse`: Fahrrad bremst ab
  - `Klingel`: spielt Klingel-Sound, löst Schock-Effekt bei dem nächstgelegenen anderen Fahrzeug aus

Die Tachos für Auto 1 und Auto 2 zeigen die aktuelle Geschwindigkeit in km/h an (vereinfacht berechnet).

## Schock-Logik

- Bei jedem Hupen/Klingeln wird die **Flotte** (Liste aller Fahrzeuge) geprüft.
- Es wird die **Distanz auf der X-Achse** zwischen Auslöser und anderen Fahrzeugen verglichen.
- Befindet sich ein anderes Fahrzeug innerhalb einer gewissen Reichweite (z.B. 40 Pixel), wird **das nächstgelegene** davon stark abgebremst (`erschrecken()`).
- Der Auslöser selbst behält seine Geschwindigkeit (verlangsamt sich nicht durch die eigene Hupe/Klingel).

## Anpassungen / Erweiterungen

Mögliche Ideen zur Erweiterung des Projekts:

- Eigenen Tacho für das Fahrrad hinzufügen
- Variable Reichweite oder Stärke des Schock-Effekts
- Runden/Positionsanzeige (z.B. „Auto 1 hat 3 Runden geschafft“)
- Kollisions-Erkennung zwischen Fahrzeugen
- Verschiedene Fahrbahnen oder Hintergründe
- Mehr Fahrzeugtypen mit unterschiedlichen Eigenschaften

## Lizenz

Dieses Projekt ist als Lern-/Beispielprojekt gedacht.  
Verwende oder passe es frei für Unterricht, Übungen oder eigene Experimente an.
```
