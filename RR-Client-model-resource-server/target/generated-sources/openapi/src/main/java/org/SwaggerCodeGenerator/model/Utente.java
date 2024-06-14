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
 * Dettagli dell&#39;utente
 */

@Schema(name = "Utente", description = "Dettagli dell'utente")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-14T18:47:49.701084700+02:00[Europe/Rome]")
public class Utente {

  @JsonProperty("id")
  private BigDecimal id;

  @JsonProperty("codicefiscale")
  private String codicefiscale;

  public Utente id(BigDecimal id) {
    this.id = id;
    return this;
  }

  /**
   * ID dell'utente
   * @return id
  */
  @Valid 
  @Schema(name = "id", description = "ID dell'utente", required = false)
  public BigDecimal getId() {
    return id;
  }

  public void setId(BigDecimal id) {
    this.id = id;
  }

  public Utente codicefiscale(String codicefiscale) {
    this.codicefiscale = codicefiscale;
    return this;
  }

  /**
   * codice fiscale dell'utente
   * @return codicefiscale
  */
  
  @Schema(name = "codicefiscale", description = "codice fiscale dell'utente", required = false)
  public String getCodicefiscale() {
    return codicefiscale;
  }

  public void setCodicefiscale(String codicefiscale) {
    this.codicefiscale = codicefiscale;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Utente utente = (Utente) o;
    return Objects.equals(this.id, utente.id) &&
        Objects.equals(this.codicefiscale, utente.codicefiscale);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, codicefiscale);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Utente {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    codicefiscale: ").append(toIndentedString(codicefiscale)).append("\n");
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

