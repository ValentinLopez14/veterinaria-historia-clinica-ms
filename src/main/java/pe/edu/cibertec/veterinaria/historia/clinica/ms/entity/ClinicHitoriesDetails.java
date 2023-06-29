package pe.edu.cibertec.veterinaria.historia.clinica.ms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "clinic_histories_details")
public class ClinicHitoriesDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "clinic_history_detail_id")
	private Integer idClinicHistoryDetail;
	
	@Column(name = "clinic_history_id")
	private Integer clinicHistoryId;
	
	@Column(name = "employee_id")
	private Integer employeeId; 
	
	private Double temperature;
	
	private Double weight; 
	
	private String anamnesis;
	
	@Column(name = "differential_diagnosis")
	private String differentialDiagnosis;
	
	@Column(name = "requested_exams")
	private String requestedExams;
	
	private String treatment;   
	
	private Double cost;
	
	private String note; 
	
	private Short status = 1; 

}
