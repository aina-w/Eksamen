# Mappeeksamen i Algoritmer og Datastrukturer Høst 2020

# Krav til innlevering

Se oblig-tekst for alle krav, og husk spesielt på følgende:

* Git er brukt til å dokumentere arbeid (minst 2 commits per oppgave, beskrivende commit-meldinger)	
* git bundle er levert inn
* Hovedklassen ligger i denne path'en i git: src/no/oslomet/cs/algdat/Eksamen/EksamenSBinTre.java
* Ingen debug-utskrifter
* Alle testene i test-programmet kjører og gir null feil (også spesialtilfeller)
* Readme-filen her er fyllt ut som beskrevet


Kandidatnummer: 287

# Beskrivelse av oppgaveløsning (4-8 linjer/setninger per oppgave)

Jeg har brukt git til å dokumentere arbeidet mitt. Jeg har 22 commits totalt, og hver logg-melding beskriver det jeg har gjort av endringer.

* Oppgave 1: Her brukte jeg kode fra kompendiet (5.2.3a). Metoden legger inn noder, og det er viktig at hver node har riktig 
foreldre-referanse. Her måtte jeg passe på at når jeg opprettet en ny node, så var det q som var forelder. 

* Oppgave 2: Når vi vet det finnes noder i treet, bruker vi komparatoren til å finne ut om nodene skal legges til høyre eller venstre.
Deretter legges de på sin respektive plass i treet. Jeg returnerer også 0 dersom verdi ikke finnes i treet. 

*Oppgave 3: I førstePostorden har vi p som rot, og finner den første noden post order. I nestePostorder sjekker vi om p er roten. Deretter 
finner vi ut om p er et høyre eller venstre barn. Den neste i postorden vil alltid være den noden lengst til venstre sitt høyre barn, dersom
den lengst til venstre eksisterer. 

*Oppgave 4: Når p ikke er null, skriver vi ut den første noden p i postorden. Deretter bruker jeg nestePostorden() til å skrive ut den 
neste noden. I den rekursive funksjonen traverserer jeg treet i postorden rekkefølge og skriver det ut. 

*Oppgave 5: Har løst serialize() ved å først opprette en ArrayList jeg kan lagre verdiene fra treet i. 
Deretter har jeg også opprettet en kø, og starter med å legge roten sist i køen. Så legger jeg verdiene fra
treet inn i køen og returnerer arrayet jeg har laget. 
I deserialize opprettet jeg et nytt tre og bruker komparatoren. Så bruker jeg arrayet fra serialize, looper gjennom det 
og legger verdiene inn i det nye treet. 


*Oppgave 6: I fjern-metoden kopierte jeg kode fra kompendiet 5.2.8d).Jeg sammenlikner input-verdien med rot-verdien, og hvis cmp er
mindre enn 0, er q forelder til p og p går til venstre. Hvis cmp er større enn 0, går den til høyre. Hvis p er null, er treet tomt. Her må jeg sjekke om b ikke er null, for hvis den ikke er det, 
 så er q forelder til b.  Så sjekker jeg om p er roten, hvis den er det, setter jeg roten til b. Hvis p er q sitt venstre barn, setter jeg q sitt venstre barn til b.
Oppretter deretter nye hjelpenoder s=p og r=p.høyre. s er forelder til r. Sjekker om r sin venstre ikke er lik null, og setter dermed
s lik r, og r lik venstrebarnet til r. Hvis s ikke er lik p, settes s sitt venstre barn lik r sitt høyre barn. Hvis ikke settes s sitt høyre barn lik r sitt høyre barn. 
I fjernAlle sjekker jeg om treet er tomt, og returnerer da 0 hvis det er det. Oppretter en teller som teller forekomster som blir fjernet, og kaller på fjern-metoden for å 
fjerne verdiene. 
For nullstill-metoden opprettet jeg en privat rekursiv metode nullstillRecursive som nullstiller. Den går rekursivt nedover venstre og høyre og setter verdiene til null, og reduserer da antallet
hver gang og setter verdien til p til null. Så i nullstill kaller jeg på nullstillRecursive som tar inn roten som parameter og setter roten til null. Jeg var litt usikker på om det var lov å sette roten til null her, 
men jeg fant ikke noen annen måte å gjøre det på. 


*Ellers:
Jeg har 8 warnings, men det er tilsynelatende ingenting jeg kan gjøre med dem, utenom å gjerne import-statements og metoder som ikke blir brukt, 
men det dropper jeg ettersom de stor i EksamenSBinTre-filen fra start.