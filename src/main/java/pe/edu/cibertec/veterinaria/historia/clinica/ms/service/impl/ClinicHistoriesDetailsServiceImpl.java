package pe.edu.cibertec.veterinaria.historia.clinica.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.veterinaria.historia.clinica.ms.entity.ClinicHitoriesDetails;
import pe.edu.cibertec.veterinaria.historia.clinica.ms.repository.ClinicHitoriesDetailsRepository;
import pe.edu.cibertec.veterinaria.historia.clinica.ms.service.ClinicHistoriesDetailsService;

@Service
public class ClinicHistoriesDetailsServiceImpl implements ClinicHistoriesDetailsService{

	@Autowired
	private ClinicHitoriesDetailsRepository clinicHitoriesDetailsRepository;
	
	@Override
	public ClinicHitoriesDetails register(ClinicHitoriesDetails clinicHitoriesDetails) {
		
		return clinicHitoriesDetailsRepository.save(clinicHitoriesDetails);
	}

	@Override
	public ClinicHitoriesDetails update(ClinicHitoriesDetails clinicHitoriesDetails) {
		
		return clinicHitoriesDetailsRepository.save(clinicHitoriesDetails);
	}

	@Override
	public List<ClinicHitoriesDetails> listAll() {
		
		return clinicHitoriesDetailsRepository.findAllByStatus((short) 1);
	}

	@Override
	public ClinicHitoriesDetails findClinicHitoriesDetailsById(Integer idClinicHistoryDetail) {
		
		return clinicHitoriesDetailsRepository.findById(idClinicHistoryDetail).get();
	}
	
	@Override
	public Integer disableClinicHistoriesDetailsById(Integer idClinicHistoryDetail) {
		
		return clinicHitoriesDetailsRepository.disableClinicHistoriesDetailsById(idClinicHistoryDetail);
	}

	

}
