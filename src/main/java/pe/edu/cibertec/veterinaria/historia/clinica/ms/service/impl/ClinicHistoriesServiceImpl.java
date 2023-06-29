package pe.edu.cibertec.veterinaria.historia.clinica.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.veterinaria.historia.clinica.ms.entity.ClinicHistories;
import pe.edu.cibertec.veterinaria.historia.clinica.ms.repository.ClinicHistoriesRepository;
import pe.edu.cibertec.veterinaria.historia.clinica.ms.service.ClinicHistoriesService;

@Service
public class ClinicHistoriesServiceImpl implements ClinicHistoriesService{

	@Autowired
	private ClinicHistoriesRepository clinicHistoriesRepository;
	
	@Override
	public ClinicHistories register(ClinicHistories clinicHistories) {
		
		return clinicHistoriesRepository.save(clinicHistories);
	}

	@Override
	public ClinicHistories update(ClinicHistories clinicHistories) {
		
		return clinicHistoriesRepository.save(clinicHistories);
	}

	@Override
	public List<ClinicHistories> listAll() {
		
		return clinicHistoriesRepository.findAllByStatus((short) 1);
	}

	@Override
	public ClinicHistories findClinicHistoriesById(Integer idClinicHistory) {
		
		return clinicHistoriesRepository.findById(idClinicHistory).get();
	}

	@Override
	public Integer disableClinicHistoriesById(Integer idClinicHistory) {
		
		return clinicHistoriesRepository.disableClinicHistoriesById(idClinicHistory);
	}

}
