package com.olfa.commandeclient.service.impl;

import com.olfa.commandeclient.entities.Client;
import com.olfa.commandeclient.entities.Commande;
import com.olfa.commandeclient.mapper.CommandeMapper;
import com.olfa.commandeclient.models.CommandeModel;
import com.olfa.commandeclient.repository.ClientRepository;
import com.olfa.commandeclient.repository.CommandeRepository;
import com.olfa.commandeclient.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
public class CommandeServiceImpl implements CommandeService {
    @Autowired
    CommandeRepository commandeRepository;
    @Autowired
    CommandeMapper commandeMapper;
    @Autowired
    ClientRepository clientRepository;

    private static final String DATE_FORMAt="dd/MM/yyyy";
    @Value("${entity.name.commande}")
    private String entityName;
    @Override
    public Commande create(Commande entity) {
        return null;
    }

    @Override
    public CommandeModel createM(CommandeModel entity) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAt);
        //Test if commande with same numero exists already
        if (commandeRepository.findByNumero(entity.getNumero())!=null)
            try {
                throw new Exception("Le numero " +entity.getNumero()+" is already used for "+ entityName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        Commande commande=Commande.builder()
                .id(entity.getId())
                .numero(entity.getNumero())
                .prixTotal(entity.getPrixTotal())
                .etat(entity.getEtat())
                .date(dateFormat.parse(entity.getDate()))
                .build();
            commandeRepository.save(commande);
            return commandeMapper.toModel(commande);
    }

    @Override
    public Commande update(Long id, Commande entity) throws Exception {
        return null;
    }

    @Override
    public CommandeModel updateM(Long id, CommandeModel entity) throws Exception {
        if (!commandeRepository.findById(id).isPresent())
            throw new Exception(" not found");
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAt);
        Commande commande=Commande.builder()
                .id(id)
                .numero(entity.getNumero())
                .prixTotal(entity.getPrixTotal())
                .etat(entity.getEtat())
                .date(dateFormat.parse(entity.getDate()))
                .build();
        commandeRepository.save(commande);
        return commandeMapper.toModel(commande);

    }

    @Override
    public boolean delete(Long id) throws Exception {
        if (!commandeRepository.findById(id).isPresent())
            throw new Exception(" not found");
        commandeRepository.deleteById(id);
        return true;
    }

    @Override
    public Commande getOne(Long id) throws Exception {
        if (!commandeRepository.findById(id).isPresent())
            throw new Exception(" not found");
        Commande commande=commandeRepository.findById(id).get();
        return commande;
    }

    @Override
    public List<Commande> getAll() {
        return commandeRepository.findAll();
    }

    @Override
    public List<CommandeModel> getAllM() {
        return null;
    }

    @Override
    public Page<Commande> getAll(Pageable pageable) {
        Page<Commande> commandes = commandeRepository.findAll(pageable);
        return new PageImpl<>(commandes.getContent(), pageable, commandes.getTotalElements());
    }

    @Override
    public Page<CommandeModel> getAllM(Pageable pageable) {
        return null;
    }


    @Transactional
    @Override
    public Commande addClientToCommande(Long idCommande, Long idClient) throws Exception {
        if (!commandeRepository.findById(idCommande).isPresent())
            throw new Exception(" not found");
        if (!clientRepository.findById(idClient).isPresent())
            throw new Exception(" not found");
        Commande commande= commandeRepository.getOne(idCommande);
        Client client=clientRepository.getOne(idClient);
        commande.setClient(client);
        return commande;
    }
}
