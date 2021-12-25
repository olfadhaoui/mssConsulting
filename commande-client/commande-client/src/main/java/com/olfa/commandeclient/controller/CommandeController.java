package com.olfa.commandeclient.controller;

import com.olfa.commandeclient.entities.Commande;
import com.olfa.commandeclient.models.CommandeModel;
import com.olfa.commandeclient.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author olfa dhaoui
 *
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/commandes")
public class CommandeController extends  BaseController<Commande, CommandeModel,Long>{

    @Autowired
    CommandeService commandeService;
    @PutMapping("/{idCommande}/client/{idClient}")
    public ResponseEntity<Object> addClientToCommande(@PathVariable Long idCommande, @PathVariable Long idClient )
    {
        Commande entity;
        try {
            entity= commandeService.addClientToCommande(idCommande,idClient);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(entity);

    }
}
