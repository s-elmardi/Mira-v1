package com.sogeti.mirav1.controller;

import com.sogeti.mirav1.model.Banque;
import com.sogeti.mirav1.repository.BanqueRepository;
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
public class BanqueController {

	@Autowired
	private BanqueRepository banqueRepository;

	// get all banques
	@GetMapping("/banques")
	public List<Banque> getAllBanque() {
		return banqueRepository.findAll();
	}

	// create banque rest api
	@PostMapping("/banques")
	public Banque createBanque(@RequestBody Banque banques) {
		return banqueRepository.save(banques);
	}

	// get banque by id rest api
	@GetMapping("/banques/{id}")
	public ResponseEntity<Banque> getBanqueById(@PathVariable Long id) {
		Banque banques = banqueRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Banque not exist with id :" + id));
		return ResponseEntity.ok(banques);
	}

	// update banque rest api
	@PutMapping("/banques/{id}")
	public ResponseEntity<Banque> updateBanque(@PathVariable Long id, @RequestBody Banque banqueDetails) {
		Banque banques = banqueRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Banque not exist with id :" + id));

		banques.setBnqCode(banqueDetails.getBnqCode());
		Banque updatedBanque = banqueRepository.save(banques);
		return ResponseEntity.ok(updatedBanque);
	}

	// delete banque rest api
	@DeleteMapping("/banques/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteBanque(@PathVariable Long id) {
		Banque banques = banqueRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Banque not exist with id :" + id));
		banqueRepository.delete(banques);

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}