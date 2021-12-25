package com.olfa.msproduit.repository;

import com.olfa.msproduit.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author olfa dhaoui
 *
 *
 */
public interface CategorieRepository extends JpaRepository<Categorie,Long> {
    @Query("select entity from Categorie entity where entity.code=:code")
    public Categorie findByCode(@Param("code") String code);
}
