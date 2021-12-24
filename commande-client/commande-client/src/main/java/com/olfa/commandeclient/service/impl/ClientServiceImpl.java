package com.olfa.commandeclient.service.impl;

import com.olfa.commandeclient.entities.Client;
import com.olfa.commandeclient.mapper.ClientMapper;
import com.olfa.commandeclient.models.ClientModel;
import com.olfa.commandeclient.repository.ClientRepository;
import com.olfa.commandeclient.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author olfa dhaoui
 *
 *
 */
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ClientMapper clientMapper;

    private static final String DATE_FORMAt="dd/MM/yyyy";
    //@Value("${entity.name.client}")
    private String entityName;
    @Override
    public Client create(Client entity) {
        return null;
    }

    @Override
    public ClientModel createM(ClientModel entity) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAt);
        //Test if client with same code exists already
        if (clientRepository.findByCode(entity.getCode())!=null)
            try {
                throw new Exception("The Code " +entity.getCode()+" is already used for "+ entityName);
            } catch (Exception e) {
                e.printStackTrace();
            }

      Client client=Client.builder()
              .id(entity.getId())
              .code(entity.getCode())
              .nom(entity.getNom())
              .prenom(entity.getPrenom())
              .adresse(entity.getAdresse())
              .codePostal(entity.getCodePostal())
              .ville(entity.getVille())
              .dateNaissance(dateFormat.parse(entity.getDateNaissance()))
              .email(entity.getEmail())
              .fax(entity.getFax())
              .gsm(entity.getGsm())
              .tel(entity.getTel())
              .build();
            clientRepository.save(client);
            return clientMapper.toModel(client);
    }

    @Override
    public Client update(Long id, Client entity) throws Exception {
        return null;
    }

    @Override
    public ClientModel updateM(Long id, ClientModel entity) throws Exception {
        if (!clientRepository.findById(id).isPresent())
            throw new Exception(" not found");
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAt);
        Client client=Client.builder()
                .id(id)
                .code(entity.getCode())
                .nom(entity.getNom())
                .prenom(entity.getPrenom())
                .adresse(entity.getAdresse())
                .codePostal(entity.getCodePostal())
                .ville(entity.getVille())
                .dateNaissance(dateFormat.parse(entity.getDateNaissance()))
                .email(entity.getEmail())
                .fax(entity.getFax())
                .gsm(entity.getGsm())
                .tel(entity.getTel())
                .build();
        clientRepository.save(client);
        return clientMapper.toModel(client);
    }

    @Override
    public boolean delete(Long id) throws Exception {
        if (!clientRepository.findById(id).isPresent())
            throw new Exception(" not found");
        clientRepository.deleteById(id);
        return true;
    }

    @Override
    public Client getOne(Long id) throws Exception {
        if (!clientRepository.findById(id).isPresent())
            throw new Exception(" not found");
        Client client = clientRepository.findById(id).get();
        return client;
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public List<ClientModel> getAllM() {
        return null;
    }

    @Override
    public Page<Client> getAll(Pageable pageable) {
        Page<Client> clients = clientRepository.findAll(pageable);
        return new PageImpl<>(clients.getContent(), pageable, clients.getTotalElements());
    }

    @Override
    public Page<ClientModel> getAllM(Pageable pageable) {
        return null;
    }
}
