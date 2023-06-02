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
	@Positive(message = "debe ser positivo")
	@NotNull(message = "no debe ser nulo")
	private Long id;

	@NotNull(message = "debe ser nulo")
	@NotEmpty(message = "debe estar vacío")
	@Size(min = 1, max = 255, message = "debe tener un valor entre los rangos 1 al 255")
	private String nombre;

	@NotNull(message = "no debe ser nulo")
	@NotEmpty(message = "no debe estar vacío")
	@Size(min = 1, max = 255, message = "debe tener un valor entre los rangos 1 al 255")
	private String apellido;

	@NotNull(message = " no debe ser nulo")
	//@Pattern(regexp = "^true$|^false$", message = "El estado ingresado debe ser true o false")
	private Boolean estado;

	@NotNull(message = "no debe ser nulo")
	@Positive(message = "debe ser positivo")
	@Min(value = 1, message = "debe ser mínimo 1")
	@Max(value = 150, message = "debe ser máximo 150")
	private Integer edad;
}
