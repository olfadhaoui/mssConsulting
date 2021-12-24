package com.olfa.commandeclient.mapper.impl;

import com.olfa.commandeclient.entities.Client;
import com.olfa.commandeclient.mapper.ClientMapper;
import com.olfa.commandeclient.models.ClientModel;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientMapperImpl implements ClientMapper {
    private static final String DATE_FORMAt="dd/MM/yyyy";
    @Override
    public Client toEntity(ClientModel clientModel) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAt);
        if(clientModel==null) return null;
        return Client.builder()
                .id(clientModel.getId())
                .code(clientModel.getCode())
                .nom(clientModel.getNom())
                .prenom(clientModel.getPrenom())
                .adresse(clientModel.getAdresse())
                .codePostal(clientModel.getCodePostal())
                .ville(clientModel.getVille())
                .dateNaissance(dateFormat.parse(clientModel.getDateNaissance()))
                .email(clientModel.getEmail())
                .fax(clientModel.getFax())
                .gsm(clientModel.getGsm())
                .tel(clientModel.getTel())
                .build();
    }

    @Override
    public ClientModel toModel(Client client) {
        if(client==null) return null;
        return ClientModel.builder()
                .id(client.getId())
                .code(client.getCode())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .adresse(client.getAdresse())
                .codePostal(client.getCodePostal())
                .ville(client.getVille())
                .dateNaissance(client.getDateNaissance().toString())
                .email(client.getEmail())
                .fax(client.getFax())
                .gsm(client.getGsm())
                .tel(client.getTel())
                .build();
    }

    @Override
    public List<Client> toListEntity(List<ClientModel> modelList) {
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
    public List<ClientModel> toListModel(List<Client> entityList) {
        if (entityList==null) return null;
        return entityList.stream().map(e->toModel(e)).collect(Collectors.toList());
    }
}
