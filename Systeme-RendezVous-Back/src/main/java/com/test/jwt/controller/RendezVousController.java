package com.test.jwt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.jwt.model.RendezVous;
import com.test.jwt.repository.RendezVousRepository;

import com.test.jwt.exception.ResourceNotFound;






@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class RendezVousController {
	private static final Error NotFound = null;
	@Autowired
	private RendezVousRepository rdvRepo;
	
	//get all employees
	
	@GetMapping("/rendezvous")
	public List<RendezVous> getAllRendezVous(){
		return rdvRepo.findAll();
	}
	

	// add employee
	@PostMapping("/rendezvous")
	public RendezVous createRednezVous(@RequestBody RendezVous rdv) {
		return rdvRepo.save(rdv);
	}
	
	@GetMapping("/rendezvous/{id}")
	public  ResponseEntity<RendezVous> getRendezVousById(@PathVariable Long id) {
		RendezVous rendezvous= rdvRepo.findById(id)
				.orElseThrow(()->new ResourceNotFound(NotFound));
				return ResponseEntity.ok(rendezvous);
				
			}
	
	
	@PutMapping("/rendezvous/{id}")
	public ResponseEntity<RendezVous> updateRendezVous(@PathVariable Long id,@RequestBody RendezVous UpRdv){
		RendezVous rdv= rdvRepo.findById(id)
					.orElseThrow(()->new ResourceNotFound(NotFound));
		
		rdv.setNom_client(UpRdv.getNom_client());
		rdv.setPrenom_client(UpRdv.getPrenom_client());
		rdv.setCommentaire(UpRdv.getCommentaire());
		rdv.setNumtel(UpRdv.getNumtel());
	    rdv.setDate_rdv(UpRdv.getDate_rdv());
	    rdv.setEtat(UpRdv.getEtat());
	        
	        RendezVous updatedRdv=  rdvRepo.save(rdv);
	       
	       return ResponseEntity.ok(updatedRdv);
	}

	//delete employee
		@DeleteMapping("/rendezvous/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteRendezVous(@PathVariable Long id){
			
			RendezVous ridv= rdvRepo.findById(id)
					.orElseThrow(()->new ResourceNotFound(NotFound));
			
			rdvRepo.delete(ridv);
			Map<String, Boolean> response=new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
			
		}
	
	
		@GetMapping("/rendezvous/etat")
		  public ResponseEntity<List<RendezVous>> findByEtat() {
		    try {
		      List<RendezVous> rendezvous = rdvRepo.findByEtat(true);
		      if (rendezvous.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(rendezvous, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		}
		
		
	}
	
	


