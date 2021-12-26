package com.olfa.commandeclient.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.olfa.commandeclient.entities.Commande;
import com.olfa.commandeclient.mapper.LigneCommandeMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class LigneCommandeModel implements Serializable {

    private Long id;

    private Long qte;

    private BigDecimal prixUnitaire;

    private BigDecimal prixTotal;

    private Long etat;

    @JsonIgnoreProperties(value="ligneCommandeModels", allowSetters=true,allowGetters = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_COMMANDE",insertable = false,updatable = true)
    private CommandeModel commandeModel;

    private ProduitModel produitModel;

    private Long idProduit;
}
