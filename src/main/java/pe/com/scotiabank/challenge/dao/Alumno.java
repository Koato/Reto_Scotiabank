package pe.com.scotiabank.challenge.dao;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "alumno")
public class Alumno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Positive(message = "El identificador debe ser positivo")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(nullable = false, unique = true)
	@NotNull(message = "El identificador no debe ser nulo")
	@NotEmpty(message = "El identificador no debe estar vacío")
	private Long id;

	@NotNull(message = "El nombre no debe ser nulo")
	@NotEmpty(message = "El nombre no debe estar vacío")
	@Size(min = 1, max = 255, message = "El nombre debe tener un valor entre los rangos 1 al 255")
	private String nombre;

	@NotNull(message = "El apellido no debe ser nulo")
	@NotEmpty(message = "El apellido no debe estar vacío")
	@Size(min = 1, max = 255, message = "El apellido debe tener un valor entre los rangos 1 al 255")
	private String apellido;

	@NotNull(message = "El estado no debe ser nula")
	//@Pattern(regexp = "^true$|^false$", message = "El estado ingresado debe ser true o false")
	private Boolean estado;

	@NotNull(message = "La edad no debe ser nula")
	@Positive(message = "La edad debe ser positiva")
	@Min(value = 1, message = "Edad debe ser mínimo 1")
	@Max(value = 150, message = "Edad debe ser máximo 150")
	private Integer edad;
}
