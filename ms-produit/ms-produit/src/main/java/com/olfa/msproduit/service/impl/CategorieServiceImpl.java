package com.olfa.msproduit.service.impl;

import com.olfa.msproduit.entity.Categorie;
import com.olfa.msproduit.entity.Produit;
import com.olfa.msproduit.repository.CategorieRepository;
import com.olfa.msproduit.repository.ProduitRepository;
import com.olfa.msproduit.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author olfa dhaoui
 *
 *
 */
@Service
public class CategorieServiceImpl implements CategorieService {
    @Autowired
    private CategorieRepository categorieRepository;

    @Value("${entity.name.categorie}")
    private String entityName;
    @Override
    public Categorie create(Categorie entity) throws Exception {
        if (categorieRepository.findByCode(entity.getCode())!=null)
            throw new Exception("The Code " +entity.getCode()+" is already used for "+ entityName);
        return categorieRepository.save(entity);

    }

    @Override
    public Categorie update(Long id, Categorie entity) throws Exception {
        if (!categorieRepository.findById(id).isPresent())
            throw new Exception("Unable to find " + entityName + " with id " + id);
        if ((!categorieRepository.findById(id).get().getCode().equals(entity.getCode())) &&
                categorieRepository.findByCode(entity.getCode())!=null )
            throw new Exception("The Code " +entity.getCode()+" is already used for "+ entityName);

        entity.setId(id);

        return categorieRepository.save(entity);
    }

    @Override
    public boolean delete(Long id) throws Exception {
        boolean present = categorieRepository.findById(id).isPresent();
        if (!present)
            throw new Exception(entityName + " not found");
        categorieRepository.deleteById(id);
        return true;
    }

    @Override
    public Categorie getOne(Long id) throws Exception {
        if (!categorieRepository.findById(id).isPresent())
            throw new Exception("Unable to find " + entityName + " with id " + id);
        return categorieRepository.findById(id).get();
    }

    @Override
    public List<Categorie> getAll() {

        return categorieRepository.findAll();
    }

    @Override
    public Page<Categorie> getAll(Pageable pageable) {
        Page<Categorie> categories= categorieRepository.findAll(pageable);
        return new PageImpl<>(categories.getContent(), pageable, categories.getTotalElements());
    }
}
