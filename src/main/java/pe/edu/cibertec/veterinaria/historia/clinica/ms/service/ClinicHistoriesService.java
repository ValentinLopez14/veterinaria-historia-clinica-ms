package pe.edu.cibertec.veterinaria.historia.clinica.ms.service;

import java.util.List;

import pe.edu.cibertec.veterinaria.historia.clinica.ms.entity.ClinicHistories;

public interface ClinicHistoriesService {
	
	ClinicHistories register(ClinicHistories clinicHistories);
	
	ClinicHistories update(ClinicHistories clinicHistories);
	
	List<ClinicHistories> listAll();
	
	ClinicHistories findClinicHistoriesById(Integer idClinicHistory);
	
	Integer disableClinicHistoriesById(Integer idClinicHistory);

}
