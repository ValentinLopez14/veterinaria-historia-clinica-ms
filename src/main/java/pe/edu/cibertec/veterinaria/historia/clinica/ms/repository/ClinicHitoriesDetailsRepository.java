package pe.edu.cibertec.veterinaria.historia.clinica.ms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.veterinaria.historia.clinica.ms.entity.ClinicHitoriesDetails;

@Repository
public interface ClinicHitoriesDetailsRepository extends JpaRepository<ClinicHitoriesDetails, Integer>{

	List<ClinicHitoriesDetails> findAllByStatus(Short status);
	
	@Modifying
	@Transactional
	@Query("UPDATE ClinicHitoriesDetails chd SET chd.status = 2 WHERE chd.idClinicHistoryDetail = ?1")
	int disableClinicHistoriesDetailsById(Integer idClinicHistoryDetail);
}
