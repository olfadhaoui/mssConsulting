package com.olfa.msproduit.controller;

import com.olfa.msproduit.entity.Produit;
import com.olfa.msproduit.model.ProduitModel;
import com.olfa.msproduit.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/produits")
public class ProduitController extends BaseController<Produit, ProduitModel,Long> {
@Autowired
    ProduitService produitService;
    @PutMapping("/{idProduit}/categorie/{idCategorie}")
    public ResponseEntity<Object> addCategorieToProduit(@PathVariable Long idProduit, @PathVariable Long idCategorie )
    {
        Produit entity;
        try {
            entity= produitService.addCategoryToProduit(idProduit,idCategorie);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(entity);

    }
}
