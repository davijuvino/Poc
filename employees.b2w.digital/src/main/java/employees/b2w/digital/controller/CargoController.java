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

import employees.b2w.digital.domain.entity.Cargo;
import employees.b2w.digital.service.CargoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * Restfull controller for base data employees
 * Cargos
 */
@RestController
@RequestMapping("/api/v1/cargos")
public class CargoController {

    
    private final CargoService cargoService;
    
    @Autowired
    public CargoController(CargoService cargoService) {
		this.cargoService = cargoService;
	}

	@GetMapping
	@ApiResponses(
	        value = {
	        @ApiResponse( 
	                responseCode = "200", 
	                description = "Successful Operation",
	                content = @Content(mediaType = "text/plain"))})
	@Operation(summary = "lists all cargo included in the database", description = "cargos the employees")
    public ResponseEntity<List<Cargo>> getAll() {
        return new ResponseEntity<>(cargoService.getAll(), HttpStatus.OK);
    }
    
    @GetMapping("/pages")
	@ApiResponses(
	        value = {
	        @ApiResponse( 
	                responseCode = "200", 
	                description = "Successful Operation",
	                content = @Content(mediaType = "text/plain"))})
    @Operation(summary = "lists all cargo by pages included in the database", description = "cargos the employees")
    public ResponseEntity<Page<Cargo>> getAllPage(@ParameterObject Pageable pageable) {
        return new ResponseEntity<>(cargoService.getAllPage(pageable), HttpStatus.OK);
    }
    
    @GetMapping("/{Id}")
	@ApiResponses(
	        value = {
	        @ApiResponse( 
	                responseCode = "200", 
	                description = "Successful Operation",
	                content = @Content(mediaType = "text/plain"))})
    @Operation(summary = "lists all cargo by Id included in the database", description = "cargos the employees")
    public ResponseEntity<Cargo> getById(@PathVariable Integer Id) {
    	Cargo cargo = cargoService.getById(Id);
    	return new ResponseEntity<>(cargo, HttpStatus.OK);
    }
    
    @PostMapping("/{trilhaId}")
    @ApiResponses(
	        value = {
	        @ApiResponse( 
	                responseCode = "201", 
	                description = "Successfully Created",
	                content = @Content(mediaType = "text/plain"))})
    @Operation(summary = "save cargo and trilha id the database", description = "cargos the employees")
    public ResponseEntity<Cargo> create(@PathVariable Integer trilhaId, @Valid @RequestBody Cargo cargo) {
    	return new ResponseEntity<>(cargoService.save(trilhaId, cargo), HttpStatus.CREATED);
    }

    @PutMapping("/{Id}")
    @ApiResponses(
	        value = {
	        @ApiResponse( 
	                responseCode = "204", 
	                description = "Updated Successfully",
	                content = @Content(mediaType = "text/plain"))})
    @Operation(summary = "update cargo by id in the database", description = "cargos the employees")
    public ResponseEntity<Void> update(@PathVariable Integer Id, @Valid @RequestBody Cargo cargo) {
    	cargoService.update(Id, cargo);
    	
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    
    @DeleteMapping("/{Id}")
    @ApiResponses(
	        value = {
	        @ApiResponse( 
	                responseCode = "204", 
	                description = "Deleted Successfully",
	                content = @Content(mediaType = "text/plain"))})
    @Operation(summary = "delete cargo by id in the database", description = "cargos the employees")
    public ResponseEntity<Void> delete(@PathVariable Integer Id) {
    	cargoService.delete(Id);
    	
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
   
}