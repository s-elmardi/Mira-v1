package com.sogeti.mirav1.controller;

import com.sogeti.mirav1.model.Agence;
import com.sogeti.mirav1.model.Conseiller;
import com.sogeti.mirav1.repository.ConseillerRespository;
import com.sogeti.mirav1.model.Conseiller.ConseillerDTOIntf;
import com.sogeti.mirav1.exception.ResourceNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ConseillerController {

	@Autowired
	private ConseillerRespository conseillerRepository;

	// get all conseillers
	@GetMapping("/conseillers")
	public List<Conseiller> getAllConseiller() {
		return conseillerRepository.findAll();
	}

	// get conseiller by id rest api
	@GetMapping("/conseillers/{id}")
	public ResponseEntity<Conseiller> getConseillerById(@PathVariable Long id) {
		Conseiller conseillers = conseillerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Conseiller not exist with id :" + id));
		return ResponseEntity.ok(conseillers);
	}

	// create conseiller rest api
	@PostMapping("/conseillers")
	public Conseiller createConseiller(@RequestBody Conseiller conseillers) {
		//conseillers.setTotal(conseillers.getTel()+conseillers.getHindi()+conseillers.getEng()+conseillers.getMaths()+conseillers.getSci()+conseillers.getSocial());
		return conseillerRepository.save(conseillers);
	}

	// create conseillers list rest api
	@PostMapping("/conseillersAll")
	public List<Conseiller> createConseillerAll(@RequestBody List<Conseiller> conseillers) {
		return conseillerRepository.saveAll(conseillers);
	}

	// update conseiller rest api
	@PutMapping("/conseillers/{id}")
	public ResponseEntity<Conseiller> updateConseiller(@PathVariable Long id, @RequestBody Conseiller conseillerDetails) {
		Conseiller conseillers = conseillerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Conseiller not exist with id :" + id));

		conseillers.setConsCivile(conseillerDetails.getConsCivile());
		conseillers.setConsName(conseillerDetails.getConsName());
		conseillers.setConsPrenom(conseillerDetails.getConsPrenom());
		conseillers.setConsDateNaissance(conseillerDetails.getConsDateNaissance());
		conseillers.setConsTelPro(conseillerDetails.getConsTelPro());
		conseillers.setConsEmailPro(conseillerDetails.getConsEmailPro());
		conseillers.setConsLogin(conseillerDetails.getConsLogin());
		conseillers.setConsPassword(conseillerDetails.getConsPassword());
		conseillers.setConsAdmin(conseillerDetails.getConsAdmin());
		conseillers.setAgence(conseillerDetails.getAgence());

		Conseiller updatedConseiller = conseillerRepository.save(conseillers);
		return ResponseEntity.ok(updatedConseiller);
	}

	// delete conseiller rest api
	@DeleteMapping("/conseillers/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteConseiller(@PathVariable Long id) {
		Conseiller conseillers = conseillerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Conseiller not exist with id :" + id));

		conseillerRepository.delete(conseillers);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}