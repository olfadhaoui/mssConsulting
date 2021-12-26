package com.olfa.commandeclient.mapper.impl;

import com.olfa.commandeclient.entities.LigneCommande;
import com.olfa.commandeclient.mapper.CommandeMapper;
import com.olfa.commandeclient.mapper.LigneCommandeMapper;
import com.olfa.commandeclient.models.LigneCommandeModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

public class LigneCommandeMapperImpl implements LigneCommandeMapper {
    @Autowired
    LigneCommandeMapper ligneCommandeMapper;
    @Autowired
    CommandeMapper commandeMapper;
    @Override
    public LigneCommande toEntity(LigneCommandeModel ligneCommandeModel) throws ParseException {
        if(ligneCommandeModel==null) return null;
      return LigneCommande.builder()
              .id(ligneCommandeModel.getId())
              .etat(ligneCommandeModel.getEtat())
              .prixTotal(ligneCommandeModel.getPrixTotal())
              .prixUnitaire(ligneCommandeModel.getPrixUnitaire())
              .qte(ligneCommandeModel.getQte())
              .idProduit(ligneCommandeModel.getIdProduit())
              .produitModel(ligneCommandeModel.getProduitModel())
              .commande(commandeMapper.toEntity(ligneCommandeModel.getCommandeModel()))
              .build();

    }

    @Override
    public LigneCommandeModel toModel(LigneCommande ligneCommande) {
        if(ligneCommande==null) return null;
        return LigneCommandeModel.builder()
                .id(ligneCommande.getId())
                .etat(ligneCommande.getEtat())
                .prixTotal(ligneCommande.getPrixTotal())
                .prixUnitaire(ligneCommande.getPrixUnitaire())
                .qte(ligneCommande.getQte())
                .idProduit(ligneCommande.getIdProduit())
                .produitModel(ligneCommande.getProduitModel())
                .commandeModel(commandeMapper.toModel(ligneCommande.getCommande()))
                .build();

    }

    @Override
    public List<LigneCommande> toListEntity(List<LigneCommandeModel> modelList) {
        if (modelList==null) return null;
        return modelList.stream().map(m-> {
            try {
                return toEntity(m);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());
    }

    @Override
    public List<LigneCommandeModel> toListModel(List<LigneCommande> entityList) {
        if (entityList==null) return null;
        return entityList.stream().map(e->toModel(e)).collect(Collectors.toList());
    }
}
