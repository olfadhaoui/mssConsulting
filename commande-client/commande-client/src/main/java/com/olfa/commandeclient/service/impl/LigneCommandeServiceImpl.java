package com.olfa.commandeclient.service.impl;

import com.olfa.commandeclient.entities.LigneCommande;
import com.olfa.commandeclient.models.LigneCommandeModel;
import com.olfa.commandeclient.service.LigneCommandeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;
import java.util.List;

public class LigneCommandeServiceImpl implements LigneCommandeService {
    @Override
    public LigneCommande create(LigneCommande entity) {
        return null;
    }

    @Override
    public LigneCommandeModel createM(LigneCommandeModel entity) throws ParseException {
        return null;
    }

    @Override
    public LigneCommande update(Long id, LigneCommande entity) throws Exception {
        return null;
    }

    @Override
    public LigneCommandeModel updateM(Long id, LigneCommandeModel entity) throws Exception {
        return null;
    }

    @Override
    public boolean delete(Long id) throws Exception {
        return false;
    }

    @Override
    public LigneCommande getOne(Long id) throws Exception {
        return null;
    }

    @Override
    public List<LigneCommande> getAll() {
        return null;
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

    @Override
    public LigneCommande addCommandeToLigneCommande(Long idLigneCommande, Long idCommande) throws Exception {
        return null;
    }
}
