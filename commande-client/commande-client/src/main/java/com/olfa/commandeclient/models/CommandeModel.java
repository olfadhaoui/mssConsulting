package com.olfa.commandeclient.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.olfa.commandeclient.entities.Client;
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
import java.util.Date;

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

    private BigDecimal total;

    private Long etat;

    @JsonIgnoreProperties(value="commandeModels", allowSetters=true,allowGetters = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_CLIENT",insertable = false,updatable = true)
    private ClientModel clientModel;
}
