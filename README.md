# RideReady

![Logo1-removebg-preview](https://github.com/Fatted/RideReady/assets/83971069/eb8f3bfc-4ccc-4fab-bb55-50b7c14546f4)


# Indice

-   [Prerequisiti](#prerequisiti)
-   [Installazione](#installazione)
-   [Test di utilizzo](#utilizzo)

# Prerequisiti

-   MySQL v8.0.35
-   Intellij IDEA 2024 
-   Maven 3.3.0
-   Postman

# Installazione
1.Apri intellij IDEA.
<img width="960" alt="1" src="https://github.com/Fatted/RideReady/assets/83971069/7286c7ab-ce96-4b9d-9aee-ca6338ea28cb">

2.Clona questa repository su intellij IDEA tramite "get from VCS" incollando : https://github.com/Fatted/RideReady.git
<img width="960" alt="2" src="https://github.com/Fatted/RideReady/assets/83971069/86184e70-41bc-4340-8511-bcd773f8dd18">

3.Attendi che la clonazione sia completata.
<img width="789" alt="3" src="https://github.com/Fatted/RideReady/assets/83971069/faa6dbb0-3627-451d-8df1-480e2d7f8972">

4.Al termine della clozaione otterrà questo risultato con tutti i moduli pronti ad essere buildati da Maven
<img width="905" alt="4" src="https://github.com/Fatted/RideReady/assets/83971069/ade01b50-e383-4276-8a38-7b7509278080">

5.Esegui la build tramite maven premendo su "load".                                            
<img width="265" alt="5" src="https://github.com/Fatted/RideReady/assets/83971069/e36aadf3-9514-4da0-902e-e640d030680d">

6.Terminata la build di maven otterrai questo risultato,dove i moduli sono pronti ad essere eseguiti.
<img width="294" alt="6" src="https://github.com/Fatted/RideReady/assets/83971069/51bec542-bf73-42e6-885b-199f1622767f">

7.Esegui i moduli, e appena saranno avviati sarà possibile visualizzare nel service il loro stato di esecuzione e le porte associate.
<img width="936" alt="7" src="https://github.com/Fatted/RideReady/assets/83971069/9c0af428-b557-4412-ae97-99f62c59c2df">

8.Apri Poatman
<img width="960" alt="8" src="https://github.com/Fatted/RideReady/assets/83971069/6857ce02-dd7d-4740-849f-95c4c287ea3f">

9.Seleziona su import, vicino my workspace                            
<img width="285" alt="9" src="https://github.com/Fatted/RideReady/assets/83971069/f34becdf-ca8a-4fb2-8ac1-f844fa3be386">

10.Selezionate le collezioni da importare
<img width="959" alt="10" src="https://github.com/Fatted/RideReady/assets/83971069/00b316e3-39c6-4d09-b511-74976d1814c1">

11.Dopo la selezione verrannò mostrate le collezioni che verranno importate
<img width="514" alt="11" src="https://github.com/Fatted/RideReady/assets/83971069/20b730ae-9d6d-4241-8ff5-a2159b36073c">

12.Completata l'importazione potrete viualizzare le collezioni                        
<img width="276" alt="12" src="https://github.com/Fatted/RideReady/assets/83971069/e12e074e-7fd7-401a-b998-7fd7a445e60b">

13.Aprite WorkBench MySQL
<img width="960" alt="13" src="https://github.com/Fatted/RideReady/assets/83971069/15c91bd4-1caf-4141-89d6-796f0d2310f7">

14.Incollate il bump da eseguire ed eseguitelo
<img width="575" alt="14" src="https://github.com/Fatted/RideReady/assets/83971069/98910b72-d7b5-4c2b-9325-39ae698b725b">

15.Dopo l'esecuzione otterete il DB                      
<img width="187" alt="15" src="https://github.com/Fatted/RideReady/assets/83971069/d24255ff-dd79-4ed0-841f-284e4fc2c7e6">

Completate tutte le operazioni avrete settato tutti gli ambienti per l'utilizzo del sistema.

# Utilizzo
Questo è un esempio di utilizzo del sistema. Genereremo un token con il ruolo del cliente e atraverso una richiesta http all'endpoit /veicoli/{id} cercheremo un veicolo con l'id corrispondente. Il token generato verrà utilizzato come autorizzazione per accedere alla risorsa.

1.Genera il token con il ruolo utente
<img width="920" alt="16" src="https://github.com/Fatted/RideReady/assets/83971069/a5fc23af-490e-45ea-b278-9e28840cc41f">

2.Ottento il token salvalo
<img width="665" alt="17" src="https://github.com/Fatted/RideReady/assets/83971069/d6dfcc6f-fc0a-4755-8c61-9914332206e8">

3.Effettua la richiesta alla risorsa veicolo usando il token come autorizzazione per l'accesso a quest'ultima
<img width="929" alt="18" src="https://github.com/Fatted/RideReady/assets/83971069/9bd0464b-3652-472b-a583-a536e41ca0c5">

4.Ottieni come risposta dal Resource Server la risorca cercata
<img width="636" alt="19" src="https://github.com/Fatted/RideReady/assets/83971069/f85bab88-6ae0-4de2-a4d4-e99dcc5b89e5">


