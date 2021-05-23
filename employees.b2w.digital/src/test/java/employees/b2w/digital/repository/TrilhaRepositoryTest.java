package employees.b2w.digital.repository;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import employees.b2w.digital.domain.entity.Trilha;
import employees.b2w.digital.util.TrilhaCreator;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DisplayName("Tests for Trilhas Repository")
public class TrilhaRepositoryTest {
	
	@Autowired
	private TrilhaRepository trilhaRepository;
	
		
	@Test
	@DisplayName("Tests Save Trilha Repository")
	void save_Trilha_WhenSuccessful() {
		Trilha trilhaToBeSaved = TrilhaCreator.createTrilhaToBeSaved();
		Trilha trilhaSaved = this.trilhaRepository.save(trilhaToBeSaved);
		
		assertThat(trilhaSaved).isNotNull();
		assertThat(trilhaSaved.getId()).isNotNull();
		assertThat(trilhaSaved.getTrilha_nome()).isEqualTo(trilhaToBeSaved.getTrilha_nome());
	}
	
	@Test
	@DisplayName("Tests Update Trilha Repository")
	void update_Trilha_WhenSuccessful() {
		Trilha trilhaToBeSaved = TrilhaCreator.createTrilhaToBeSaved();
		Trilha trilhaSaved = this.trilhaRepository.save(trilhaToBeSaved);
		trilhaSaved.setTrilha_nome("Overload");
		Trilha trilhaUpdated = this.trilhaRepository.save(trilhaSaved);
		
		assertThat(trilhaUpdated).isNotNull();
		assertThat(trilhaUpdated.getId()).isNotNull();
		assertThat(trilhaUpdated.getTrilha_nome()).isEqualTo(trilhaSaved.getTrilha_nome());
	}
	
	@Test
	@DisplayName("Tests Delete Trilha Repository")
	void delete_Trilha_WhenSuccessful() {
		Trilha trilhaToBeSaved = TrilhaCreator.createTrilhaToBeSaved();
		Trilha trilhaSaved = this.trilhaRepository.save(trilhaToBeSaved);
		
		this.trilhaRepository.delete(trilhaSaved);
		Optional<Trilha> trilhaOptional = this.trilhaRepository.findById(trilhaSaved.getId());
		assertThat(trilhaOptional.isEmpty());
	}
	
	@Test
	@DisplayName("Tests Find by Id returns list of Trilha when successful")
	void findById_ReturnsListOfTrilha_WhenSuccessful() {
		Trilha trilhaToBeSaved = TrilhaCreator.createTrilhaToBeSaved();
		Trilha trilhaSaved = this.trilhaRepository.save(trilhaToBeSaved);
		
		Optional<Trilha> trilhaOptional = this.trilhaRepository.findById(trilhaSaved.getId());
		assertThat(trilhaOptional).isNotEmpty();
		assertThat(trilhaOptional).contains(trilhaSaved);
		
	}

}
