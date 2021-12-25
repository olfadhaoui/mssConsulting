package com.olfa.msproduit.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
/**
 * @author olfa dhaoui
 *
 *
 */
@Table(name = "PRODUIT")
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    @Column(nullable = false)
    private String code;
    @Column(nullable = false)
    private String marque;
    @Column(nullable = false)
    private String modele;
    @Column(nullable = false)
    private String caracteristique;
    @Column(nullable = false)
    private BigDecimal prixUnitaire;
    @Column(nullable = false)
    private Long quantite;

    @JsonIgnoreProperties(value="produits", allowSetters=true,allowGetters = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_CATEGORIE",insertable = false,updatable = true)
    private Categorie categorie;



}
