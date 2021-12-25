package com.olfa.commandeclient.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
