package com.hama.microPaiement.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hama.microPaiement.model.Paiement;

@Repository
public interface PaiementDao extends JpaRepository<Paiement, Integer> {
	
	Paiement findByIdCommande(int idCommande);

}
