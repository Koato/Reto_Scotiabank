package pe.com.scotiabank.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pe.com.scotiabank.challenge.dao.Alumno;
import pe.com.scotiabank.challenge.services.IAlumnoServices;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
	public ResponseEntity<Object> insertarRegistro(@Valid @RequestBody(required = true) Alumno alumno, BindingResult result) {
		Map<String, Object> response = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(error -> "El campo '" + error.getField() + "' " + error.getDefaultMessage())
					.collect(Collectors.toList());
			response.put("errors", errors);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
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
