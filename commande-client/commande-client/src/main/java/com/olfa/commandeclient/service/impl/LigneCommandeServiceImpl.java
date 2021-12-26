package com.olfa.commandeclient.service.impl;

import com.olfa.commandeclient.entities.Commande;
import com.olfa.commandeclient.entities.LigneCommande;
import com.olfa.commandeclient.feignClient.ProduitClient;
import com.olfa.commandeclient.models.LigneCommandeModel;
import com.olfa.commandeclient.repository.CommandeRepository;
import com.olfa.commandeclient.repository.LigneCommandeRepository;
import com.olfa.commandeclient.service.LigneCommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

public class LigneCommandeServiceImpl implements LigneCommandeService {
    @Autowired
    LigneCommandeRepository ligneCommandeRepository;
    @Autowired
    ProduitClient produitClient ;
    @Autowired
    CommandeRepository commandeRepository;
    @Value("${entity.name.ligneCommande}")
    private String entityName;

    @Override
    public LigneCommande create(LigneCommande entity) {
        return ligneCommandeRepository.save(entity);
    }

    @Override
    public LigneCommandeModel createM(LigneCommandeModel entity) throws ParseException {


        return null;
    }

    @Override
    public LigneCommande update(Long id, LigneCommande entity) throws Exception {
        if (!ligneCommandeRepository.findById(id).isPresent())
            throw new Exception("Unable to find " + entityName + " with id " + id);
        entity.setId(id);

        return ligneCommandeRepository.save(entity);
    }

    @Override
    public LigneCommandeModel updateM(Long id, LigneCommandeModel entity) throws Exception {
        return null;
    }

    @Override
    public boolean delete(Long id) throws Exception {
        boolean present = ligneCommandeRepository.findById(id).isPresent();
        if (!present)
            throw new Exception(entityName + " not found");
        ligneCommandeRepository.deleteById(id);
        return true;
    }

    @Override
    public LigneCommande getOne(Long id) throws Exception {
        if (!ligneCommandeRepository.findById(id).isPresent())
            throw new Exception("  not found");

        LigneCommande ligneCommande = ligneCommandeRepository.findById(id).get();
        if(produitClient.getOne(ligneCommande.getIdProduit())==null)
            throw  new Exception("Produit  inexistant");
        ligneCommande.setProduitModel(produitClient.getOne(ligneCommande.getIdProduit()));

        return ligneCommande;
    }

    @Override
    public List<LigneCommande> getAll() {
        return ligneCommandeRepository.findAll().stream().map(p->{
   LigneCommande ligneCommande=LigneCommande.builder()
           .id(p.getId())
           .etat(p.getEtat())
           .prixTotal(p.getPrixTotal())
           .qte(p.getQte())
           .commande(p.getCommande())
           .produitModel(produitClient.getOne(p.getIdProduit()))
           .build();
            return ligneCommande;
        }).collect(Collectors.toList());
    }

    @Override
    public List<LigneCommandeModel> getAllM() {
        return null;
    }

    @Override
    public Page<LigneCommande> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public Page<LigneCommandeModel> getAllM(Pageable pageable) {
        return null;
    }

    @Transactional
    @Override
    public LigneCommande addCommandeToLigneCommande(Long idLigneCommande, Long idCommande) throws Exception {
        if (!ligneCommandeRepository.findById(idLigneCommande).isPresent())
            throw new Exception(" not found");
        if (!commandeRepository.findById(idCommande).isPresent())
            throw new Exception(" not found");
        LigneCommande ligneCommande= ligneCommandeRepository.getOne(idLigneCommande);
        Commande commande=commandeRepository.getOne(idCommande);
        ligneCommande.setCommande(commande);

        return ligneCommande;
    }
}
