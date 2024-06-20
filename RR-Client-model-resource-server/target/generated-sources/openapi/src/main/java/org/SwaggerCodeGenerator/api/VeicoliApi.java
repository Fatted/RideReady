/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.0.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.SwaggerCodeGenerator.api;

import org.SwaggerCodeGenerator.model.Automobile;
import java.math.BigDecimal;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-19T12:30:19.977507800+02:00[Europe/Rome]")
@Validated
@Tag(name = "veicoli", description = "the veicoli API")
public interface VeicoliApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /veicoli/amministratori-acquisto : Visualizza Veicoli Acquisto
     * RF-GAA-GI-4 Il sistema dovrà permettere all&#39;amministratore acquisto di visualizzare tutti i veicoli da acquistare  
     *
     * @return Veicoli destinati all&#39;acquisto (status code 200)
     *         or Errore nella visualizzazione dei veicoli (status code 400)
     *         or Non autorizzato a visualizzare i veicoli (status code 401)
     */
    @Operation(
        operationId = "veicoliAmministratoriAcquistoGet",
        summary = "Visualizza Veicoli Acquisto",
        tags = { "Gestione Inventario [Amministratore-Acquisto]" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Veicoli destinati all'acquisto", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Automobile.class))
            }),
            @ApiResponse(responseCode = "400", description = "Errore nella visualizzazione dei veicoli"),
            @ApiResponse(responseCode = "401", description = "Non autorizzato a visualizzare i veicoli")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/veicoli/amministratori-acquisto",
        produces = { "application/json" }
    )
    default ResponseEntity<List<Automobile>> veicoliAmministratoriAcquistoGet(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"cilindrata\" : 2.3021358869347655, \"modello\" : \"modello\", \"targa\" : \"targa\", \"marca\" : \"marca\", \"carburante\" : \"carburante\", \"posti_a_sedere\" : 7.061401241503109, \"prezzo_acquisto\" : 6.027456183070403, \"tipo_di_destinazione\" : \"tipo_di_destinazione\", \"id\" : 0.8008281904610115, \"quantita\" : 5.962133916683182, \"cavalli\" : 5.637376656633329, \"disponibile\" : true, \"prezzo_noleggio_giornaliero\" : 1.4658129805029452 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /veicoli/amministratori-acquisto/modifica/{id} : Modifica Veicoli Acquisto
     * RF-GAA-GI-5 Il sistema dovrà permettere all&#39;amministratore acquisto di aggiornare lo stato dei veicoli  
     *
     * @param id  (required)
     * @return Veicolo aggiornato correttamente (status code 200)
     *         or Errore nella modifica del veicolo (status code 400)
     *         or Non autorizzato a modificare il veicolo (status code 401)
     */
    @Operation(
        operationId = "veicoliAmministratoriAcquistoModificaIdPut",
        summary = "Modifica Veicoli Acquisto",
        tags = { "Gestione Inventario [Amministratore-Acquisto]" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Veicolo aggiornato correttamente", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Automobile.class))
            }),
            @ApiResponse(responseCode = "400", description = "Errore nella modifica del veicolo"),
            @ApiResponse(responseCode = "401", description = "Non autorizzato a modificare il veicolo")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/veicoli/amministratori-acquisto/modifica/{id}",
        produces = { "application/json" }
    )
    default ResponseEntity<List<Automobile>> veicoliAmministratoriAcquistoModificaIdPut(
        @Parameter(name = "id", description = "", required = true) @PathVariable("id") BigDecimal id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"cilindrata\" : 2.3021358869347655, \"modello\" : \"modello\", \"targa\" : \"targa\", \"marca\" : \"marca\", \"carburante\" : \"carburante\", \"posti_a_sedere\" : 7.061401241503109, \"prezzo_acquisto\" : 6.027456183070403, \"tipo_di_destinazione\" : \"tipo_di_destinazione\", \"id\" : 0.8008281904610115, \"quantita\" : 5.962133916683182, \"cavalli\" : 5.637376656633329, \"disponibile\" : true, \"prezzo_noleggio_giornaliero\" : 1.4658129805029452 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /veicoli/amministratori/elimina/{id} : Eliminazione Veicolo Amministratore
     * Il sistema dovrà permettere all&#39;amministratore di eliminare un veicolo da acquistare  
     *
     * @param id  (required)
     * @return Veicolo eliminato con successo (status code 200)
     *         or Errore nell&#39;eliminazione del veicolo (status code 400)
     *         or Non autorizzato ad eliminare il veicolo (status code 401)
     */
    @Operation(
        operationId = "veicoliAmministratoriEliminaIdDelete",
        summary = "Eliminazione Veicolo Amministratore",
        tags = { "Gestione Inventario [Amministratori]" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Veicolo eliminato con successo", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "400", description = "Errore nell'eliminazione del veicolo"),
            @ApiResponse(responseCode = "401", description = "Non autorizzato ad eliminare il veicolo")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/veicoli/amministratori/elimina/{id}",
        produces = { "application/json" }
    )
    default ResponseEntity<String> veicoliAmministratoriEliminaIdDelete(
        @Parameter(name = "id", description = "", required = true) @PathVariable("id") BigDecimal id
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /veicoli/amministratori/inserimento : Inserimento Veicolo Amministratore
     * Il sistema dovrà permettere all&#39;amministratore di aggiungere un veicolo da acquistare  
     *
     * @param automobile  (required)
     * @return Veicolo aggiunto con successo (status code 200)
     *         or Errore nell&#39;inserimento del veicolo (status code 400)
     *         or Non autorizzato ad inserire il veicolo (status code 401)
     */
    @Operation(
        operationId = "veicoliAmministratoriInserimentoPost",
        summary = "Inserimento Veicolo Amministratore",
        tags = { "Gestione Inventario [Amministratori]" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Veicolo aggiunto con successo", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Automobile.class))
            }),
            @ApiResponse(responseCode = "400", description = "Errore nell'inserimento del veicolo"),
            @ApiResponse(responseCode = "401", description = "Non autorizzato ad inserire il veicolo")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/veicoli/amministratori/inserimento",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Automobile> veicoliAmministratoriInserimentoPost(
        @Parameter(name = "Automobile", description = "", required = true) @Valid @RequestBody Automobile automobile
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"cilindrata\" : 2.3021358869347655, \"modello\" : \"modello\", \"targa\" : \"targa\", \"marca\" : \"marca\", \"carburante\" : \"carburante\", \"posti_a_sedere\" : 7.061401241503109, \"prezzo_acquisto\" : 6.027456183070403, \"tipo_di_destinazione\" : \"tipo_di_destinazione\", \"id\" : 0.8008281904610115, \"quantita\" : 5.962133916683182, \"cavalli\" : 5.637376656633329, \"disponibile\" : true, \"prezzo_noleggio_giornaliero\" : 1.4658129805029452 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /veicoli/amministratori/modifica/{id} : Modifica Veicolo Amministratore
     * Il sistema dovrà permettere all&#39;amministratore di modificare un veicolo da acquistare  
     *
     * @param id  (required)
     * @param automobile  (required)
     * @return Veicolo aggiornato con successo (status code 200)
     *         or Errore nella modifica del veicolo (status code 400)
     *         or Non autorizzato a modificare il veicolo (status code 401)
     */
    @Operation(
        operationId = "veicoliAmministratoriModificaIdPut",
        summary = "Modifica Veicolo Amministratore",
        tags = { "Gestione Inventario [Amministratori]" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Veicolo aggiornato con successo", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Automobile.class))
            }),
            @ApiResponse(responseCode = "400", description = "Errore nella modifica del veicolo"),
            @ApiResponse(responseCode = "401", description = "Non autorizzato a modificare il veicolo")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/veicoli/amministratori/modifica/{id}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Automobile> veicoliAmministratoriModificaIdPut(
        @Parameter(name = "id", description = "", required = true) @PathVariable("id") BigDecimal id,
        @Parameter(name = "Automobile", description = "", required = true) @Valid @RequestBody Automobile automobile
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"cilindrata\" : 2.3021358869347655, \"modello\" : \"modello\", \"targa\" : \"targa\", \"marca\" : \"marca\", \"carburante\" : \"carburante\", \"posti_a_sedere\" : 7.061401241503109, \"prezzo_acquisto\" : 6.027456183070403, \"tipo_di_destinazione\" : \"tipo_di_destinazione\", \"id\" : 0.8008281904610115, \"quantita\" : 5.962133916683182, \"cavalli\" : 5.637376656633329, \"disponibile\" : true, \"prezzo_noleggio_giornaliero\" : 1.4658129805029452 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /veicoli/amministratori-noleggio : Visualizza Veicoli Noleggio
     * RF-GAN-GI-4 Il sistema dovrà permettere all&#39;amministratore noleggio di visualizzare tutti i veicoli da noleggio  
     *
     * @return Veicoli destinati al noleggio (status code 200)
     *         or Errore nella visualizzazione dei veicoli (status code 400)
     *         or Non autorizzato a visualizzare i veicoli (status code 401)
     */
    @Operation(
        operationId = "veicoliAmministratoriNoleggioGet",
        summary = "Visualizza Veicoli Noleggio",
        tags = { "Gestione Inventario [Amministratore-Noleggio]" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Veicoli destinati al noleggio", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Automobile.class))
            }),
            @ApiResponse(responseCode = "400", description = "Errore nella visualizzazione dei veicoli"),
            @ApiResponse(responseCode = "401", description = "Non autorizzato a visualizzare i veicoli")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/veicoli/amministratori-noleggio",
        produces = { "application/json" }
    )
    default ResponseEntity<List<Automobile>> veicoliAmministratoriNoleggioGet(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"cilindrata\" : 2.3021358869347655, \"modello\" : \"modello\", \"targa\" : \"targa\", \"marca\" : \"marca\", \"carburante\" : \"carburante\", \"posti_a_sedere\" : 7.061401241503109, \"prezzo_acquisto\" : 6.027456183070403, \"tipo_di_destinazione\" : \"tipo_di_destinazione\", \"id\" : 0.8008281904610115, \"quantita\" : 5.962133916683182, \"cavalli\" : 5.637376656633329, \"disponibile\" : true, \"prezzo_noleggio_giornaliero\" : 1.4658129805029452 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /veicoli/amministratori-noleggio/modifica/{id} : Modifica Veicolo Noleggio
     * RF-GAN-GI-2 Il sistema dovrà permettere all&#39;amministratore noleggio di modificare un veicolo da noleggio  
     *
     * @param id  (required)
     * @param automobile  (required)
     * @return Veicolo aggiornato con successo (status code 200)
     *         or Errore nella modifica del veicolo (status code 400)
     *         or Non autorizzato a modificare il veicolo (status code 401)
     */
    @Operation(
        operationId = "veicoliAmministratoriNoleggioModificaIdPut",
        summary = "Modifica Veicolo Noleggio",
        tags = { "Gestione Inventario [Amministratore-Noleggio]" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Veicolo aggiornato con successo", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Automobile.class))
            }),
            @ApiResponse(responseCode = "400", description = "Errore nella modifica del veicolo"),
            @ApiResponse(responseCode = "401", description = "Non autorizzato a modificare il veicolo")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/veicoli/amministratori-noleggio/modifica/{id}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Automobile> veicoliAmministratoriNoleggioModificaIdPut(
        @Parameter(name = "id", description = "", required = true) @PathVariable("id") BigDecimal id,
        @Parameter(name = "Automobile", description = "", required = true) @Valid @RequestBody Automobile automobile
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"cilindrata\" : 2.3021358869347655, \"modello\" : \"modello\", \"targa\" : \"targa\", \"marca\" : \"marca\", \"carburante\" : \"carburante\", \"posti_a_sedere\" : 7.061401241503109, \"prezzo_acquisto\" : 6.027456183070403, \"tipo_di_destinazione\" : \"tipo_di_destinazione\", \"id\" : 0.8008281904610115, \"quantita\" : 5.962133916683182, \"cavalli\" : 5.637376656633329, \"disponibile\" : true, \"prezzo_noleggio_giornaliero\" : 1.4658129805029452 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /veicoli/clienti/acquisto : Visualizza veicoli disponibili per l&#39;acquisto
     * RF-GC-RVV-1 Il sistema dovrà permettere al cliente di visualizzare veicoli disponibili per acquisto
     *
     * @return Elenco dei veicoli disponibili all&#39;acquisto (status code 200)
     *         or Errore nella visualizzazione dei veicoli (status code 400)
     *         or Non autorizzato a visualizzare i veicoli (status code 401)
     */
    @Operation(
        operationId = "veicoliClientiAcquistoGet",
        summary = "Visualizza veicoli disponibili per l'acquisto",
        tags = { "Ricerca e Visualizzazione Veicoli [Cliente]" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Elenco dei veicoli disponibili all'acquisto", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Automobile.class))
            }),
            @ApiResponse(responseCode = "400", description = "Errore nella visualizzazione dei veicoli"),
            @ApiResponse(responseCode = "401", description = "Non autorizzato a visualizzare i veicoli")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/veicoli/clienti/acquisto",
        produces = { "application/json" }
    )
    default ResponseEntity<List<Automobile>> veicoliClientiAcquistoGet(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"cilindrata\" : 2.3021358869347655, \"modello\" : \"modello\", \"targa\" : \"targa\", \"marca\" : \"marca\", \"carburante\" : \"carburante\", \"posti_a_sedere\" : 7.061401241503109, \"prezzo_acquisto\" : 6.027456183070403, \"tipo_di_destinazione\" : \"tipo_di_destinazione\", \"id\" : 0.8008281904610115, \"quantita\" : 5.962133916683182, \"cavalli\" : 5.637376656633329, \"disponibile\" : true, \"prezzo_noleggio_giornaliero\" : 1.4658129805029452 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /veicoli/clienti/noleggio : Visualizza veicoli disponibili per il noleggio
     * RF-GC-RVV-2 Il sistema dovrà permettere al cliente di visualizzare veicoli disponibili per il noleggio
     *
     * @return Elenco dei veicoli disponibili per il noleggio (status code 200)
     *         or Errore nella visualizzazione dei veicoli (status code 400)
     *         or Non autorizzato a visualizzare i veicoli (status code 401)
     */
    @Operation(
        operationId = "veicoliClientiNoleggioGet",
        summary = "Visualizza veicoli disponibili per il noleggio",
        tags = { "Ricerca e Visualizzazione Veicoli [Cliente]" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Elenco dei veicoli disponibili per il noleggio", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Automobile.class))
            }),
            @ApiResponse(responseCode = "400", description = "Errore nella visualizzazione dei veicoli"),
            @ApiResponse(responseCode = "401", description = "Non autorizzato a visualizzare i veicoli")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/veicoli/clienti/noleggio",
        produces = { "application/json" }
    )
    default ResponseEntity<List<Automobile>> veicoliClientiNoleggioGet(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"cilindrata\" : 2.3021358869347655, \"modello\" : \"modello\", \"targa\" : \"targa\", \"marca\" : \"marca\", \"carburante\" : \"carburante\", \"posti_a_sedere\" : 7.061401241503109, \"prezzo_acquisto\" : 6.027456183070403, \"tipo_di_destinazione\" : \"tipo_di_destinazione\", \"id\" : 0.8008281904610115, \"quantita\" : 5.962133916683182, \"cavalli\" : 5.637376656633329, \"disponibile\" : true, \"prezzo_noleggio_giornaliero\" : 1.4658129805029452 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /veicoli/{id} : Visualizza dettagli veicolo
     * RF-GC-RVV-3 Il sistema dovrà permettere al cliente di visualizzare dettagli completi dei veicoli
     *
     * @param id  (required)
     * @return Dettagli del veicolo (status code 200)
     *         or Errore nella visualizzazione dei dettagli del veicolo (status code 400)
     *         or Non autorizzato a visualizzare i dettagli del veicolo (status code 401)
     */
    @Operation(
        operationId = "veicoliIdGet",
        summary = "Visualizza dettagli veicolo",
        tags = { "Ricerca e Visualizzazione Veicoli [Clienti/Amministratore-Acquisto/Amministratore-Noleggio]" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Dettagli del veicolo", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Automobile.class))
            }),
            @ApiResponse(responseCode = "400", description = "Errore nella visualizzazione dei dettagli del veicolo"),
            @ApiResponse(responseCode = "401", description = "Non autorizzato a visualizzare i dettagli del veicolo")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/veicoli/{id}",
        produces = { "application/json" }
    )
    default ResponseEntity<Automobile> veicoliIdGet(
        @Parameter(name = "id", description = "", required = true) @PathVariable("id") BigDecimal id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"cilindrata\" : 2.3021358869347655, \"modello\" : \"modello\", \"targa\" : \"targa\", \"marca\" : \"marca\", \"carburante\" : \"carburante\", \"posti_a_sedere\" : 7.061401241503109, \"prezzo_acquisto\" : 6.027456183070403, \"tipo_di_destinazione\" : \"tipo_di_destinazione\", \"id\" : 0.8008281904610115, \"quantita\" : 5.962133916683182, \"cavalli\" : 5.637376656633329, \"disponibile\" : true, \"prezzo_noleggio_giornaliero\" : 1.4658129805029452 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
