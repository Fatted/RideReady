package org.SwaggerCodeGenerator.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.math.BigDecimal;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Automobile
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-17T12:34:11.812074600+02:00[Europe/Rome]")
public class Automobile {

  @JsonProperty("id")
  private BigDecimal id;

  @JsonProperty("marca")
  private String marca;

  @JsonProperty("modello")
  private String modello;

  @JsonProperty("prezzo_acquisto")
  private BigDecimal prezzoAcquisto;

  @JsonProperty("prezzo_noleggio_giornaliero")
  private BigDecimal prezzoNoleggioGiornaliero;

  @JsonProperty("disponibile")
  private Boolean disponibile;

  @JsonProperty("quantita")
  private BigDecimal quantita;

  @JsonProperty("cavalli")
  private BigDecimal cavalli;

  @JsonProperty("cilindrata")
  private BigDecimal cilindrata;

  @JsonProperty("posti_a_sedere")
  private BigDecimal postiASedere;

  @JsonProperty("carburante")
  private String carburante;

  @JsonProperty("targa")
  private String targa;

  @JsonProperty("tipo_di_destinazione")
  private String tipoDiDestinazione;

  public Automobile id(BigDecimal id) {
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

  public Automobile marca(String marca) {
    this.marca = marca;
    return this;
  }

  /**
   * marca dell'automobile
   * @return marca
  */
  
  @Schema(name = "marca", description = "marca dell'automobile", required = false)
  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public Automobile modello(String modello) {
    this.modello = modello;
    return this;
  }

  /**
   * modello dell'automobile
   * @return modello
  */
  
  @Schema(name = "modello", description = "modello dell'automobile", required = false)
  public String getModello() {
    return modello;
  }

  public void setModello(String modello) {
    this.modello = modello;
  }

  public Automobile prezzoAcquisto(BigDecimal prezzoAcquisto) {
    this.prezzoAcquisto = prezzoAcquisto;
    return this;
  }

  /**
   * prezzo dell'automobile in acquisto
   * @return prezzoAcquisto
  */
  @Valid 
  @Schema(name = "prezzo_acquisto", description = "prezzo dell'automobile in acquisto", required = false)
  public BigDecimal getPrezzoAcquisto() {
    return prezzoAcquisto;
  }

  public void setPrezzoAcquisto(BigDecimal prezzoAcquisto) {
    this.prezzoAcquisto = prezzoAcquisto;
  }

  public Automobile prezzoNoleggioGiornaliero(BigDecimal prezzoNoleggioGiornaliero) {
    this.prezzoNoleggioGiornaliero = prezzoNoleggioGiornaliero;
    return this;
  }

  /**
   * prezzo dell'automobile in noleggio
   * @return prezzoNoleggioGiornaliero
  */
  @Valid 
  @Schema(name = "prezzo_noleggio_giornaliero", description = "prezzo dell'automobile in noleggio", required = false)
  public BigDecimal getPrezzoNoleggioGiornaliero() {
    return prezzoNoleggioGiornaliero;
  }

  public void setPrezzoNoleggioGiornaliero(BigDecimal prezzoNoleggioGiornaliero) {
    this.prezzoNoleggioGiornaliero = prezzoNoleggioGiornaliero;
  }

  public Automobile disponibile(Boolean disponibile) {
    this.disponibile = disponibile;
    return this;
  }

  /**
   * disponibilità dell'automobile
   * @return disponibile
  */
  
  @Schema(name = "disponibile", description = "disponibilità dell'automobile", required = false)
  public Boolean getDisponibile() {
    return disponibile;
  }

  public void setDisponibile(Boolean disponibile) {
    this.disponibile = disponibile;
  }

  public Automobile quantita(BigDecimal quantita) {
    this.quantita = quantita;
    return this;
  }

  /**
   * quantità dell'automobile disponibile
   * @return quantita
  */
  @Valid 
  @Schema(name = "quantita", description = "quantità dell'automobile disponibile", required = false)
  public BigDecimal getQuantita() {
    return quantita;
  }

  public void setQuantita(BigDecimal quantita) {
    this.quantita = quantita;
  }

  public Automobile cavalli(BigDecimal cavalli) {
    this.cavalli = cavalli;
    return this;
  }

  /**
   * cavalli dell'automobile
   * @return cavalli
  */
  @Valid 
  @Schema(name = "cavalli", description = "cavalli dell'automobile", required = false)
  public BigDecimal getCavalli() {
    return cavalli;
  }

  public void setCavalli(BigDecimal cavalli) {
    this.cavalli = cavalli;
  }

  public Automobile cilindrata(BigDecimal cilindrata) {
    this.cilindrata = cilindrata;
    return this;
  }

  /**
   * cilindrata dell'automobile
   * @return cilindrata
  */
  @Valid 
  @Schema(name = "cilindrata", description = "cilindrata dell'automobile", required = false)
  public BigDecimal getCilindrata() {
    return cilindrata;
  }

  public void setCilindrata(BigDecimal cilindrata) {
    this.cilindrata = cilindrata;
  }

  public Automobile postiASedere(BigDecimal postiASedere) {
    this.postiASedere = postiASedere;
    return this;
  }

  /**
   * posti a sedere dell'automobile
   * @return postiASedere
  */
  @Valid 
  @Schema(name = "posti_a_sedere", description = "posti a sedere dell'automobile", required = false)
  public BigDecimal getPostiASedere() {
    return postiASedere;
  }

  public void setPostiASedere(BigDecimal postiASedere) {
    this.postiASedere = postiASedere;
  }

  public Automobile carburante(String carburante) {
    this.carburante = carburante;
    return this;
  }

  /**
   * carburante dell'automobile
   * @return carburante
  */
  
  @Schema(name = "carburante", description = "carburante dell'automobile", required = false)
  public String getCarburante() {
    return carburante;
  }

  public void setCarburante(String carburante) {
    this.carburante = carburante;
  }

  public Automobile targa(String targa) {
    this.targa = targa;
    return this;
  }

  /**
   * targa dell'automobile
   * @return targa
  */
  
  @Schema(name = "targa", description = "targa dell'automobile", required = false)
  public String getTarga() {
    return targa;
  }

  public void setTarga(String targa) {
    this.targa = targa;
  }

  public Automobile tipoDiDestinazione(String tipoDiDestinazione) {
    this.tipoDiDestinazione = tipoDiDestinazione;
    return this;
  }

  /**
   * tipo di destinazione dell'automobile
   * @return tipoDiDestinazione
  */
  
  @Schema(name = "tipo_di_destinazione", description = "tipo di destinazione dell'automobile", required = false)
  public String getTipoDiDestinazione() {
    return tipoDiDestinazione;
  }

  public void setTipoDiDestinazione(String tipoDiDestinazione) {
    this.tipoDiDestinazione = tipoDiDestinazione;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Automobile automobile = (Automobile) o;
    return Objects.equals(this.id, automobile.id) &&
        Objects.equals(this.marca, automobile.marca) &&
        Objects.equals(this.modello, automobile.modello) &&
        Objects.equals(this.prezzoAcquisto, automobile.prezzoAcquisto) &&
        Objects.equals(this.prezzoNoleggioGiornaliero, automobile.prezzoNoleggioGiornaliero) &&
        Objects.equals(this.disponibile, automobile.disponibile) &&
        Objects.equals(this.quantita, automobile.quantita) &&
        Objects.equals(this.cavalli, automobile.cavalli) &&
        Objects.equals(this.cilindrata, automobile.cilindrata) &&
        Objects.equals(this.postiASedere, automobile.postiASedere) &&
        Objects.equals(this.carburante, automobile.carburante) &&
        Objects.equals(this.targa, automobile.targa) &&
        Objects.equals(this.tipoDiDestinazione, automobile.tipoDiDestinazione);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, marca, modello, prezzoAcquisto, prezzoNoleggioGiornaliero, disponibile, quantita, cavalli, cilindrata, postiASedere, carburante, targa, tipoDiDestinazione);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Automobile {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    marca: ").append(toIndentedString(marca)).append("\n");
    sb.append("    modello: ").append(toIndentedString(modello)).append("\n");
    sb.append("    prezzoAcquisto: ").append(toIndentedString(prezzoAcquisto)).append("\n");
    sb.append("    prezzoNoleggioGiornaliero: ").append(toIndentedString(prezzoNoleggioGiornaliero)).append("\n");
    sb.append("    disponibile: ").append(toIndentedString(disponibile)).append("\n");
    sb.append("    quantita: ").append(toIndentedString(quantita)).append("\n");
    sb.append("    cavalli: ").append(toIndentedString(cavalli)).append("\n");
    sb.append("    cilindrata: ").append(toIndentedString(cilindrata)).append("\n");
    sb.append("    postiASedere: ").append(toIndentedString(postiASedere)).append("\n");
    sb.append("    carburante: ").append(toIndentedString(carburante)).append("\n");
    sb.append("    targa: ").append(toIndentedString(targa)).append("\n");
    sb.append("    tipoDiDestinazione: ").append(toIndentedString(tipoDiDestinazione)).append("\n");
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

