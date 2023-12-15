package com.sogeti.mirav1.repository;

//import java.util.List;

//import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sogeti.mirav1.model.Agence;
//import com.sogeti.mirav1.model.Conseiller;

@Repository
public interface AgenceRespository extends JpaRepository<Agence, Long> {

	
}