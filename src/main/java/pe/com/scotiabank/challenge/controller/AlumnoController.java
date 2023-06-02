package pe.com.scotiabank.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.scotiabank.challenge.dao.Alumno;
import pe.com.scotiabank.challenge.services.IAlumnoServices;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/alumno")
public class AlumnoController {
	
	@Autowired
	private IAlumnoServices iAlumnoServices;

	@GetMapping(value = "/actives")
	public ResponseEntity<List<Alumno>> getActives() {
		return ResponseEntity.ok(iAlumnoServices.getAlumnosActive());
	}

	@PostMapping
	public ResponseEntity<Object> insertarRegistro(@RequestBody(required = true) @Valid Alumno alumno) {
		Map<String, Object> response = new HashMap<>();
		try {
			iAlumnoServices.saveAlumno(alumno);
			response.put("mensaje", "Ha sido insertado con éxito");
			response.put("registro", alumno);
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			response.put("mensaje", "Error al insertarlo en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMessage()));
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
