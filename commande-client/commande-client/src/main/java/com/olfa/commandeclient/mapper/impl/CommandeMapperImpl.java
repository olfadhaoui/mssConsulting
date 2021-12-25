package com.olfa.commandeclient.mapper.impl;

import com.olfa.commandeclient.entities.Commande;
import com.olfa.commandeclient.mapper.ClientMapper;
import com.olfa.commandeclient.mapper.CommandeMapper;
import com.olfa.commandeclient.models.CommandeModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

public class CommandeMapperImpl implements CommandeMapper {
    @Autowired
    ClientMapper clientMapper;
    private static final String DATE_FORMAt="dd/MM/yyyy";
    @Override
    public Commande toEntity(CommandeModel commandeModel) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAt);
        if(commandeModel==null) return null;
      return Commande.builder()
              .id(commandeModel.getId())
              .etat(commandeModel.getEtat())
              .total(commandeModel.getTotal())
              .date(dateFormat.parse(commandeModel.getDate()))
              .client(clientMapper.toEntity(commandeModel.getClientModel()))
              .build();
    }

    @Override
    public CommandeModel toModel(Commande commande) {
        if(commande==null) return null;
        return CommandeModel.builder()
                .id(commande.getId())
                .etat(commande.getEtat())
                .total(commande.getTotal())
                .date(commande.getDate().toString())
                .clientModel(clientMapper.toModel(commande.getClient()))
                .build();
    }

    @Override
    public List<Commande> toListEntity(List<CommandeModel> modelList) {
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
    public List<CommandeModel> toListModel(List<Commande> entityList) {
        if (entityList==null) return null;
        return entityList.stream().map(e->toModel(e)).collect(Collectors.toList());
    }
}
