package com.olfa.commandeclient.service.impl;

import com.olfa.commandeclient.entities.Commande;
import com.olfa.commandeclient.models.CommandeModel;
import com.olfa.commandeclient.service.CommandeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

/**
 * @author olfa dhaoui
 *
 *
 */
@Service
public class CommandeServiceImpl implements CommandeService {
    @Override
    public Commande create(Commande entity) {
        return null;
    }

    @Override
    public CommandeModel createM(CommandeModel entity) throws ParseException {
        return null;
    }

    @Override
    public Commande update(Long id, Commande entity) throws Exception {
        return null;
    }

    @Override
    public CommandeModel updateM(Long id, CommandeModel entity) throws Exception {
        return null;
    }

    @Override
    public boolean delete(Long id) throws Exception {
        return false;
    }

    @Override
    public Commande getOne(Long id) throws Exception {
        return null;
    }

    @Override
    public List<Commande> getAll() {
        return null;
    }

    @Override
    public List<CommandeModel> getAllM() {
        return null;
    }

    @Override
    public Page<Commande> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public Page<CommandeModel> getAllM(Pageable pageable) {
        return null;
    }

    @Override
    public Commande addClientToCommande(Long idCommande, Long idClient) throws Exception {
        return null;
    }
}
