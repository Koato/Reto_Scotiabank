package pe.com.scotiabank.challenge.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.scotiabank.challenge.dao.Alumno;
import pe.com.scotiabank.challenge.repository.IAlumnoRepository;
import pe.com.scotiabank.challenge.services.IAlumnoServices;

import javax.swing.text.html.Option;

@Service("iAlumnoServices")
public class AlumnoImpl implements IAlumnoServices {

	@Autowired
	IAlumnoRepository alumnoRepository;

	@Override
	public List<Alumno> getAlumnosActive() {
		return alumnoRepository.findAllByEstado(true);
	}

	@Override
	public void saveAlumno(Alumno alumno) throws Exception {
		Optional<Alumno> optionalAlumno = alumnoRepository.findById(alumno.getId());
		if(!optionalAlumno.isPresent()){
			alumnoRepository.save(alumno);
		} else {
			throw new Exception("El alumno con identificador '" + alumno.getId() + "' ya se encuentra registrado.");
		}
	}
}
