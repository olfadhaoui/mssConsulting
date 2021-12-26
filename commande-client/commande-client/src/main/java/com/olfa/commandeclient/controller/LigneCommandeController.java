package com.olfa.commandeclient.controller;

import com.olfa.commandeclient.entities.LigneCommande;
import com.olfa.commandeclient.models.LigneCommandeModel;
import com.olfa.commandeclient.service.LigneCommandeService;
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
@RequestMapping("/lignes-commandes")
public class LigneCommandeController extends BaseController<LigneCommande, LigneCommandeModel,Long> {
    @Autowired
    LigneCommandeService ligneCommandeService;
    @PutMapping("/{idLigneCommande}/commande/{idCommande}")
    public ResponseEntity<Object> addCommandeToLigneCommande(@PathVariable Long idLigneCommande,
                                                             @PathVariable Long idCommande )
    {
        LigneCommande entity;
        try {
            entity= ligneCommandeService.addCommandeToLigneCommande(idLigneCommande,idCommande);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(entity);

    }
}
