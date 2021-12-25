package com.olfa.commandeclient.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.olfa.commandeclient.entities.Client;
import com.olfa.commandeclient.entities.LigneCommande;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
public class CommandeModel implements Serializable {
    private Long id;

    private String date;
    private String numero;
    private BigDecimal prixTotal;

    private Long etat;

    @JsonIgnoreProperties(value="commandeModels", allowSetters=true,allowGetters = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_CLIENT",insertable = false,updatable = true)
    private ClientModel clientModel;

    @JsonIgnoreProperties(value={"commandeModel"}, allowSetters=true,allowGetters = false)
    @OneToMany(mappedBy = "commandeModel")
    private List<LigneCommandeModel> ligneCommandeModels;
}
