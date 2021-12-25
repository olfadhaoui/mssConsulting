package com.olfa.msproduit.service;

import com.olfa.msproduit.entity.Produit;
import com.olfa.msproduit.model.ProduitModel;

public interface ProduitService extends BaseService< Produit,ProduitModel,Long>{
    Produit addCategoryToProduit(Long idProduit, Long idCategorie) throws Exception;
}
