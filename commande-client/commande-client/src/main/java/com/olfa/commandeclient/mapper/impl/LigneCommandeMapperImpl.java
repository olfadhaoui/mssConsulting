package com.olfa.commandeclient.mapper.impl;

import com.olfa.commandeclient.entities.LigneCommande;
import com.olfa.commandeclient.mapper.LigneCommandeMapper;
import com.olfa.commandeclient.models.LigneCommandeModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.util.List;

public class LigneCommandeMapperImpl implements LigneCommandeMapper {
    @Autowired
    LigneCommandeMapper ligneCommandeMapper;
    @Override
    public LigneCommande toEntity(LigneCommandeModel ligneCommandeModel) throws ParseException {
        return null;
    }

    @Override
    public LigneCommandeModel toModel(LigneCommande ligneCommande) {
        return null;
    }

    @Override
    public List<LigneCommande> toListEntity(List<LigneCommandeModel> modelList) {
        return null;
    }

    @Override
    public List<LigneCommandeModel> toListModel(List<LigneCommande> entityList) {
        return null;
    }
}
