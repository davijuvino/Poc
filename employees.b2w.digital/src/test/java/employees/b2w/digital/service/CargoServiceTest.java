package employees.b2w.digital.service;

import java.util.List;
import java.util.Optional;

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
import org.springframework.data.domain.PageRequest;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import employees.b2w.digital.domain.entity.Cargo;
import employees.b2w.digital.repository.CargoRepository;
import employees.b2w.digital.util.CargoCreator;
import employees.b2w.digital.util.TrilhaCreator;



@ExtendWith(SpringExtension.class)
public class CargoServiceTest {

	@InjectMocks
	private CargoService cargoService;

	@Mock
	private CargoRepository cargoRepositoryMocks;
	
	@Mock
	private TrilhaService TrilhaServiceMocks;

	
	@BeforeEach
	void setUp() {

		PageImpl<Cargo> cargoPage = new PageImpl<>(List.of(CargoCreator.createValidCargo()));
		
		BDDMockito.when(cargoRepositoryMocks.findAll(ArgumentMatchers.any(PageRequest.class)))
					.thenReturn(cargoPage);
		
		BDDMockito.when(cargoRepositoryMocks.findAll())
					.thenReturn(List.of(CargoCreator.createCargoToBeSaved()));
		
		BDDMockito.when(cargoRepositoryMocks.findById(ArgumentMatchers.anyInt()))
					.thenReturn(Optional.of(CargoCreator.createValidCargo()));
		
		BDDMockito.when(TrilhaServiceMocks.getById(ArgumentMatchers.anyInt()))
					.thenReturn(TrilhaCreator.createValidTrilhaMapper());
		
		BDDMockito.when(cargoRepositoryMocks.save(ArgumentMatchers.any(Cargo.class)))
					.thenReturn(CargoCreator.createValidCargo());
	   
		BDDMockito.doNothing().when(cargoRepositoryMocks).delete(ArgumentMatchers.any(Cargo.class));
	}

	@Test
	@DisplayName("getAll returns list of cargo  when successuful")
	void getAll_ReturnsListOfCargo_WhenSuccessful() {
		
		String expectedName =  CargoCreator.createValidCargo().getCargo_nome();
		List<Cargo> model = cargoService.getAll();

		Assertions.assertThat(model).isNotEmpty().isNotNull().hasSize(1);
		Assertions.assertThat(model.get(0)
						.getCargo_nome()
						.equals(expectedName));
	}
	
	@Test
	@DisplayName("getAllPage returns list of cargo inside page object when successuful")
	void getAllPage_ReturnsListOfCargosPageObject_WhenSuccessful() {
		
		String expectedName =  CargoCreator.createValidCargo().getCargo_nome();
		Page<Cargo> cargoPage = cargoService.getAllPage(PageRequest.of(1, 1));

		Assertions.assertThat(cargoPage).isNotNull();
		Assertions.assertThat(cargoPage.toList()).isNotEmpty().hasSize(1);
		Assertions.assertThat(cargoPage.toList()
						.get(0)
						.getCargo_nome())
						.isEqualTo(expectedName);
	}
	
	@Test
	@DisplayName("getById return cargo when successuful")
	void getById_ReturnsCargos_WhenSuccessful() {
		
		Integer expectedId = CargoCreator.createValidCargo().getId();
		Cargo cargo = cargoService.getById(1);
		
		Assertions.assertThat(cargo).isNotNull();
		Assertions.assertThat(cargo.getId())
						.isNotNull()
						.isEqualTo(expectedId);
	}
	
	@Test
	@DisplayName("save return cargo when successuful")
	void save_ReturnsCargo_WhenSuccessful() {
	  
		Cargo cargo = cargoService.save(TrilhaCreator.createValidTrilha().getId(), CargoCreator.createValidCargo());
		
		Assertions.assertThat(cargo).isNotNull();
		Assertions.assertThat(cargo.getId()).isNotNull();
	}

	@Test
	@DisplayName("update return cargo when successuful")
	void update_ReturnsCargo_WhenSuccessful() {
		
		Assertions.assertThatCode(() -> cargoService.update(
				CargoCreator.createValidCargo().getId(),
				CargoCreator.createValidUpdateCargo()))
		.doesNotThrowAnyException();
	}
	
	@Test
	@DisplayName("delete remove cargo when successuful")
	void delete_RemoveCargo_WhenSuccessful() {
		
		Assertions.assertThatCode(() -> cargoService.delete(1)).doesNotThrowAnyException();
	}
	
}

