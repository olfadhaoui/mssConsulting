package com.olfa.commandeclient.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.olfa.commandeclient.models.ProduitModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author olfa dhaoui
 *
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Table(name = "LIGNE_COMMANDE")
public class LigneCommande implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    @Column(nullable = false)
    private Long qte;
    @Column(nullable = false)
    private BigDecimal prixUnitaire;
    @Column(nullable = false)
    private BigDecimal prixTotal;
    @Column(nullable = false)
    private Long etat;


    @JsonIgnoreProperties(value="ligneCommandes", allowSetters=true,allowGetters = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_COMMANDE",insertable = false,updatable = true)
    private Commande commande;


    @Transient
    private ProduitModel produitModel;
    @Column(name = "ID_PRODUIT")
    private Long idProduit;

}
