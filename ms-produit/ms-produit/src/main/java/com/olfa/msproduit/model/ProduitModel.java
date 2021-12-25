package com.olfa.msproduit.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.olfa.msproduit.entity.Categorie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author olfa dhaoui
 *
 *
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class ProduitModel implements Serializable {
    private Long id;
    private String code;
    private String marque;
    private String modele;
    private String caracteristique;
    private BigDecimal prixUnitaire;
    private Long quantite;

    @JsonIgnoreProperties(value="produitModels", allowSetters=true,allowGetters = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_CATEGORIE",insertable = false,updatable = true)
    private CategorieModel categorieModel;
}
