package com.example.rrclientmodelresourceserver.service;

import com.example.rrclientmodelresourceserver.repository.AutomobileRepository;
import com.example.rrclientmodelresourceserver.DTO.AutomobileDTO;
import com.example.rrclientmodelresourceserver.model.AutomobileEntity;
import org.SwaggerCodeGenerator.model.Automobile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AutomobileService {

    @Autowired
    private AutomobileRepository automobileRepository;

    public AutomobileDTO veicoliIdGet(Integer id){
        AutomobileEntity automobileEntity = automobileRepository.findById(id).orElse(null);
        assert automobileEntity != null;
        return convertToDTO(automobileEntity);
    }

    public void veicoliAmministratoriInserimentoPost(Automobile automobile){
        AutomobileDTO automobileDTO = convertToDTO(automobile);
        automobileRepository.save(convertToEntity(automobileDTO));
    }

    public AutomobileDTO convertToDTO(Automobile automobile){
        return new AutomobileDTO(
                automobile.getId().intValue(),
                automobile.getMarca(),
                automobile.getModello(),
                new BigDecimal(automobile.getPrezzoAcquisto().doubleValue()),
                new BigDecimal(automobile.getPrezzoNoleggioGiornaliero().doubleValue()),
                automobile.getDisponibile(),
                automobile.getQuantita().intValue(),
                automobile.getCavalli().intValue(),
                automobile.getCilindrata().doubleValue(),
                automobile.getPostiASedere().intValue(),
                automobile.getCarburante(),
                automobile.getTarga(),
                automobile.getTipoDiDestinazione(),
                null,
                null
        );
    }

    public AutomobileDTO convertToDTO(AutomobileEntity automobileEntity) {
        return new AutomobileDTO(
                automobileEntity.getId(),
                automobileEntity.getMarca(),
                automobileEntity.getModello(),
                new BigDecimal(automobileEntity.getPrezzoAcquisto()),
                new BigDecimal(automobileEntity.getPrezzoNoleggioGiornaliero()),
                automobileEntity.getDisponibile(),
                automobileEntity.getQuantita(),
                automobileEntity.getCavalli(),
                automobileEntity.getCilindrata(),
                automobileEntity.getPostiASedere(),
                automobileEntity.getCarburante(),
                automobileEntity.getTarga(),
                automobileEntity.getTipoDiDestinazione(),
                automobileEntity.getOrdines(),
                automobileEntity.getPrenotaziones()
        );
    }


    public Automobile convertToSwaggerSchema(AutomobileDTO automobileDTO) {
        Automobile automobile = new Automobile();
        automobile.setId(BigDecimal.valueOf(automobileDTO.getId()));
        automobile.setMarca(automobileDTO.getMarca());
        automobile.setModello(automobileDTO.getModello());
        automobile.setPrezzoAcquisto(BigDecimal.valueOf(automobileDTO.getPrezzoAcquisto()));
        automobile.setPrezzoNoleggioGiornaliero(BigDecimal.valueOf(automobileDTO.getPrezzoNoleggioGiornaliero()));
        automobile.setDisponibile(automobileDTO.getDisponibile());
        automobile.setQuantita(BigDecimal.valueOf(automobileDTO.getQuantita()));
        automobile.setCavalli(BigDecimal.valueOf(automobileDTO.getCavalli()));
        automobile.setCilindrata(BigDecimal.valueOf(automobileDTO.getCilindrata()));
        automobile.setPostiASedere(BigDecimal.valueOf(automobileDTO.getPostiASedere()));
        automobile.setCarburante(automobileDTO.getCarburante());
        automobile.setTarga(automobileDTO.getTarga());
        automobile.setTipoDiDestinazione(automobileDTO.getTipoDiDestinazione());
        return automobile;
    }

    public AutomobileEntity convertToEntity(AutomobileDTO automobileDTO) {
        AutomobileEntity automobileEntity = new AutomobileEntity();
        automobileEntity.setId(automobileDTO.getId());
        automobileEntity.setMarca(automobileDTO.getMarca());
        automobileEntity.setModello(automobileDTO.getModello());
        automobileEntity.setPrezzoAcquisto(automobileDTO.getPrezzoAcquisto());
        automobileEntity.setPrezzoNoleggioGiornaliero(automobileDTO.getPrezzoNoleggioGiornaliero());
        automobileEntity.setDisponibile(automobileDTO.getDisponibile());
        automobileEntity.setQuantita(automobileDTO.getQuantita());
        automobileEntity.setCavalli(automobileDTO.getCavalli());
        automobileEntity.setCilindrata(automobileDTO.getCilindrata());
        automobileEntity.setPostiASedere(automobileDTO.getPostiASedere());
        automobileEntity.setCarburante(automobileDTO.getCarburante());
        automobileEntity.setTarga(automobileDTO.getTarga());
        automobileEntity.setTipoDiDestinazione(automobileDTO.getTipoDiDestinazione());
        return automobileEntity;
    }

}