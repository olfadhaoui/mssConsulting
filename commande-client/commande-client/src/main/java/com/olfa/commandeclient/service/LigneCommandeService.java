package com.olfa.commandeclient.service;


import com.olfa.commandeclient.entities.LigneCommande;
import com.olfa.commandeclient.models.LigneCommandeModel;

public interface LigneCommandeService extends BaseService<LigneCommande, LigneCommandeModel,Long> {
    LigneCommande addCommandeToLigneCommande(Long idLigneCommande, Long idCommande) throws Exception;
}
