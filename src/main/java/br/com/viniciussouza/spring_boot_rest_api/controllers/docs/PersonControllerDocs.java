package br.com.viniciussouza.spring_boot_rest_api.controllers.docs;

import br.com.viniciussouza.spring_boot_rest_api.dtos.PersonDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public interface PersonControllerDocs {

    @Operation(
            summary = "Find all people",
            tags = "Person",
            description = "Returns a list of all people in the system",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = APPLICATION_JSON_VALUE,
                                            array = @ArraySchema(schema = @Schema(implementation = PersonDTO.class))
                                    )
                            }),
                    @ApiResponse(description = "No content",
                            responseCode = "204",
                            content = @Content),
                    @ApiResponse(description = "Internal server error",
                            responseCode = "500",
                            content = @Content),
                    @ApiResponse(description = "Bad request",
                            responseCode = "400",
                            content = @Content),
                    @ApiResponse(description = "Unauthorized",
                            responseCode = "401",
                            content = @Content),
                    @ApiResponse(description = "not found",
                            responseCode = "404",
                            content = @Content)
            }
    )
    List<PersonDTO> findAll();

    @Operation(
            summary = "Finds a person",
            tags = "Person",
            description = "Find a specific person by ID",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = PersonDTO.class)
                            )),
                    @ApiResponse(description = "No content",
                            responseCode = "204",
                            content = @Content),
                    @ApiResponse(description = "Internal server error",
                            responseCode = "500",
                            content = @Content),
                    @ApiResponse(description = "Bad request",
                            responseCode = "400",
                            content = @Content),
                    @ApiResponse(description = "Unauthorized",
                            responseCode = "401",
                            content = @Content),
                    @ApiResponse(description = "Not found",
                            responseCode = "404",
                            content = @Content)
            }
    )
    PersonDTO findById(Long id);


    @Operation(
            summary = "Create a new person",
            tags = "Person",
            description = "Creates a new person in the system",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = PersonDTO.class)
                            )),
                    @ApiResponse(description = "No content",
                            responseCode = "204",
                            content = @Content),
                    @ApiResponse(description = "Internal server error",
                            responseCode = "500",
                            content = @Content),
                    @ApiResponse(description = "Bad request",
                            responseCode = "400",
                            content = @Content),
                    @ApiResponse(description = "Unauthorized",
                            responseCode = "401",
                            content = @Content),
                    @ApiResponse(description = "Not found",
                            responseCode = "404",
                            content = @Content)
            }
    )
    PersonDTO create(PersonDTO person);


    @Operation(
            summary = "Update a person",
            tags = "Person",
            description = "Updates an existing person in the system",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = PersonDTO.class)
                            )),
                    @ApiResponse(description = "No content",
                            responseCode = "204",
                            content = @Content),
                    @ApiResponse(description = "Internal server error",
                            responseCode = "500",
                            content = @Content),
                    @ApiResponse(description = "Bad request",
                            responseCode = "400",
                            content = @Content),
                    @ApiResponse(description = "Unauthorized",
                            responseCode = "401",
                            content = @Content),
                    @ApiResponse(description = "Not found",
                            responseCode = "404",
                            content = @Content)
            }
    )
    PersonDTO update(PersonDTO person);


    @Operation(
            summary = "Removes a person",
            tags = "Person",
            description = "Removes a specific person by ID",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = PersonDTO.class)
                            )),
                    @ApiResponse(description = "No content",
                            responseCode = "204",
                            content = @Content),
                    @ApiResponse(description = "Internal server error",
                            responseCode = "500",
                            content = @Content),
                    @ApiResponse(description = "Bad request",
                            responseCode = "400",
                            content = @Content),
                    @ApiResponse(description = "Unauthorized",
                            responseCode = "401",
                            content = @Content),
                    @ApiResponse(description = "Not found",
                            responseCode = "404",
                            content = @Content)
            }
    )
    ResponseEntity<?> delete(Long id);
}
