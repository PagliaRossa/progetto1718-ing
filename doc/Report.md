# Benvenuto in SNA4SLACK
## 1. Introduzione
SNA4Slack (Social Network Analysis for Slack) è un applicativo atto ad analizzare e mostrare risultati di eleborazioni richieste dall'utente sull'applicativo social "Slack".
L'utente richiede le elaborazioni attraverso specifici comandi in input che rappresentano gli argomenti dell'applicativo durante l'esecuzione.
## 2. Modello Concettuale
Modello Concettuale :
![Conceptual](drawings/Conceptual.svg)
## 3. Requisiti Specifici
I requisiti specifici di SNA4Slack sono i seguenti :
 - In qualità di utente voglio visualizzare la lista dei **Member**
 > Criteri di accettazione
 > - Verificare che sia possibile fare la richiesta da linea di comando
 > - Verificare che l'output sia visualizzato su standard output
 > - Verificare che sia possibile specificare il workspace
 > - Verificare che ci sia un file esportato associato al workspace
 > - Verificare che i Member siano visualizzati uno per riga
 > - Verificare che i Member del workspace siano tutti presenti
 > - Verificare che non siano visualizzati Member estranei al workspace
 - In qualità di utente voglio visualizzare la lista dei **Channel**
 > Criteri di accettazione
 > - Verificare che sia possibile fare la richiesta da linea di comando
 > - Verificare che l'output sia visualizzato su standard output
 > - Verificare che sia possibile specificare il workspace
 > - Verificare che ci sia un file esportato associato al workspace
 > - Verificare che i Channel siano visualizzati uno per riga
 > - Verificare che i Channel del workspace siano tutti presenti
 > - Verificare che non siano visualizzati Channel estranei al workspace
 - In qualità di utente voglio visualizzare la lista dei **Member**
   raggruppati per **Channel**
 > Criteri di accettazione
 > - Verificare che sia possibile fare la richiesta da linea di comando
 > - Verificare che l'output sia visualizzato su standard output
 > - Verificare che sia possibile specificare il workspace
 > - Verificare che ci sia un file esportato associato al workspace
 > - Verificare che i Member e Channel siano visualizzati uno per riga , con i "Member" visualizzati subito dopo i "Channel" a cui appartengono
 > - Verificare che sia possibile distinguere quale nome è un "Member" e quale è un Channel
 > - Verificare che i Channel siano tutti presenti
 > - Verificare che non siano visualizzati Channel estranei al workspace
 > - Verificare che i Member di un Channel siano tutti presenti
 > - Verificare che non siano visualizzati Member estranei al Channel
 - In qualità di utente voglio visualizzare la lista dei **Member** di un **Channel**
 > Criteri di accettazione
 > - Verificare che sia possibile fare la richiesta da linea di comando
 > - Verificare che l'output sia visualizzato su standard output
 > - Verificare che sia possibile specificare il workspace
 > - Verificare che ci sia un file esportato associato al workspace
 > - Verificare che sia possibile specificare il Channel
 > - Verificare che i Member siano visualizzati uno per riga dopo il Channel specificato
 > - Verificare che i Member del Channel specificato siano tutti presenti
 > - Verificare che non siano visualizzati Member estranei al Channel specificato
 - In qualità di utente voglio poter avere informazioni di **Help**
 > Criteri di accettazione
 > - Verificare che l'help possa essere richiesto digitando il nome del programma senza parametri aggiuntivi
 > - Verificare che l'help sia suggerito se un comando digitato non è valido
 > - Verificare l'help sia mostrato su standard output
 > - Verificare che siano presenti i comandi per tutte le funzionalità
 - In qualità di utente voglio visualizzare la lista dei **@mention**
 > Criteri di accettazione
 > - Verificare che per ogni @mention sia visualizzata una riga con la coppia (From, To) dove From è lo User che scrive il messaggio con il @mention e To è lo User menzionato.
 > - Verificare che le coppie (From, To) non siano ripetute
 > - Verificare che le coppie (From, To) corrispondenti a un @mention siano tutte presenti
 > - Verificare che siano visualizzate solo coppie (From, To) corrispondenti a un @mention
 > - Verificare che sia possibile specificare il Channel e, nel caso sia specificato, la lista sia ristretta ai soli @mention del Channel
 - In qualità di utente voglio visualizzare la lista dei **@mention** che
   partono da uno **User**
 > Criteri di accettazione:
 > - Verificare che sia possibile specificare lo User da cui partono i @mention
 > - Verificare che per ogni @mention sia visualizzata una riga con la coppia (From, To) dove From è lo User
 specificato nel comando e To è lo User menzionato.
 > - Verificare che le coppie (From, To) non siano ripetute
 > - Verificare che le coppie (From, To) corrispondenti a un @mention siano tutte presenti
 > - Verificare che siano visualizzate solo coppie (From, To) corrispondenti a un @mention
 > - Verificare che sia possibile specificare il Channel e, nel caso sia specificato, la lista sia ristretta ai soli @mention del Channel
 - In qualità di utente voglio visualizzare la lista dei **@mention** che
   arrivano a uno **User**
 > Criteri di accettazione:
 > - Verificare che sia possibile specificare lo User a cui arrivano i @mention
 > - Verificare che per ogni @mention sia visualizzata una riga con la coppia (From, To) dove è lo User che
 scrive il messaggio con il @mention e To è lo User menzionato e specificato nel comando.
 > - Verificare che le coppie (From, To) non siano ripetute
 > - Verificare che le coppie (From, To) corrispondenti a un @mention siano tutte presenti
 > - Verificare che siano visualizzate solo coppie (From, To) corrispondenti a un @mention
 > - Verificare che sia possibile specificare il Channel e, nel caso sia specificato, la lista sia ristretta ai soli
 @mention del Channe
 - In qualità di utente voglio visualizzare la lista pesata dei **@mention**
 > Criteri di accettazione:
 > - Verificare che per ogni @mention sia visualizzata una riga con la tripla**(From, To, Weight)** dove From è lo User che scrive il messaggio con il @mention, To è lo User menzionato, e Weight. è il peso associato che riporta il numero di mention da From a To:.
 > - Verificare che le triple (From, To, Weight) non siano ripetute
 > - Verificare che le triple (From, To, Weight) corrispondenti a un @mention siano tutte presenti
 > - Verificare che siano visualizzate solo triple (From, To, Weight)* corrispondenti a un @mention
 > - Verificare che sia possibile specificare il Channel e, nel caso sia specificato, la lista sia ristretta ai soli @mention del Channel
 - In qualità di utente voglio visualizzare la lista pesata dei **@mention** che partono da uno **User**
 > Criteri di accettazione :
 > - Verificare che sia possibile specificare lo User da cui partono i @mention
 > - Verificare che per ogni @mention sia visualizzata una riga con la tripla (From, To, Weight) dove From è lo User specificato nel comando e To è lo User menzionato, e Weight il numero di mention.
 > - Verificare che le triple (From, To, Weight) non siano ripetute
 > - Verificare che le triple (From, To, Weight) corrispondenti a un @mention siano tutte presenti
 > - Verificare che siano visualizzate solo triple (From, To, Weight) corrispondenti a un @mention
 > - Verificare che sia possibile specificare il Channel e, nel caso sia specificato, la lista sia ristretta ai soli @mention del Channel
 - In qualità di utente voglio visualizzare la lista pesata dei **@mention** che arrivano a uno **User**
 > Criteri di accettazione:
 > - Verificare che sia possibile specificare lo User a cui arrivano i @mention
 > - Verificare che per ogni @mention sia visualizzata una riga con a tripla (From, To, Weight) dove From è lo User che scrive il messaggio con il @mention, To è lo User menzionato e specificato nel comando e Weight il numero di mention.
 > - Verificare che le triple (From, To, Weight) non siano ripetute
 > - Verificare che le ctriple (From, To, Weight) corrispondenti a un @mention siano tutte presenti
 > - Verificare che siano visualizzate solo triple (From, To, Weight) corrispondenti a un @mention
 > - Verificare che sia possibile specificare il Channel e, nel caso sia specificato, la lista sia ristretta ai soli @mention del Channel

## 4. Architettura
L'applicativo utilizza lo stile architetturale "**Layered**" in cui ogni strato non ha conoscenza degli altri ma utilizza un API per richiamare una componente dello strato inferiore.

L'applicativo è diviso nei seguenti package :
![package](drawings/package.png)

Lista dei Componenti :
![Components](drawings/Components.svg)

La scelta dello stile "**Layered**" è stata adottata per integrare i principi SOLID e rendere ogni strato indipendente e non ridondante.

Ogni **package** contiene solo classi che rispettano le funzioni indicate dal nome.

Nel package **Data** sono inserite tutte le classi che modellano le componenti atomiche di Slack e la classe Counter che memorizza il numero di mentions effettuate da un determinato Member (From) ad un altro (To).
> Member , Channel , Mention e Counter

Nel package **Analysis** sono contenute la super classe Analysis e tutte le sue generalizzazioni.
> MembersAnalysis , ChannelsAnalysis e MentionsAnalysis.

Il package **Control** esegue i controlli sull'input utente attraverso le classi legate ai diversi requisiti specifici.

Il package **Util** contiene le classi che gestiscono l'input e l'output e alcune classi di supporto
> I/O : JSONReader , ZipReader e le classi che implementano l'interfaccia Printer

## 5 System Design
- In qualità di utente voglio visualizzare la lista dei **Member**
![membersList](drawings/membersList.svg)

![Sequence](drawings/membersListSequence.svg)
- In qualità di utente voglio visualizzare la lista dei **Channel**
![channelsList](drawings/channelsList.svg)

![Sequece](drawings/channelsListSequence.svg)
- In qualità di utente voglio visualizzare la lista dei **Member** raggruppati per **Channel**
![membersSorted](drawings/membersSorted.svg)

![membersSortedSequence](drawings/membersSortedSequence.svg)
- In qualità di utente voglio visualizzare la lista dei **Member** di un **Channel**
![membersChannel](drawings/membersChannel.svg)

![membersChannelSequence](drawings/membersChannelSequence.svg)
- In qualità di utente voglio visualizzare la lista dei **@mention**
![mentionsList](drawings/mentionsList.svg)

![mentionsListSequence](drawings/mentionsListSequence.svg)
- In qualità di utente voglio visualizzare la lista dei **@mention** che partono da uno **User**
![mentionsListFrom](drawings/mentionsFrom.svg)

![mentionsListFromSequence](drawings/mentionsListFromSequence.svg)
- In qualità di utente voglio visualizzare la lista dei **@mention** che arrivano a uno **User**
![mentionsListTo](drawings/mentionsTo.svg)

![mentionsListToSequence](drawings/mentionsListToSequence.svg)
- In qualità di utente voglio visualizzare la lista pesata dei **@mention**
![mentionsListWeighed](drawings/mentionsWeighed.svg)

![mentionsListWeighedSequence](drawings/mentionsListWeighedSequence.svg)
- In qualità di utente voglio visualizzare la lista pesata dei **@mention** che partono da uno **User**
![mentionsFromWeighed](drawings/mentionsFromWeighed.svg)

![mentionsListFromWeighedSequence](drawings/mentionsListFromWeighedSequence.svg)
- In qualità di utente voglio visualizzare la lista pesata dei **@mention** che arrivano a uno **User**
![mentionsToWeighed](drawings/mentionsToWeighed.svg)

![mentionsListToWeighedSequence](drawings/mentionsListToWeighedSequence.svg)
- In qualità di utente voglio poter avere informazioni di **Help**

![Help](drawings/Help.svg)

![HelpSequence](drawings/helpSequence.svg)
## 6 Riepilogo dei Test
Le seguenti immagini mostrano la copertura dei test e il numero di test
effettuati
![TestCoverage](drawings/coverageTest.png)
![TestNumber](drawings/numberTest.png)

## 7 Manuale Utente
Questa è la lista dei comandi eseguibili dall'utente

membersList zipPath
> Show members list in selected workspace with zipPath

channelsList zipPath
> Show channel list in selected workspace with zipPath

membersChannel channelName zipPath
> Show member list in selected channel in selected workspace with zipPath

membersSortedByChannel zipPath
> Show members sortedy by channel in selected workspace with zipPath

mentionsList zipPath
>Show mentions list in selected workspace with zipPath

mentionsListChannel channelName zipPath
> Show mentions list in selected channel in selected workspace with zipPath

mentionsListFrom member zipPath
> Show mentions list from selected member in selected workspace with zipPath

mentionsListFrom member channel zipPath
> Show mentions list from selected member in selected channel in selected workspace with zipPath

mentionsListTo member zipPath
> Show mentions list to selected member in selected channel in selected workspace with zipPath

mentionsListTo member channel zipPath
> Show mentions list to selected member in selected channel in selected workspace with zipPath

mentionsListWeighed zipPath
> Show mentions list weighed in selected workspace with zipPath

mentionsListChannelWeighed channel zipPath
> Show mentions list weighed in selected channel in selected workspace with zipPath

mentionsListFromWeighed member zipPath
> Show mentions list weighed from selected member in selected workspace with zipPath

mentionsListFromWeighed member channel zipPath
> Show mentions list weighed from selected member in selected channel in selected workspace with zipPath

mentionsListToWeighed member zipPath
>Show mentions list weighed to selected member in selected workspace with zipPath

mentionsListToWeighed member channel zipPath
> Show mentions list weighed to selected member in selected channel in selected workspace with zipPath

sna4slack
> Show this help interface

## 8. Processo di sviluppo e organizzazione del lavoro

 - Progettazione e Implementazione
 > Donato Leone e Giacomo Diaferio

 - Test e Revisione
 > Simone Cancellaro e Lorenzo Liberti

- Risoluzione problemi CheckStyle
> Donato Leone e Simone Cancellaro

- Risoluzione problemi PMD e FindBugs
> Donato Leone

- JUnit
> Donato Leone e Giacomo Diaferio

- Documentazione
> Simone Cancellaro e Lorenzo Liberti

Il lavoro è stato svolto attraverso una serie di Meeting Face to Face
## 9. Analisi Retrospettiva
- Cosa ha funzionato bene e rifarei in futuro
> Un ottimo team che ha diviso equamente i vari compiti durante i diversi Sprint
- Cosa non ha funzionato bene e non rifarei in futuro
> Consegna in largo anticipo
- Cosa farei di nuovo
> Se dovesse ripalesarsi la possibilità di poter collaborare con qualcuno, sarebbe piacevole grazie a questa esperienza lavorare nuovamente con gli stessi elementi del team BernersLee
