package com.olfa.msproduit.service.impl;

import com.olfa.msproduit.entity.Categorie;
import com.olfa.msproduit.entity.Produit;
import com.olfa.msproduit.model.ProduitModel;
import com.olfa.msproduit.repository.CategorieRepository;
import com.olfa.msproduit.repository.ProduitRepository;
import com.olfa.msproduit.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author olfa dhaoui
 *
 *
 */
@Service
public class ProduitServiceImpl implements ProduitService {
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private CategorieRepository categorieRepository;

    @Value("${entity.name.produit}")
    private String entityName;


    @Override
    public Produit create(Produit entity) throws Exception {
        if (produitRepository.findByCode(entity.getCode())!=null)
            throw new Exception("The Code " +entity.getCode()+" is already used for "+ entityName);
        return produitRepository.save(entity);
    }

    @Override
    public Produit update(Long id, Produit entity) throws Exception {
        if (!produitRepository.findById(id).isPresent())
            throw new Exception("Unable to find " + entityName + " with id " + id);
        if ((!produitRepository.findById(id).get().getCode().equals(entity.getCode())) &&
                produitRepository.findByCode(entity.getCode())!=null )
            throw new Exception("The Code " +entity.getCode()+" is already used for "+ entityName);

        entity.setId(id);

        return produitRepository.save(entity);
    }

    @Override
    public boolean delete(Long id) throws Exception {
        boolean present = produitRepository.findById(id).isPresent();
        if (!present)
            throw new Exception(entityName + " not found");
        produitRepository.deleteById(id);
        return true;
    }

    @Override
    public Produit getOne(Long id) throws Exception {
        if (!produitRepository.findById(id).isPresent())
            throw new Exception("Unable to find " + entityName + " with id " + id);
        return produitRepository.findById(id).get();
    }

    @Override
    public List<Produit> getAll() {

        return produitRepository.findAll();
    }

    @Override
    public Page<Produit> getAll(Pageable pageable) {
        Page<Produit> produits= produitRepository.findAll(pageable);
        return new PageImpl<>(produits.getContent(), pageable, produits.getTotalElements());
    }

    @Transactional
    @Override
    public Produit addCategoryToProduit(Long idProduit, Long idCategorie) throws Exception {
        if (!produitRepository.findById(idProduit).isPresent())
            throw new Exception(" not found");
        if (!categorieRepository.findById(idCategorie).isPresent())
            throw new Exception(" not found");
        Produit produit= produitRepository.getOne(idProduit);
        Categorie categorie=categorieRepository.getOne(idCategorie);
       produit.setCategorie(categorie);

        return produit;
    }
}
