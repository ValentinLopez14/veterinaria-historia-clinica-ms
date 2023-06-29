package pe.edu.cibertec.veterinaria.historia.clinica.ms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import pe.edu.cibertec.veterinaria.historia.clinica.ms.entity.ClinicHistories;

@Repository
public interface ClinicHistoriesRepository extends JpaRepository<ClinicHistories, Integer>{

	List<ClinicHistories> findAllByStatus(Short status);
	
	@Modifying
	@Transactional
	@Query("UPDATE ClinicHistories ch SET ch.status = 2 WHERE ch.idClinicHistory = ?1")
	int disableClinicHistoriesById(Integer idClinicHistory);
	
}
