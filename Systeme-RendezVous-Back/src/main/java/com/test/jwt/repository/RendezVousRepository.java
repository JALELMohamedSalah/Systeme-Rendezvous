package com.test.jwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.jwt.model.RendezVous;

@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous, Long>{
	List<RendezVous> findByEtat(boolean published);
	  List<RendezVous> findByCommentaire(String commentaire);
	

}
