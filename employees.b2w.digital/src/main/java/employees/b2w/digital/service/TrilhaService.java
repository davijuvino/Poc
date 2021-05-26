package employees.b2w.digital.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import employees.b2w.digital.domain.entity.Trilha;
import employees.b2w.digital.domain.mapper.TrilhaMapper;
import employees.b2w.digital.exception.BadRequestException;
import employees.b2w.digital.repository.TrilhaRepository;

/**
 * @author Davi
 *
 */

@Service
public class TrilhaService {

	@Autowired
	private TrilhaRepository trilhaRepository;

	@Autowired
	private ModelMapper mapper;

	public TrilhaService(TrilhaRepository trilhaRepository,
			ModelMapper mapper) {
		this.trilhaRepository = trilhaRepository;
		this.mapper = mapper;
	}
	
	public Page<Trilha> getAllPage(Pageable pageable) {
		return trilhaRepository.findAll(pageable);
	}
	
	public List<TrilhaMapper> getAll() {
		List<Trilha> trilhas = trilhaRepository.findAll();
		return trilhas.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	public List<Trilha> getAllByCargos() {
		return trilhaRepository.findAll();
	}

	public TrilhaMapper getById(Integer Id) {
		Trilha savedTrilha = findByIdOrThrowBadRequestException(Id);
		return convertToDto(savedTrilha);
	}

	@Transactional
	public Trilha save(Trilha Trilha) {
		return trilhaRepository.save(Trilha);
	}

	public void update(Integer Id, Trilha trilha) {
		Trilha savedTrilha = findByIdOrThrowBadRequestException(Id);
		trilha.setId(savedTrilha.getId());
		trilha.setCargos(trilha.getCargos());
		trilhaRepository.save(trilha);
	}

	public Trilha findByIdOrThrowBadRequestException(Integer id) {
		return trilhaRepository.findById(id)
				.orElseThrow(() -> new BadRequestException("Trilha not Found"));
	}

	public void delete(Integer id) {
		trilhaRepository.delete(findByIdOrThrowBadRequestException(id));
	}

	
	/**
	 * @param trilha
	 * @return converte class mapper model 
	 */
	private TrilhaMapper convertToDto(Trilha trilha) {
		TrilhaMapper trilhaMapper = mapper.map(trilha, TrilhaMapper.class);
		return trilhaMapper;
	}

}
