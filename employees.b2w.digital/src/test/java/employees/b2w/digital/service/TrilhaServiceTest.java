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
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import employees.b2w.digital.domain.entity.Trilha;
import employees.b2w.digital.domain.mapper.TrilhaMapper;
import employees.b2w.digital.repository.TrilhaRepository;
import employees.b2w.digital.util.TrilhaCreator;


@ExtendWith(SpringExtension.class)
public class TrilhaServiceTest {

	@InjectMocks
	private TrilhaService trilhaService;

	@Mock
	private TrilhaRepository trilhaRepositoryMocks;


	@BeforeEach
	void setUp() {
		
	    trilhaService = new TrilhaService(trilhaRepositoryMocks, new ModelMapper());

		PageImpl<Trilha> trilhaPage = new PageImpl<>(
				List.of(TrilhaCreator.createValidTrilha()));
		
		BDDMockito.when(trilhaRepositoryMocks.findAll(ArgumentMatchers.any(PageRequest.class)))
					.thenReturn(trilhaPage);
		
		BDDMockito.when(trilhaRepositoryMocks.findAll())
					.thenReturn(List.of(TrilhaCreator.createTrilhaToBeSaved()));
		
		BDDMockito.when(trilhaRepositoryMocks.findById(ArgumentMatchers.anyInt()))
					.thenReturn(Optional.of(TrilhaCreator.createValidTrilha()));
		
		BDDMockito.when(trilhaRepositoryMocks.save(ArgumentMatchers.any(Trilha.class)))
					.thenReturn(TrilhaCreator.createValidTrilha());
	   
		BDDMockito.doNothing().when(trilhaRepositoryMocks).delete(ArgumentMatchers.any(Trilha.class));
	}

	@Test
	@DisplayName("getAllPage returns list of trilha inside page object when successuful")
	void getAllPage_ReturnsListOfTrilhasPageObject_WhenSuccessful() {
		
		String expectedName = TrilhaCreator.createValidTrilha().getTrilha_nome();
		Page<Trilha> animePage = trilhaService.getAllPage(PageRequest.of(1, 1));

		Assertions.assertThat(animePage).isNotNull();
		Assertions.assertThat(animePage.toList()).isNotEmpty().hasSize(1);
		Assertions.assertThat(animePage.toList()
						.get(0)
						.getTrilha_nome())
						.isEqualTo(expectedName);
	}
	
	@Test
	@DisplayName("getAll returns list of trilha  when successuful")
	void getAll_ReturnsListOfTrilhas_WhenSuccessful() {
		
		String expectedName = TrilhaCreator.createValidTrilhaMapper().getTrilha_nome();
		List<TrilhaMapper> model = trilhaService.getAll();

		Assertions.assertThat(model).isNotEmpty().isNotNull().hasSize(1);
		Assertions.assertThat(model.get(0)
						.getTrilha_nome()
						.equals(expectedName));
	}
	
	@Test
	@DisplayName("getAllByCargos returns list of trilha and cargos when successuful")
	void getAllByCargos_ReturnsListOfTrilhas_WhenSuccessful() {
		
		List<Trilha> model = trilhaService.getAllByCargos();
		Assertions.assertThat(model)
						.isNotEmpty()
						.isNotNull()
						.hasSize(1);
	}
	
	@Test
	@DisplayName("getById return trilha when successuful")
	void getById_ReturnsTrilhas_WhenSuccessful() {
		
		Integer expectedId = TrilhaCreator.createValidTrilhaMapper().getId();
		TrilhaMapper trilhaMapper = trilhaService.getById(1);
		
		Assertions.assertThat(trilhaMapper).isNotNull();
		Assertions.assertThat(trilhaMapper.getId())
						.isNotNull()
						.isEqualTo(expectedId);
	}
	
	@Test
	@DisplayName("save return trilha when successuful")
	void save_ReturnsTrilha_WhenSuccessful() {
	  
		Trilha trilha = trilhaService.save(TrilhaCreator.createValidTrilha());
		Assertions.assertThat(trilha).isNotNull();
	  
	}

	@Test
	@DisplayName("update return trilha when successuful")
	void update_ReturnsTrilha_WhenSuccessful() {
		
		Assertions.assertThatCode(() -> trilhaService.update(
				TrilhaCreator.createValidTrilha().getId(),
				TrilhaCreator.createValidUpdateTrilha()))
		.doesNotThrowAnyException();
	}
	
	@Test
	@DisplayName("delete remove trilha when successuful")
	void delete_RemoveTrilha_WhenSuccessful() {
		
		Assertions.assertThatCode(() -> trilhaService.delete(1)).doesNotThrowAnyException();
	}
	
}
