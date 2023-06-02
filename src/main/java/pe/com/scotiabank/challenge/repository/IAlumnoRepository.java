package pe.com.scotiabank.challenge.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.com.scotiabank.challenge.dao.Alumno;

@Repository
public interface IAlumnoRepository extends CrudRepository<Alumno, Long> {

	List<Alumno> findAllByEstado(Boolean estado);
}
