package employees.b2w.digital.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import employees.b2w.digital.domain.entity.Cargo;
import employees.b2w.digital.domain.entity.Trilha;
import employees.b2w.digital.util.CargoCreator;
import employees.b2w.digital.util.TrilhaCreator;

@DataJpaTest
@DisplayName("Tests for Cargo Repository")
public class CargoRepositoryTest {
	
	@Autowired
	private CargoRepository cargoRepository;
	
	@Autowired
	private TrilhaRepository trilhaRepository;
		
	@Test
	@DisplayName("Tests Save Cargo Repository")
	void save_Cargo_WhenSuccessful() {
		
		Trilha trilhaToBeSaved = TrilhaCreator.createTrilhaToBeSaved();
		Trilha trilhaSaved = this.trilhaRepository.save(trilhaToBeSaved);
		
		Cargo cargoToBeSaved = CargoCreator.createCargoToBeSaved();
		cargoToBeSaved.setTrilhaId(trilhaSaved.getId());
		Cargo cargoSaved = this.cargoRepository.save(cargoToBeSaved);
		
		assertThat(cargoSaved).isNotNull();
		assertThat(cargoSaved.getId()).isNotNull();
		assertThat(cargoSaved.getCargo_nome()).isEqualTo(cargoToBeSaved.getCargo_nome());
	}
	
	@Test
	@DisplayName("Tests Update Cargo Repository")
	void update_Cargo_WhenSuccessful() {
		
		Trilha trilhaToBeSaved = TrilhaCreator.createTrilhaToBeSaved();
		Trilha trilhaSaved = this.trilhaRepository.save(trilhaToBeSaved);
		
		Cargo cargoToBeSaved = CargoCreator.createCargoToBeSaved();
		cargoToBeSaved.setTrilhaId(trilhaSaved.getId());
		Cargo cargoSaved = this.cargoRepository.save(cargoToBeSaved);
		
		cargoSaved.setCargo_nome("Overload");
		Cargo cargoUpdated = this.cargoRepository.save(cargoSaved);
		
		assertThat(cargoUpdated).isNotNull();
		assertThat(cargoUpdated.getId()).isNotNull();
		assertThat(cargoUpdated.getCargo_nome()).isEqualTo(cargoSaved.getCargo_nome());
	}
	
	@Test
	@DisplayName("Tests Delete Cargo Repository")
	void delete_Cargo_WhenSuccessful() {
		
		Trilha trilhaToBeSaved = TrilhaCreator.createTrilhaToBeSaved();
		Trilha trilhaSaved = this.trilhaRepository.save(trilhaToBeSaved);
		
		Cargo cargoToBeSaved = CargoCreator.createCargoToBeSaved();
		cargoToBeSaved.setTrilhaId(trilhaSaved.getId());
		Cargo cargoSaved = this.cargoRepository.save(cargoToBeSaved);
		
		this.cargoRepository.delete(cargoSaved);
		Optional<Cargo> cargoOptional = this.cargoRepository.findById(cargoSaved.getId());
		assertThat(cargoOptional.isEmpty());
	}
	
	@Test
	@DisplayName("Tests Find by Id returns list of Cargo when successful")
	void findById_ReturnsListOfCargo_WhenSuccessful() {
		
		Trilha trilhaToBeSaved = TrilhaCreator.createTrilhaToBeSaved();
		Trilha trilhaSaved = this.trilhaRepository.save(trilhaToBeSaved);
		
		Cargo cargoToBeSaved = CargoCreator.createCargoToBeSaved();
		cargoToBeSaved.setTrilhaId(trilhaSaved.getId());
		Cargo cargoSaved = this.cargoRepository.save(cargoToBeSaved);
		
		Optional<Cargo> cargoOptional = this.cargoRepository.findById(cargoSaved.getId());
		assertThat(cargoOptional).isNotEmpty();
		assertThat(cargoOptional).contains(cargoSaved);
		
	}

}
