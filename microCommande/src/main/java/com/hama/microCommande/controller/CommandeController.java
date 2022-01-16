package com.hama.microCommande.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hama.microCommande.dao.CommandeDao;
import com.hama.microCommande.exception.CommandeNotFoundException;
import com.hama.microCommande.exception.ImpossibleAjouterCommandeException;
import com.hama.microCommande.model.Commande;

@RestController
public class CommandeController {
	
	@Autowired
	CommandeDao commandeDao;
	@PostMapping(value = "/Commandes")
	public ResponseEntity<Commande> addCommande(@RequestBody Commande commande) throws ImpossibleAjouterCommandeException {
		
		Commande NouvelleCommande = commandeDao.save(commande);
		
		if (NouvelleCommande == null) throw new ImpossibleAjouterCommandeException("Impossible d'ajouter cette commande");
		
		return new ResponseEntity<Commande>(commande, HttpStatus.CREATED);
		
	}
	
	@GetMapping(value ="/Commandes/{id}")
	public Optional<Commande> getCommandeById(@PathVariable Integer id) {
		
		Optional<Commande> commande = commandeDao.findById(id);
		
		if(!commande.isPresent()) throw new CommandeNotFoundException("Cette commande n'existe pas");
		
		return commande;
	}

}
