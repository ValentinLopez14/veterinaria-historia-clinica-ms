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

import pe.edu.cibertec.veterinaria.historia.clinica.ms.entity.ClinicHistories;
import pe.edu.cibertec.veterinaria.historia.clinica.ms.service.ClinicHistoriesService;
import pe.edu.cibertec.veterinaria.historia.clinica.ms.util.Response;

@RestController
@RequestMapping("/clinic/histories")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ClinicHistoriesRestController {
	
	private ClinicHistoriesService clinicHistoriesService;
	
	public ClinicHistoriesRestController(ClinicHistoriesService clinicHistoriesService) {
		this.clinicHistoriesService = clinicHistoriesService;
	}
	
	
	@PostMapping
	public ResponseEntity<Response> registerClinicHistories(@RequestBody ClinicHistories clinicHistories){
		
		Response response = new Response();
		
		try {
			
			response.setMessage("Se registró correctamente");
			response.setBody(clinicHistoriesService.register(clinicHistories));
			
		} catch (Exception e) {
			
			response.setMessage("Ocurrio un error al registrar, intente nuevamente");
			System.out.println("Error al intentar registrar " + e.getCause());
			return new ResponseEntity<Response>(response, HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<Response>(response, HttpStatus.CREATED);

	}
	
	
	@PutMapping
	public ResponseEntity<Response> updateClinicHistories(@RequestBody ClinicHistories clinicHistories){
		
		Response response = new Response();
		
		try {
			
			response.setMessage("Se actualizó correctamente");
			response.setBody(clinicHistoriesService.update(clinicHistories));
			
		} catch (Exception e) {
			
			response.setMessage("Ocurrio un error al actualizar, intente nuevamente");
			System.out.println("Error al intentar actualizar " + e.getCause());
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}
	
	
	@GetMapping
	public ResponseEntity<Response> listAllClinicHistories(){
		
		Response response = new Response();
		
		try {
			
			response.setMessage("Lista de historias clínicas");
			response.setBody(clinicHistoriesService.listAll());
			
		} catch (Exception e) {
			
			response.setMessage("Ocurrio un error al listar las historias clínicas, intente nuevamente");
			System.out.println("Error al intentar listar las historias clínicas " + e.getCause());
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}
	
	
	@GetMapping("/{idClinicHistory}")
	public ResponseEntity<Response> findClinicHistoriesById(@PathVariable("idClinicHistory") Integer idClinicHistory){
		
		Response response = new Response();
		
		try {
			
			response.setMessage("Historia Clínica encontrada");
			response.setBody(clinicHistoriesService.findClinicHistoriesById(idClinicHistory));
			
		} catch (Exception e) {
			
			response.setMessage("Ocurrio un error al buscar la historia clínica por ID, intente nuevamente");
			System.out.println("Error al intentar buscar la historia clínica por ID " + e.getCause());
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}
	
	
	@PutMapping("/disable/{idClinicHistory}")
	public ResponseEntity<Response> disableClinicHistoriesById(@PathVariable("idClinicHistory") Integer idClinicHistory){
		
		Response response = new Response();
		
		try {
			
			response.setMessage("Historia Clínica desabilitada");
			response.setBody(clinicHistoriesService.disableClinicHistoriesById(idClinicHistory));
			
		} catch (Exception e) {
			
			response.setMessage("Ocurrio un error al desabilitar la historia clínica por ID, intente nuevamente");
			System.out.println("Error al intentar desabilitar la historia clínica por ID " + e.getCause());
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Response>(response, HttpStatus.OK); 

	}

}
