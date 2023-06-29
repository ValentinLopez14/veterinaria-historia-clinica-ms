package pe.edu.cibertec.veterinaria.historia.clinica.ms.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "clinic_histories")
public class ClinicHistories {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "clinic_history_id")
	private Long idClinicHistory;
	
	@Column(name = "pet_id")
	private Integer petId;
	
	private Short status = 1;  

}
