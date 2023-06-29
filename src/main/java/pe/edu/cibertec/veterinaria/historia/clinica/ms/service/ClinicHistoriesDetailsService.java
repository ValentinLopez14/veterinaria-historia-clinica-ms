package pe.edu.cibertec.veterinaria.historia.clinica.ms.service;

import java.util.List;

import pe.edu.cibertec.veterinaria.historia.clinica.ms.entity.ClinicHitoriesDetails;

public interface ClinicHistoriesDetailsService {
	
	ClinicHitoriesDetails register(ClinicHitoriesDetails clinicHitoriesDetails);
	
	ClinicHitoriesDetails update(ClinicHitoriesDetails clinicHitoriesDetails);
	
	List<ClinicHitoriesDetails> listAll();
	
	ClinicHitoriesDetails findClinicHitoriesDetailsById(Integer idClinicHistoryDetail);
	
	Integer disableClinicHistoriesDetailsById(Integer idClinicHistoryDetail);

}
