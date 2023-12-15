package com.sogeti.mirav1.controller;

import com.sogeti.mirav1.model.Agence;
import com.sogeti.mirav1.repository.AgenceRespository;
import com.sogeti.mirav1.exception.ResourceNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
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

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class AgenceController {

	@Autowired
	private AgenceRespository agenceRepository;

	// get all agences
	@GetMapping("/agences")
	public List<Agence> getAllAgence() {
		return agenceRepository.findAll();
	}

	// get agence by id rest api
	@GetMapping("/agences/{id}")
	public ResponseEntity<Agence> getAgenceById(@PathVariable Long id) {
		Agence agences = agenceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Agence not exist with id :" + id));
		return ResponseEntity.ok(agences);
	}

	// create agence rest api
	@PostMapping("/agences")
	public Agence createAgence(@RequestBody Agence agences) {
		return agenceRepository.save(agences);
	}
	// create agences list rest api
	@PostMapping("/agencesAll")
	public List<Agence> createAgence(@RequestBody List<Agence> agences) {
		return agenceRepository.saveAll(agences);
	}

	// update agence rest api
	@PutMapping("/agences/{id}")
	public ResponseEntity<Agence> updateAgence(@PathVariable Long id, @RequestBody Agence agenceDetails) {
		Agence agences = agenceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Agence not exist with id :" + id));

		agences.setAgcCode(agenceDetails.getAgcCode());
		agences.setBanque(agenceDetails.getBanque());

		Agence updatedAgence = agenceRepository.save(agences);
		return ResponseEntity.ok(updatedAgence);
	}

	// delete agence rest api
	@DeleteMapping("/agences/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteAgence(@PathVariable Long id) {
		Agence agences = agenceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("agence not exist with id :" + id));
		agenceRepository.delete(agences);

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}