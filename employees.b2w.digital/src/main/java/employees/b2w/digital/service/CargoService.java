package employees.b2w.digital.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import employees.b2w.digital.domain.entity.Cargo;
import employees.b2w.digital.domain.mapper.TrilhaMapper;
import employees.b2w.digital.exception.BadRequestException;
import employees.b2w.digital.repository.CargoRepository;

@Service
public class CargoService {

	@Autowired
	private CargoRepository cargoRepository;
	@Autowired
	private TrilhaService trilhaService;

	public CargoService(CargoRepository cargoRepository,
			TrilhaService trilhaService) {
		this.cargoRepository = cargoRepository;
		this.trilhaService = trilhaService;
	}

	public List<Cargo> getAll() {
		return cargoRepository.findAll();
	}

	public Page<Cargo> getAllPage(Pageable pageable) {
		return cargoRepository.findAll(pageable);
	}

	public Cargo getById(Integer Id) {
		Cargo savedCargo = findByIdCargoOrThrowBadRequestException(Id);
		return savedCargo;
	}

	@Transactional
	public Cargo save(Integer trilhaId, Cargo cargo) {
		TrilhaMapper savedTrilha = findByIdTrilhaOrThrowBadRequestException(
				trilhaId);
		cargo.setTrilhaId(trilhaId);
		return cargoRepository.save(cargo);
	}

	public void update(Integer Id, Cargo cargo) {
		Cargo savedCargo = findByIdCargoOrThrowBadRequestException(Id);
		cargo.setId(savedCargo.getId());
		cargo.setTrilhaId(savedCargo.getTrilha().getId());
		cargoRepository.save(cargo);
	}

	public Cargo findByIdCargoOrThrowBadRequestException(Integer id) {
		return cargoRepository.findById(id)
				.orElseThrow(() -> new BadRequestException("Cargo not Found"));
	}

	public TrilhaMapper findByIdTrilhaOrThrowBadRequestException(Integer id) {
		TrilhaMapper trilha = trilhaService.getById(id);
		if (trilha.getId() == null) {
			throw new BadRequestException("Trilha not Found");
		}
		return trilha;
	}

	public void delete(Integer id) {
		cargoRepository.delete(findByIdCargoOrThrowBadRequestException(id));
	}

}
