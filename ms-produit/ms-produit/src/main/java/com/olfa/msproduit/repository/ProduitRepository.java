package com.olfa.msproduit.repository;

import com.olfa.msproduit.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
    @Query("select entity from Produit entity where entity.code=:code")
    public Produit findByCode(@Param("code") String code);
}
