package com.sogeti.mirav1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sogeti.mirav1.model.Banque;

@Repository
public interface BanqueRepository extends JpaRepository<Banque, Long> {

}