package com.hama.microPaiement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hama.microPaiement.Dao.PaiementDao;
import com.hama.microPaiement.exception.PaiementExistantException;
import com.hama.microPaiement.exception.PaiementImpossibleException;
import com.hama.microPaiement.model.Paiement;


@RestController
public class PaiementController {
	
	@Autowired
	PaiementDao paiementDao;
	
	@PostMapping(value = "/Paiements")
	public ResponseEntity<Paiement> payerCommande(@RequestBody Paiement paiement) throws PaiementImpossibleException {
		
		Paiement existPaiement = paiementDao.findByIdCommande(paiement.getIdCommande());
		
		if (existPaiement != null) throw new PaiementExistantException("Cette commande est déjà payée"); 
		
		Paiement nouveauPaiement = paiementDao.save(paiement);
		
		if(nouveauPaiement == null) throw new PaiementImpossibleException("Erreur, impossible d'établir le paiement, réessayez plus tard");
		
		return new ResponseEntity<Paiement>(nouveauPaiement, HttpStatus.CREATED);
	}

}
