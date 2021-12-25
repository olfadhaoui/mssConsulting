package com.olfa.msproduit.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.olfa.msproduit.entity.Produit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

/**
 * @author olfa dhaoui
 *
 *
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class CategorieModel implements Serializable {

    private Long id;
    private String code;
    private String libelle;

    @JsonIgnoreProperties(value={"categorieModel"}, allowSetters=true,allowGetters = false)
    @OneToMany(mappedBy = "categorieModel")
    private List<ProduitModel> produitModels;

}
