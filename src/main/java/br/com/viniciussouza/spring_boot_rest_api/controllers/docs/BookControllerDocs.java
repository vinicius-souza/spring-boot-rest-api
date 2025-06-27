package br.com.viniciussouza.spring_boot_rest_api.controllers.docs;

import br.com.viniciussouza.spring_boot_rest_api.dtos.BookDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public interface BookControllerDocs {

    @Operation(
            summary = "Find all books",
            tags = "Book",
            description = "Returns a list of all books in the system",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = APPLICATION_JSON_VALUE,
                                            array = @ArraySchema(schema = @Schema(implementation = BookDTO.class))
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
    List<BookDTO> findAll();

    @Operation(
            summary = "Finds a book",
            tags = "Book",
            description = "Find a specific book by ID",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = BookDTO.class)
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
    BookDTO findById(Long id);


    @Operation(
            summary = "Create a new book",
            tags = "Book",
            description = "Creates a new book in the system",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = BookDTO.class)
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
    BookDTO create(BookDTO book);


    @Operation(
            summary = "Update a book",
            tags = "Book",
            description = "Updates an existing book in the system",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = BookDTO.class)
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
    BookDTO update(BookDTO book);


    @Operation(
            summary = "Removes a book",
            tags = "Book",
            description = "Removes a specific book by ID",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = BookDTO.class)
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
