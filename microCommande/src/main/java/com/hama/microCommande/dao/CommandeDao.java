package com.hama.microCommande.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hama.microCommande.model.Commande;


@Repository
public interface CommandeDao extends JpaRepository<Commande, Integer> {

}
