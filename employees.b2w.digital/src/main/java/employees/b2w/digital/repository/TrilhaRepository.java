package employees.b2w.digital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import employees.b2w.digital.domain.entity.Trilha;

@Repository
public interface TrilhaRepository extends JpaRepository<Trilha, Integer> {

}
