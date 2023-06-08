IDE (hier IntelliJ mit bundled Maven 3.8.1; openjdk version "17.0.7" 2023-04-18): Zum Starten `main`-Methode in `de.docmorris.bowling.Main` starten.

Alternativ update ich gerne die `pom.xml`, um via CLI bauen und starten zu können. 

## Fachliche Erläuterungen
- Die Regeln sind so formuliert, dass man vereinfachen kann, dass ein Frame ein bis drei Rolls hat. Das liegt daran, dass man entweder im nicht-letzten Frame ist und 1 oder 2 Würfe hat oder im letzten Frame einen Bonuswurf bekommt, wenn der zweite Wurf zum Spare geführt hat oder der erste Wurf zu zwei Bonuswürfen führt über einen Strike.
- Dass Strikes und Spares für zwei bzw. einen Wurf Bonuspunkte geben kann man so interpretieren, dass sich der Multiplikator der darauffolgenden Rolls beginnend mit 1 mit der Punktezahl um 1 erhöht.
- Ich habe die Anforderung der Bonuspunkte (wörtlich aus der Aufgabe "hierfür 10 Punkte + die Punkte aus den nächsten 2 Rolls extra" bzw. "hierfür 10 Punkte + die Punkte aus dem nächsten Roll extra") dahingehend vereinfacht, dass ich diese Punkte erst nach dem durchgespielten Spiel ausrechne und danach erst das Ergebnis ausgebe. Das hat den Nachteil, dass man die Anwendung, Stand jetzt, nur mit höherem Rechenaufwand dafür verwenden kann, z.B. nach dem 7. Frame die aktuellen Punktzahlen ausrechnen zu lassen. Die "Übertragung" von Strikes und Spares konnte so vereinfacht werden.

## Kommentar zum Code
- Klassen-/Methodennamen etc. im Code Englisch
- Ausgabe, wenn nicht fachlich bereits Englisch besetzt auf Deutsch -> beides diskutabel hinsichtlich Ubiquitous Language (DDD)
- Tests sind hinsichtlich Klasse `Frame` bezüglich der Methoden `roll` und `getPointsWon` exemplarisch relativ vollständig die Äquivalenzklassen abgebildet. Den Rest habe zur Zeitersparnis, da exemplarisch bereits gezeigt, nur kurz manuell mit ein paar Beispielen in der Ausgabe nachgerechnet.
- Die eigentlich komplexeste Methode `roll` in der Klasse `Frame` folgt nicht dem Single Level of Abstraction Principle. Das wäre noch zu optimieren.
- In der Klasse `Frame` sind nur an einigen Stellen exemplarisch Javadoc.
- `pom.xml` hat kein sauberes Versionsmanagement mit Properties.
- `Frame` enthält noch einige magic numbers bzw. hard-coded Werte