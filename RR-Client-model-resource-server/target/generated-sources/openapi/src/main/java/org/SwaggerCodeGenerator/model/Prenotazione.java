package org.SwaggerCodeGenerator.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Prenotazione
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-19T12:30:19.977507800+02:00[Europe/Rome]")
public class Prenotazione {

  @JsonProperty("id")
  private BigDecimal id;

  @JsonProperty("id_automobile")
  private BigDecimal idAutomobile;

  @JsonProperty("id_utente")
  private String idUtente;

  @JsonProperty("tipo")
  private String tipo;

  @JsonProperty("data_prenotazione")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime dataPrenotazione;

  @JsonProperty("stato")
  private String stato;

  public Prenotazione id(BigDecimal id) {
    this.id = id;
    return this;
  }

  /**
   * ID dell'automobile
   * @return id
  */
  @Valid 
  @Schema(name = "id", description = "ID dell'automobile", required = false)
  public BigDecimal getId() {
    return id;
  }

  public void setId(BigDecimal id) {
    this.id = id;
  }

  public Prenotazione idAutomobile(BigDecimal idAutomobile) {
    this.idAutomobile = idAutomobile;
    return this;
  }

  /**
   * ID dell'automobile
   * @return idAutomobile
  */
  @Valid 
  @Schema(name = "id_automobile", description = "ID dell'automobile", required = false)
  public BigDecimal getIdAutomobile() {
    return idAutomobile;
  }

  public void setIdAutomobile(BigDecimal idAutomobile) {
    this.idAutomobile = idAutomobile;
  }

  public Prenotazione idUtente(String idUtente) {
    this.idUtente = idUtente;
    return this;
  }

  /**
   * ID dell'utente
   * @return idUtente
  */
  
  @Schema(name = "id_utente", description = "ID dell'utente", required = false)
  public String getIdUtente() {
    return idUtente;
  }

  public void setIdUtente(String idUtente) {
    this.idUtente = idUtente;
  }

  public Prenotazione tipo(String tipo) {
    this.tipo = tipo;
    return this;
  }

  /**
   * il tipo della prenotazione noleggio/acquisto
   * @return tipo
  */
  
  @Schema(name = "tipo", description = "il tipo della prenotazione noleggio/acquisto", required = false)
  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public Prenotazione dataPrenotazione(OffsetDateTime dataPrenotazione) {
    this.dataPrenotazione = dataPrenotazione;
    return this;
  }

  /**
   * Data della richiesta di acquisto
   * @return dataPrenotazione
  */
  @Valid 
  @Schema(name = "data_prenotazione", description = "Data della richiesta di acquisto", required = false)
  public OffsetDateTime getDataPrenotazione() {
    return dataPrenotazione;
  }

  public void setDataPrenotazione(OffsetDateTime dataPrenotazione) {
    this.dataPrenotazione = dataPrenotazione;
  }

  public Prenotazione stato(String stato) {
    this.stato = stato;
    return this;
  }

  /**
   * stato della prenotazione che può essere emessa/accetata/rifiutata
   * @return stato
  */
  
  @Schema(name = "stato", description = "stato della prenotazione che può essere emessa/accetata/rifiutata", required = false)
  public String getStato() {
    return stato;
  }

  public void setStato(String stato) {
    this.stato = stato;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Prenotazione prenotazione = (Prenotazione) o;
    return Objects.equals(this.id, prenotazione.id) &&
        Objects.equals(this.idAutomobile, prenotazione.idAutomobile) &&
        Objects.equals(this.idUtente, prenotazione.idUtente) &&
        Objects.equals(this.tipo, prenotazione.tipo) &&
        Objects.equals(this.dataPrenotazione, prenotazione.dataPrenotazione) &&
        Objects.equals(this.stato, prenotazione.stato);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, idAutomobile, idUtente, tipo, dataPrenotazione, stato);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Prenotazione {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    idAutomobile: ").append(toIndentedString(idAutomobile)).append("\n");
    sb.append("    idUtente: ").append(toIndentedString(idUtente)).append("\n");
    sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
    sb.append("    dataPrenotazione: ").append(toIndentedString(dataPrenotazione)).append("\n");
    sb.append("    stato: ").append(toIndentedString(stato)).append("\n");
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

