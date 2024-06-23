/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.0.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.SwaggerCodeGenerator.api;

import org.SwaggerCodeGenerator.model.Ordine;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-21T18:10:10.437692200+02:00[Europe/Rome]")
@Validated
@Tag(name = "ordine", description = "the ordine API")
public interface OrdineApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /ordine/amministratori-acquisto/conferma : Inserimento un ordine di vendita
     * Permette all&#39;amministratore acquisto di inserire un ordine di vendita una volta confermata una prenotazione e confermata la vendita
     *
     * @param ordine  (required)
     * @return Ordine inserito con successo (status code 200)
     *         or Errore nell&#39;inserimento dell&#39;ordine (status code 400)
     *         or Non autorizzato ad inserire l&#39;ordine (status code 401)
     */
    @Operation(
        operationId = "ordineAmministratoriAcquistoConfermaPost",
        summary = "Inserimento un ordine di vendita",
        tags = { "Gestione Vendita [Amministratore-Acquisto]" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Ordine inserito con successo", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Ordine.class))
            }),
            @ApiResponse(responseCode = "400", description = "Errore nell'inserimento dell'ordine"),
            @ApiResponse(responseCode = "401", description = "Non autorizzato ad inserire l'ordine")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/ordine/amministratori-acquisto/conferma",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Ordine> ordineAmministratoriAcquistoConfermaPost(
        @Parameter(name = "Ordine", description = "", required = true) @Valid @RequestBody Ordine ordine
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"prezzo_noleggio_giornaliero_ordine\" : 5.637376656633329, \"tipo\" : \"tipo\", \"id_automobile\" : 1, \"data_noleggio_fine\" : \"2000-01-23T04:56:07.000+00:00\", \"data_acquisto_automobile\" : \"2000-01-23T04:56:07.000+00:00\", \"data_noleggio_inizio\" : \"2000-01-23T04:56:07.000+00:00\", \"prezzo_acquisto_auto_ordine\" : 5.962133916683182, \"id\" : 0, \"id_prenotazione\" : 6, \"id_utente\" : \"id_utente\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /ordine/amministratori-noleggio/conferma : Inserimento ordine noleggio
     * RF-GAN-GN-3 l sistema dovrà permettere all&#39;amministratore noleggio di chiudere le prenotazioni di noleggio  
     *
     * @param ordine  (required)
     * @return Ordine inserito con successo (status code 200)
     *         or Errore nell&#39;inserimento dell&#39;ordine (status code 400)
     *         or Non autorizzato ad inserire l&#39;ordine (status code 401)
     */
    @Operation(
        operationId = "ordineAmministratoriNoleggioConfermaPost",
        summary = "Inserimento ordine noleggio",
        tags = { "Gestione Noleggio [Amministratore-Noleggio]" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Ordine inserito con successo", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Ordine.class))
            }),
            @ApiResponse(responseCode = "400", description = "Errore nell'inserimento dell'ordine"),
            @ApiResponse(responseCode = "401", description = "Non autorizzato ad inserire l'ordine")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/ordine/amministratori-noleggio/conferma",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Ordine> ordineAmministratoriNoleggioConfermaPost(
        @Parameter(name = "Ordine", description = "", required = true) @Valid @RequestBody Ordine ordine
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"prezzo_noleggio_giornaliero_ordine\" : 5.637376656633329, \"tipo\" : \"tipo\", \"id_automobile\" : 1, \"data_noleggio_fine\" : \"2000-01-23T04:56:07.000+00:00\", \"data_acquisto_automobile\" : \"2000-01-23T04:56:07.000+00:00\", \"data_noleggio_inizio\" : \"2000-01-23T04:56:07.000+00:00\", \"prezzo_acquisto_auto_ordine\" : 5.962133916683182, \"id\" : 0, \"id_prenotazione\" : 6, \"id_utente\" : \"id_utente\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
