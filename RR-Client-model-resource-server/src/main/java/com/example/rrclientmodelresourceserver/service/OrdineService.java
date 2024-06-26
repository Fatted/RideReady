package com.example.rrclientmodelresourceserver.service;

import com.example.rrclientmodelresourceserver.model.OrdineEntity;

import com.example.rrclientmodelresourceserver.repository.AutomobileRepository;
import com.example.rrclientmodelresourceserver.repository.OrdineRepository;
import com.example.rrclientmodelresourceserver.repository.PrenotazioniRepository;
import com.example.rrclientmodelresourceserver.repository.UtenteRepository;
import com.example.rrclientmodelresourceserver.validation.ResourceNotFoundException;
import org.SwaggerCodeGenerator.model.Ordine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.rrclientmodelresourceserver.converter.OrdineConverter.convertToEntityOrdine;
import static com.example.rrclientmodelresourceserver.converter.OrdineConverter.convertToSwaggerSchemaOrdine;

@Service
public class OrdineService {

    @Autowired
    private OrdineRepository ordineRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private AutomobileRepository automobileRepository;

    @Autowired
    private PrenotazioniRepository prenotazioniRepository;

    private Logger logger = LoggerFactory.getLogger(OrdineService.class);

    public Ordine ordineAmministratoriAcquistoConfermaPost(Ordine ordine) {
        logger.info("ordineAmministratoriAcquistoConfermaPost-service");
        if(utenteRepository.findByCodicefiscale(ordine.getIdUtente()) == null) { //controllo se l'utente è presente nel database
            throw new ResourceNotFoundException("Utente non presente nel database"); //se non è presente lancio l'eccezione
        }

        if(automobileRepository.findById(ordine.getIdAutomobile()).isPresent()) { //controllo se l'automobile è presente nel database
            if(automobileRepository.findById(ordine.getIdAutomobile()).get().getQuantita() <= 0 || !automobileRepository.findById(ordine.getIdAutomobile()).get().getDisponibile()) { //controllo se l'automobile è disponibile
                throw new ResourceNotFoundException("Automobile non disponibile"); //se non è disponibile lancio l'eccezione
            }
            if (!automobileRepository.findById(ordine.getIdAutomobile()).get().getTipoDiDestinazione().equals("acquisto")) { //controllo se l'automobile è disponibile per l'acquisto
                throw new ResourceNotFoundException("Automobile non disponibile per l'acquisto"); //se non è disponibile per l'acquisto lancio l'eccezione
            }
        }else {
            throw new ResourceNotFoundException("Automobile non presente nel database"); //se non è presente lancio l'eccezione
        }


        if(prenotazioniRepository.findById((long) ordine.getIdPrenotazione().intValue()).isPresent()) { //controllo se la prenotazione è presente nel database
            if(!prenotazioniRepository.findById((long) ordine.getIdPrenotazione().intValue()).get().getStato().equals("accettata")) { //controllo se la prenotazione è stata accettata
                throw new ResourceNotFoundException("Prenotazione non accettata"); //se non è stata accettata lancio l'eccezione
            }
            if(!prenotazioniRepository.findById((long) ordine.getIdPrenotazione().intValue()).get().getTipo().equals("acquisto")) { //controllo se la prenotazione è destinata all'acquisto
                throw new ResourceNotFoundException("Prenotazione non destinata all'acquisto"); //se non è destinata all'acquisto lancio l'eccezione
            }
        }else {
            throw new ResourceNotFoundException("Prenotazione non presente nel database"); //se non è presente lancio l'eccezione
        }


        if(prenotazioniRepository.findById((long) ordine.getIdPrenotazione().intValue()).get().getIdAutomobile().getId() != ordine.getIdAutomobile().longValue()) { //controllo se l'automobile dell'ordine corrisponde alla prenotazione
            throw new ResourceNotFoundException("Automobile non corrispondente alla prenotazione"); //se non corrisponde lancio l'eccezione
        }

        OrdineEntity ordineEntity = convertToEntityOrdine(ordine); //converto l'ordine in un'entità
        ordineEntity.setIdAutomobile(automobileRepository.findById(ordine.getIdAutomobile()).get()); //setto l'automobile dell'ordine
        ordineEntity.setIdUtente(utenteRepository.findByCodicefiscale(ordine.getIdUtente())); //setto l'utente dell'ordine
        ordineEntity.setIdPrenotazione(prenotazioniRepository.findById(ordine.getIdPrenotazione().longValue()).get()); //setto la prenotazione dell'ordine
        ordineEntity.setTipo("acquisto");
        ordineRepository.save(ordineEntity); //salvo l'ordine

        automobileRepository.findById(ordine.getIdAutomobile()).get().setQuantita(automobileRepository.findById(ordine.getIdAutomobile()).get().getQuantita() - 1); //decremento la quantità dell'automobile
        if(automobileRepository.findById(ordine.getIdAutomobile()).get().getQuantita() == 0) { //controllo se la quantità è 0
            automobileRepository.findById(ordine.getIdAutomobile()).get().setDisponibile(false); //setto l'automobile come non disponibile
        }
        automobileRepository.save(automobileRepository.findById(ordine.getIdAutomobile()).get()); //salvo l'automobile
        return convertToSwaggerSchemaOrdine(ordineEntity); //converto l'entità in un'ordine
    }

    public Ordine ordineAmministratoriNoleggioConfermaPost(Ordine ordine) {
        logger.info("ordineAmministratoriNoleggioConfermaPost-service");
        if (utenteRepository.findByCodicefiscale(ordine.getIdUtente()) == null) { //controllo se l'utente è presente nel database
            throw new ResourceNotFoundException("Utente non presente nel database"); //se non è presente lancio l'eccezione
        }

        if (automobileRepository.findById(ordine.getIdAutomobile()).isPresent()) { //controllo se l'automobile è presente nel database
            if (automobileRepository.findById(ordine.getIdAutomobile()).get().getQuantita() <= 0 || !automobileRepository.findById(ordine.getIdAutomobile()).get().getDisponibile()) { //controllo se l'automobile è disponibile
                throw new ResourceNotFoundException("Automobile non disponibile"); //se non è disponibile lancio l'eccezione
            }
            if (!automobileRepository.findById(ordine.getIdAutomobile()).get().getTipoDiDestinazione().equals("noleggio")) { //controllo se l'automobile è disponibile per il noleggio
                throw new ResourceNotFoundException("Automobile non disponibile per il noleggio"); //se non è disponibile per il noleggio lancio l'eccezione
            }
        } else {
            throw new ResourceNotFoundException("Automobile non presente nel database"); //se non è presente lancio l'eccezione
        }

        if (prenotazioniRepository.findById((long) ordine.getIdPrenotazione().intValue()).isPresent()) { //controllo se la prenotazione è presente nel database
            if (!prenotazioniRepository.findById((long) ordine.getIdPrenotazione().intValue()).get().getStato().equals("accettata")) { //controllo se la prenotazione è stata accettata
                throw new ResourceNotFoundException("Prenotazione non accettata"); //se non è stata accettata lancio l'eccezione
            }
            if (!prenotazioniRepository.findById((long) ordine.getIdPrenotazione().intValue()).get().getTipo().equals("noleggio")) { //controllo se la prenotazione è destinata al noleggio
                throw new ResourceNotFoundException("Prenotazione non destinata al noleggio"); //se non è destinata al noleggio lancio l'eccezione
            }
        } else {
            throw new ResourceNotFoundException("Prenotazione non presente nel database"); //se non è presente lancio l'eccezione
        }


        if (prenotazioniRepository.findById((long) ordine.getIdPrenotazione().intValue()).get().getIdAutomobile().getId() != ordine.getIdAutomobile().longValue()) { //controllo se l'automobile dell'ordine corrisponde alla prenotazione
            throw new ResourceNotFoundException("Automobile non corrispondente alla prenotazione"); //se non corrisponde lancio l'eccezione
        }

        OrdineEntity ordineEntity = convertToEntityOrdine(ordine); //converto l'ordine in un'entità
        ordineEntity.setIdAutomobile(automobileRepository.findById(ordine.getIdAutomobile()).get());
        ordineEntity.setIdUtente(utenteRepository.findByCodicefiscale(ordine.getIdUtente()));
        ordineEntity.setIdPrenotazione(prenotazioniRepository.findById(ordine.getIdPrenotazione().longValue()).get());
        ordineEntity.setTipo("noleggio");
        ordineRepository.save(ordineEntity); //salvo l'ordine

        automobileRepository.findById(ordine.getIdAutomobile()).get().setQuantita(automobileRepository.findById(ordine.getIdAutomobile()).get().getQuantita() - 1); //decremento la quantità dell'automobile
        if (automobileRepository.findById(ordine.getIdAutomobile()).get().getQuantita() == 0) { //controllo se la quantità è 0
            automobileRepository.findById(ordine.getIdAutomobile()).get().setDisponibile(false); //setto l'automobile come non disponibile
        }
        automobileRepository.save(automobileRepository.findById(ordine.getIdAutomobile()).get()); //salvo l'automobile
        return convertToSwaggerSchemaOrdine(ordineEntity); //converto l'entità in un'ordine
    }
}
