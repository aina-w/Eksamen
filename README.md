# Mappeeksamen i Algoritmer og Datastrukturer Høst 2020

# Krav til innlevering

Se oblig-tekst for alle krav, og husk spesielt på følgende:

* Git er brukt til å dokumentere arbeid (minst 2 commits per oppgave, beskrivende commit-meldinger)	
* git bundle er levert inn
* Hovedklassen ligger i denne path'en i git: src/no/oslomet/cs/algdat/Eksamen/EksamenSBinTre.java
* Ingen debug-utskrifter
* Alle testene i test-programmet kjører og gir null feil (også spesialtilfeller)
* Readme-filen her er fyllt ut som beskrevet


# Beskrivelse av oppgaveløsning (4-8 linjer/setninger per oppgave)

Jeg har brukt git til å dokumentere arbeidet mitt. Jeg har ** commits totalt, og hver logg-melding beskriver det jeg har gjort av endringer.

* Oppgave 1: Her brukte jeg kode fra kompendiet (5.2.3a). Metoden legger inn noder, og det er viktig at hver node har riktig 
foreldre-referanse. Her måtte jeg passe på at når jeg opprettet en ny node, så var det q som var forelder. 

* Oppgave 2: Når vi vet det finnes noder i treet, bruker vi komparatoren til å finne ut om nodene skal legges til høyre eller venstre.
Deretter legges de på sin respektive plass i treet. Jeg returnerer også 0 dersom verdi ikke finnes i treet. 

*Oppgave 3: I førstePostorden har vi p som rot, og finner den første noden post order. I nestePostorder sjekker vi om p er roten. Deretter 
finner vi ut om p er et høyre eller venstre barn. Den neste i postorden vil alltid være den noden lengst til venstre sitt høyre barn, dersom
den lengst til venstre eksisterer. 

*Oppgave 4: Når p ikke er null, skriver vi ut den første noden p i postorden. Deretter bruker jeg nestePostorden() til å skrive ut den 
neste noden. I den rekursive funksjonen traverserer jeg treet i postorden rekkefølge og skriver det ut. 

*Oppgave 5:

*Oppgave 6: 