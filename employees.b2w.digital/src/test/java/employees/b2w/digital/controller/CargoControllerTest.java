package employees.b2w.digital.controller;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import employees.b2w.digital.domain.entity.Cargo;
import employees.b2w.digital.service.CargoService;
import employees.b2w.digital.util.CargoCreator;

@ExtendWith(SpringExtension.class)
public class CargoControllerTest {

	
	@InjectMocks
	private CargoController cargoController;
	
	@Mock
	private CargoService cargoServiceMocks;
	
	
	/* Metodo q realizar o Mock ou seja um comportamento no serviço para todos testes  */
	@BeforeEach
	void setUp() {
		
		PageImpl<Cargo> pages = new PageImpl<>(List.of(CargoCreator.createValidCargo()));
		
		BDDMockito.when(cargoServiceMocks.getAllPage(ArgumentMatchers.any()))
						.thenReturn(pages);
		
		BDDMockito.when(cargoServiceMocks.getAll())
						.thenReturn(List.of(CargoCreator.createValidCargo()));
		
		BDDMockito.when(cargoServiceMocks.findByIdCargoOrThrowBadRequestException(ArgumentMatchers.anyInt()))
						.thenReturn(CargoCreator.createValidCargo());
		
		BDDMockito.when(cargoServiceMocks.getById(ArgumentMatchers.anyInt()))
						.thenReturn(CargoCreator.createValidCargo());
		
		BDDMockito.when(cargoServiceMocks.save(ArgumentMatchers.anyInt(), ArgumentMatchers.any(Cargo.class)))
						.thenReturn(CargoCreator.createValidCargo());
		
		BDDMockito.doNothing().when(cargoServiceMocks).update(ArgumentMatchers.anyInt(), ArgumentMatchers.any(Cargo.class));
		
		BDDMockito.doNothing().when(cargoServiceMocks).delete(ArgumentMatchers.anyInt());
		
		 
	}
	
	@Test
	@DisplayName("getAllPage returns list of cargo inside page object when successuful")
	void getAllPage_ReturnsListOfTrilhaInsidePageObject_WhenSuccessful() {
		String expectedName = CargoCreator.createValidCargo().getCargo_nome();
		
		Page<Cargo> pages = cargoController.getAllPage(null).getBody();
		
		Assertions.assertThat(pages).isNotNull();
		Assertions.assertThat(pages.toList()).isNotEmpty();
		Assertions.assertThat(pages.toList())
						.isNotEmpty()
						.hasSize(1);
		
		Assertions.assertThat(pages.toList().get(0).getCargo_nome()).isEqualTo(expectedName);
	}
	
	@Test
	@DisplayName("ListAll returns list of cargo  when successuful")
	void getAll_ReturnsListOfTrilhasInsidePageObject_WhenSuccessful() {
		String expectedName = CargoCreator.createValidCargo().getCargo_nome();
		
		List<Cargo> cargos = cargoController.getAll().getBody();
		
		Assertions.assertThat(cargos)
						.isNotEmpty()
						.isNotNull()
						.hasSize(1);
		
		Assertions.assertThat(cargos.get(0).getCargo_nome()).isEqualTo(expectedName);
	}
	
	@Test
	@DisplayName("findById return cargo when successuful")
	void getById_ReturnsTrilhas_WhenSuccessful() {
		Integer expectedId = CargoCreator.createValidCargo().getId();
		
		Cargo cargo = cargoController.getById(1).getBody();
		
		Assertions.assertThat(cargo).isNotNull();
		Assertions.assertThat(cargo.getId())
		 				.isNotNull()
		 				.isEqualTo(expectedId);
	}
	
		
	@Test
	@DisplayName("save return cargo when successuful")
	void create_ReturnsCargo_WhenSuccessful() {
	  
	   Cargo cargo = cargoController.create(1,CargoCreator.createValidCargo()).getBody();
	   Assertions.assertThat(cargo).isNotNull();
	  
	}
  
	@Test
	@DisplayName("update return cargo when successuful")
	void update_ReturnsCargo_WhenSuccessful() {
			
		Assertions.assertThatCode(() -> cargoController.update(
				CargoCreator.createValidCargo().getId(),
				CargoCreator.createValidUpdateCargo()))
		.doesNotThrowAnyException();
	  
	}
	
	@Test
	@DisplayName("delete remove trilha when successuful")
	void delete_RemoveTrilha_WhenSuccessful() {
		
		Assertions.assertThatCode(() -> cargoController.delete(1)).doesNotThrowAnyException();
	}
  
}



