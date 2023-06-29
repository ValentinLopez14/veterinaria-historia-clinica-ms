package pe.edu.cibertec.veterinaria.historia.clinica.ms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.cibertec.veterinaria.historia.clinica.ms.entity.ClinicHitoriesDetails;
import pe.edu.cibertec.veterinaria.historia.clinica.ms.service.ClinicHistoriesDetailsService;
import pe.edu.cibertec.veterinaria.historia.clinica.ms.util.Response;

@RestController
@RequestMapping("/clinic/histories/details")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ClinicHistoriesDetailsRestController {
	
	private ClinicHistoriesDetailsService clinicHistoriesDetailsService;
	
	public ClinicHistoriesDetailsRestController(ClinicHistoriesDetailsService clinicHistoriesDetailsService) {
		
		this.clinicHistoriesDetailsService = clinicHistoriesDetailsService;
	}
	
	@PostMapping
	public ResponseEntity<Response> registerClinicHistoriesDetails(@RequestBody ClinicHitoriesDetails clinicHitoriesDetails){
		
		Response response = new Response();
		
		try {
			
			response.setMessage("Se registró correctamente");
			response.setBody(clinicHistoriesDetailsService.register(clinicHitoriesDetails));
			
		} catch (Exception e) {
			
			response.setMessage("Ocurrio un error al registrar, intente nuevamente");
			System.out.println("Error al intentar registrar " + e.getCause());
			return new ResponseEntity<Response>(response, HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<Response>(response, HttpStatus.CREATED);

	}
	
	
	@PutMapping
	public ResponseEntity<Response> updateClinicHistoriesDetails(@RequestBody ClinicHitoriesDetails clinicHitoriesDetails){
		
		Response response = new Response();
		
		try {
			
			response.setMessage("Se actualizó correctamente");
			response.setBody(clinicHistoriesDetailsService.update(clinicHitoriesDetails));
			
		} catch (Exception e) {
			
			response.setMessage("Ocurrio un error al actualizar, intente nuevamente");
			System.out.println("Error al intentar actualizar " + e.getCause());
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}
	
	
	@GetMapping
	public ResponseEntity<Response> listAllClinicHistoriesDetails(){
		
		Response response = new Response();
		
		try {
			
			response.setMessage("Lista de los detalles de las historias clínicas");
			response.setBody(clinicHistoriesDetailsService.listAll());
			
		} catch (Exception e) {

			response.setMessage("Ocurrio un error al listar los detalles declas historias clínicas, intente nuevamente");
			System.out.println("Error al intentar listar los detalles de las historias clínicas " + e.getCause());
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}
	
	
	@GetMapping("/{idClinicHistoryDetail}")
	public ResponseEntity<Response> findClinicHistoriesDetailsById(@PathVariable("idClinicHistoryDetail") Integer idClinicHistoryDetail){
		
		Response response = new Response();
		
		try {
			
			response.setMessage("Detalle de la Historia Clínica encontrada");
			response.setBody(clinicHistoriesDetailsService.findClinicHitoriesDetailsById(idClinicHistoryDetail));
			
		} catch (Exception e) {
		
			response.setMessage("Ocurrio un error al buscar el detalle de la historia clínica por ID, intente nuevamente");
			System.out.println("Error al intentar buscar el detalle de la historia clínica por ID " + e.getCause());
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}
	
	
	@PutMapping("/disable/{idClinicHistoryDetail}")
	public ResponseEntity<Response> disableClinicHistoriesDetailsById(@PathVariable("idClinicHistoryDetail") Integer idClinicHistoryDetail){
		
		Response response = new Response();
		
		try {
			
			response.setMessage("Detalle de la Historia Clínica desabilitada");
			response.setBody(clinicHistoriesDetailsService.disableClinicHistoriesDetailsById(idClinicHistoryDetail));
			
		} catch (Exception e) {
			
			response.setMessage("Ocurrio un error al desabilitar el detalle de la historia clínica por ID, intente nuevamente");
			System.out.println("Error al intentar desabilitar el detalle de la historia clínica por ID " + e.getCause());
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Response>(response, HttpStatus.OK); 

	}

}
