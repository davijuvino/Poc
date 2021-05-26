package employees.b2w.digital.controller;

import java.util.List;
import javax.validation.Valid;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import employees.b2w.digital.domain.entity.Trilha;
import employees.b2w.digital.domain.mapper.TrilhaMapper;
import employees.b2w.digital.service.TrilhaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * Restfull controller for base data employees
 * Trilhas
 */
@RestController
@RequestMapping("/api/v1/trilhas")
public class TrilhaController {

    
    private final TrilhaService trilhaService;
    
    @Autowired
    public TrilhaController(TrilhaService trilhaService) {
		this.trilhaService = trilhaService;
	}
    
	@GetMapping
	@ApiResponses(
	        value = {
	        @ApiResponse( 
	                responseCode = "200", 
	                description = "Successful Operation",
	                content = @Content(mediaType = "text/plain"))})
	@Operation(summary = "lists all trilhas included in the database", description = "trilha the employees")
    public ResponseEntity<List<TrilhaMapper>> getAll() {
        return ResponseEntity.ok(trilhaService.getAll());
    }
	
	@GetMapping("/cargos")
	@ApiResponses(
	        value = {
	        @ApiResponse( 
	                responseCode = "200", 
	                description = "Successful Operation",
	                content = @Content(mediaType = "text/plain"))})
	@Operation(summary = "lists all trilhas by cargos included in the database", description = "trilha the employees")
    public ResponseEntity<List<Trilha>> getAllByCargos() {
        return ResponseEntity.ok(trilhaService.getAllByCargos());
    }
    
    @GetMapping("/pages")
    @ApiResponses(
	        value = {
	        @ApiResponse( 
	                responseCode = "200", 
	                description = "Successful Operation",
	                content = @Content(mediaType = "text/plain"))})
    @Operation(summary = "lists all trilhas by pages included in the database", description = "trilha the employees")
    public ResponseEntity<Page<Trilha>> getAllPage(@ParameterObject Pageable pageable) {
        return ResponseEntity.ok(trilhaService.getAllPage(pageable));
    }
    
    @GetMapping("/{id}")
    @ApiResponses(
	        value = {
	        @ApiResponse( 
	                responseCode = "200", 
	                description = "Successful Operation",
	                content = @Content(mediaType = "text/plain"))})
    @Operation(summary = "lists trilhas by id included in the database", description = "trilha the employees")
    public ResponseEntity<TrilhaMapper> getById(@PathVariable Integer id) {
        TrilhaMapper trilhaMapper = trilhaService.getById(id);
        return ResponseEntity.ok(trilhaMapper);
    }
    
    @PostMapping
    @ApiResponses(
	        value = {
	        @ApiResponse( 
	                responseCode = "201", 
	                description = "Successfully Created",
	                content = @Content(mediaType = "text/plain"))})
    @Operation(summary = "save trilha in the database", description = "trilha the employees") 
    public ResponseEntity<Trilha> create(@Valid @RequestBody Trilha trilha) {
    	return new ResponseEntity<>(trilhaService.save(trilha), HttpStatus.CREATED);
    }

    @PutMapping("/{Id}")
    @ApiResponses(
	        value = {
	        @ApiResponse( 
	                responseCode = "204", 
	                description = "Updated Successfully",
	                content = @Content(mediaType = "text/plain"))})
    @Operation(summary = "update trilha by in the database", description = "trilha the employees")
    public ResponseEntity<Void> update(@PathVariable Integer Id, @Valid @RequestBody Trilha trilha) {
    	trilhaService.update(Id, trilha);
    	
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    
    @DeleteMapping("/{Id}")
    @ApiResponses(
	        value = {
	        @ApiResponse( 
	                responseCode = "204", 
	                description = "Deleted Successfully",
	                content = @Content(mediaType = "text/plain"))})
    @Operation(summary = "delete trilha by id in the database", description = "trilha the employees")
    public ResponseEntity<Void> delete(@PathVariable Integer Id) {
    	trilhaService.delete(Id);
    	
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
   
}