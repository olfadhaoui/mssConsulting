package com.olfa.commandeclient.service;

import com.olfa.commandeclient.entities.Commande;
import com.olfa.commandeclient.models.CommandeModel;

public interface CommandeService extends BaseService<Commande, CommandeModel,Long>{
    Commande addClientToCommande(Long idCommande, Long idClient) throws Exception;
}
