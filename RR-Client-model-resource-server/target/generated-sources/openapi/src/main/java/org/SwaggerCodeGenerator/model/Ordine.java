package org.SwaggerCodeGenerator.model;

import java.net.URI;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.time.LocalDate;
import java.util.Objects;
import com.example.rrclientmodelresourceserver.validation.customvalidator.CodiceFiscale;
import com.example.rrclientmodelresourceserver.validation.customvalidator.DataFormato;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.constraints.*;


import java.util.*;
import javax.annotation.Generated;

/**
 * Ordine
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-21T18:10:10.437692200+02:00[Europe/Rome]")
public class Ordine {

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("id_prenotazione")
  @NotNull
  @Min(value = 1L, message = "id_prenotazione deve essere maggiore di 1")
  private Integer idPrenotazione;

  @JsonProperty("id_utente")
  @CodiceFiscale
  private String idUtente;

  @JsonProperty("id_automobile")
  @Min(value = 1L, message = "id_automobile deve essere maggiore di 1")
  private Integer idAutomobile;

  @JsonProperty("tipo")
  @NotBlank(message = "Il campo tipo non può essere vuoto")
  @Pattern(regexp = "^(noleggio|acquisto)$", message = "Il campo tipo può essere solo 'noleggio' o 'acquisto'")
  private String tipo;

  @JsonProperty("data_acquisto_automobile")
  @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate dataAcquistoAutomobile;

  @JsonProperty("data_noleggio_inizio")
  @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate dataNoleggioInizio;

  @JsonProperty("data_noleggio_fine")
  @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate dataNoleggioFine;

  @JsonProperty("prezzo_acquisto_auto_ordine")
  private BigDecimal prezzoAcquistoAutoOrdine;

  @JsonProperty("prezzo_noleggio_giornaliero_ordine")
  private BigDecimal prezzoNoleggioGiornalieroOrdine;

  public Ordine id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * id dell'ordine
   * @return id
  */
  
  @Schema(name = "id", description = "id dell'ordine", required = false)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Ordine idPrenotazione(Integer idPrenotazione) {
    this.idPrenotazione = idPrenotazione;
    return this;
  }

  /**
   * id della prenotazione
   * @return idPrenotazione
  */
  
  @Schema(name = "id_prenotazione", description = "id della prenotazione", required = false)
  public Integer getIdPrenotazione() {
    return idPrenotazione;
  }

  public void setIdPrenotazione(Integer idPrenotazione) {
    this.idPrenotazione = idPrenotazione;
  }

  public Ordine idUtente(String idUtente) {
    this.idUtente = idUtente;
    return this;
  }

  /**
   * id associato all'utente che ha completato l'ordine (ricavabile dalla prenotazione)
   * @return idUtente
  */
  
  @Schema(name = "id_utente", description = "id associato all'utente che ha completato l'ordine (ricavabile dalla prenotazione)", required = false)
  public String getIdUtente() {
    return idUtente;
  }

  public void setIdUtente(String idUtente) {
    this.idUtente = idUtente;
  }

  public Ordine idAutomobile(Integer idAutomobile) {
    this.idAutomobile = idAutomobile;
    return this;
  }

  /**
   * id dell'automobile associata (ricavabile dalla prenotazione)
   * @return idAutomobile
  */
  
  @Schema(name = "id_automobile", description = "id dell'automobile associata (ricavabile dalla prenotazione)", required = false)
  public Integer getIdAutomobile() {
    return idAutomobile;
  }

  public void setIdAutomobile(Integer idAutomobile) {
    this.idAutomobile = idAutomobile;
  }

  public Ordine tipo(String tipo) {
    this.tipo = tipo;
    return this;
  }

  /**
   * tipo dell'ordine (ricavabile dalla prenotazione)
   * @return tipo
  */
  
  @Schema(name = "tipo", description = "tipo dell'ordine (ricavabile dalla prenotazione)", required = false)
  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public Ordine dataAcquistoAutomobile(LocalDate dataAcquistoAutomobile) {
    this.dataAcquistoAutomobile = dataAcquistoAutomobile;
    return this;
  }

  /**
   * data in cui l'auto è stata acquistata
   * @return dataAcquistoAutomobile
  */
  @Valid 
  @Schema(name = "data_acquisto_automobile", description = "data in cui l'auto è stata acquistata", required = false)
  public LocalDate getDataAcquistoAutomobile() {
    return dataAcquistoAutomobile;
  }

  public void setDataAcquistoAutomobile(LocalDate dataAcquistoAutomobile) {
    this.dataAcquistoAutomobile = dataAcquistoAutomobile;
  }

  public Ordine dataNoleggioInizio(LocalDate dataNoleggioInizio) {
    this.dataNoleggioInizio = dataNoleggioInizio;
    return this;
  }

  /**
   * data in cui l'auto è stata noleggiata iniziale
   * @return dataNoleggioInizio
  */
  @Valid 
  @Schema(name = "data_noleggio_inizio", description = "data in cui l'auto è stata noleggiata iniziale", required = false)
  public LocalDate getDataNoleggioInizio() {
    return dataNoleggioInizio;
  }

  public void setDataNoleggioInizio(LocalDate dataNoleggioInizio) {
    this.dataNoleggioInizio = dataNoleggioInizio;
  }

  public Ordine dataNoleggioFine(LocalDate dataNoleggioFine) {
    this.dataNoleggioFine = dataNoleggioFine;
    return this;
  }

  /**
   * data in cui l'auto è da consegnare al termine del noleggio
   * @return dataNoleggioFine
  */
  @Valid 
  @Schema(name = "data_noleggio_fine", description = "data in cui l'auto è da consegnare al termine del noleggio", required = false)
  public LocalDate getDataNoleggioFine() {
    return dataNoleggioFine;
  }

  public void setDataNoleggioFine(LocalDate dataNoleggioFine) {
    this.dataNoleggioFine = dataNoleggioFine;
  }

  public Ordine prezzoAcquistoAutoOrdine(BigDecimal prezzoAcquistoAutoOrdine) {
    this.prezzoAcquistoAutoOrdine = prezzoAcquistoAutoOrdine;
    return this;
  }

  /**
   * prezzo dell'auto acquistata
   * @return prezzoAcquistoAutoOrdine
  */
  @Valid 
  @Schema(name = "prezzo_acquisto_auto_ordine", description = "prezzo dell'auto acquistata", required = false)
  public BigDecimal getPrezzoAcquistoAutoOrdine() {
    return prezzoAcquistoAutoOrdine;
  }

  public void setPrezzoAcquistoAutoOrdine(BigDecimal prezzoAcquistoAutoOrdine) {
    this.prezzoAcquistoAutoOrdine = prezzoAcquistoAutoOrdine;
  }

  public Ordine prezzoNoleggioGiornalieroOrdine(BigDecimal prezzoNoleggioGiornalieroOrdine) {
    this.prezzoNoleggioGiornalieroOrdine = prezzoNoleggioGiornalieroOrdine;
    return this;
  }

  /**
   * prezzo dell'auto noleggiata
   * @return prezzoNoleggioGiornalieroOrdine
  */
  @Valid 
  @Schema(name = "prezzo_noleggio_giornaliero_ordine", description = "prezzo dell'auto noleggiata", required = false)
  public BigDecimal getPrezzoNoleggioGiornalieroOrdine() {
    return prezzoNoleggioGiornalieroOrdine;
  }

  public void setPrezzoNoleggioGiornalieroOrdine(BigDecimal prezzoNoleggioGiornalieroOrdine) {
    this.prezzoNoleggioGiornalieroOrdine = prezzoNoleggioGiornalieroOrdine;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Ordine ordine = (Ordine) o;
    return Objects.equals(this.id, ordine.id) &&
        Objects.equals(this.idPrenotazione, ordine.idPrenotazione) &&
        Objects.equals(this.idUtente, ordine.idUtente) &&
        Objects.equals(this.idAutomobile, ordine.idAutomobile) &&
        Objects.equals(this.tipo, ordine.tipo) &&
        Objects.equals(this.dataAcquistoAutomobile, ordine.dataAcquistoAutomobile) &&
        Objects.equals(this.dataNoleggioInizio, ordine.dataNoleggioInizio) &&
        Objects.equals(this.dataNoleggioFine, ordine.dataNoleggioFine) &&
        Objects.equals(this.prezzoAcquistoAutoOrdine, ordine.prezzoAcquistoAutoOrdine) &&
        Objects.equals(this.prezzoNoleggioGiornalieroOrdine, ordine.prezzoNoleggioGiornalieroOrdine);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, idPrenotazione, idUtente, idAutomobile, tipo, dataAcquistoAutomobile, dataNoleggioInizio, dataNoleggioFine, prezzoAcquistoAutoOrdine, prezzoNoleggioGiornalieroOrdine);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Ordine {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    idPrenotazione: ").append(toIndentedString(idPrenotazione)).append("\n");
    sb.append("    idUtente: ").append(toIndentedString(idUtente)).append("\n");
    sb.append("    idAutomobile: ").append(toIndentedString(idAutomobile)).append("\n");
    sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
    sb.append("    dataAcquistoAutomobile: ").append(toIndentedString(dataAcquistoAutomobile)).append("\n");
    sb.append("    dataNoleggioInizio: ").append(toIndentedString(dataNoleggioInizio)).append("\n");
    sb.append("    dataNoleggioFine: ").append(toIndentedString(dataNoleggioFine)).append("\n");
    sb.append("    prezzoAcquistoAutoOrdine: ").append(toIndentedString(prezzoAcquistoAutoOrdine)).append("\n");
    sb.append("    prezzoNoleggioGiornalieroOrdine: ").append(toIndentedString(prezzoNoleggioGiornalieroOrdine)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

