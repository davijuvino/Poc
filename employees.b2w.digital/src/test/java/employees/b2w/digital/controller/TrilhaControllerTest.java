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

import employees.b2w.digital.domain.entity.Trilha;
import employees.b2w.digital.domain.mapper.TrilhaMapper;
import employees.b2w.digital.service.TrilhaService;
import employees.b2w.digital.util.TrilhaCreator;

@ExtendWith(SpringExtension.class)
public class TrilhaControllerTest {

	
	@InjectMocks
	private TrilhaController trilhaController;
	
	@Mock
	private TrilhaService trilhaServiceMocks;
	
	
	/* Metodo q realizar o Mock ou seja um comportamento no serviço para todos testes  */
	@BeforeEach
	void setUp() {
		
		PageImpl<Trilha> trilhaPage = new PageImpl<>(List.of(TrilhaCreator.createValidTrilha()));
		
		BDDMockito.when(trilhaServiceMocks.getAllPage(ArgumentMatchers.any()))
			.thenReturn(trilhaPage);
		
		BDDMockito.when(trilhaServiceMocks.getAll())
		.thenReturn(List.of(TrilhaCreator.createValidTrilhaMapper()));
		
		BDDMockito.when(trilhaServiceMocks.findByIdOrThrowBadRequestException(ArgumentMatchers.anyInt()))
			.thenReturn(TrilhaCreator.createValidTrilha());
		
		BDDMockito.when(trilhaServiceMocks.getById(ArgumentMatchers.anyInt()))
		.thenReturn(TrilhaCreator.createValidTrilhaMapper());
		
		BDDMockito.when(trilhaServiceMocks.save(ArgumentMatchers.any(Trilha.class)))
			.thenReturn(TrilhaCreator.createValidTrilha());
		
		BDDMockito.doNothing().when(trilhaServiceMocks).update(ArgumentMatchers.anyInt(), ArgumentMatchers.any(Trilha.class));
		
		BDDMockito.doNothing().when(trilhaServiceMocks).delete(ArgumentMatchers.anyInt());
		
		 
	}
	
	@Test
	@DisplayName("List returns list of trilha inside page object when successuful")
	void get_ReturnsListOfTrilhaInsidePageObject_WhenSuccessful() {
		String expectedName = TrilhaCreator.createValidTrilha().getTrilha_nome();
		
		Page<Trilha> trilhaPage = trilhaController.getAllPage(null).getBody();
		
		Assertions.assertThat(trilhaPage).isNotNull();
		Assertions.assertThat(trilhaPage.toList()).isNotEmpty();
		Assertions.assertThat(trilhaPage.toList())
			.isNotEmpty()
			.hasSize(1);
		
		Assertions.assertThat(trilhaPage.toList().get(0).getTrilha_nome()).isEqualTo(expectedName);
	}
	
	@Test
	@DisplayName("ListAll returns list of trilha  when successuful")
	void getAll_ReturnsListOfTrilhasInsidePageObject_WhenSuccessful() {
		String expectedName = TrilhaCreator.createValidTrilha().getTrilha_nome();
		
		List<TrilhaMapper> trilhas = trilhaController.getAll().getBody();
		
		Assertions.assertThat(trilhas)
			.isNotEmpty()
			.isNotNull()
			.hasSize(1);
		
		Assertions.assertThat(trilhas.get(0).getTrilha_nome()).isEqualTo(expectedName);
	}
	
	@Test
	@DisplayName("findById return trilha when successuful")
	void getById_ReturnsTrilhas_WhenSuccessful() {
		Integer expectedId = TrilhaCreator.createValidTrilhaMapper().getId();
		
		TrilhaMapper trilhaMapper = trilhaController.getById(1).getBody();
		
		Assertions.assertThat(trilhaMapper).isNotNull();
		Assertions.assertThat(trilhaMapper.getId()).isNotNull().isEqualTo(expectedId);
	}
	
		
	@Test
	@DisplayName("save return trilha when successuful")
	void create_ReturnsTrilha_WhenSuccessful() {
	  
	   Trilha trilha = trilhaController.create(TrilhaCreator.createValidTrilha()).getBody();
	   Assertions.assertThat(trilha).isNotNull();
	  
	  }
  
}

