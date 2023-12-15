package com.sogeti.mirav1.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sogeti.mirav1.model.Conseiller;
import com.sogeti.mirav1.model.Conseiller.ConseillerDTOIntf;

@Repository
public interface ConseillerRespository extends JpaRepository<Conseiller, Long> {
}
