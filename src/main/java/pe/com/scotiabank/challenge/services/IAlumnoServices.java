package pe.com.scotiabank.challenge.services;

import java.util.List;
import pe.com.scotiabank.challenge.dao.Alumno;

public interface IAlumnoServices {
	
	List<Alumno> getAlumnosActive();

	void saveAlumno(Alumno alumno) throws Exception;
}