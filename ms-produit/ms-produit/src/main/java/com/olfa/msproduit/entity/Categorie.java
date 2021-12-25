package com.olfa.msproduit.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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
@Table(name = "CATEGORIE")
public class Categorie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    @Column(nullable = false)
    private String code;
    @Column(nullable = false)
    private String libelle;

    @JsonIgnoreProperties(value={"categorie"}, allowSetters=true,allowGetters = false)
    @OneToMany(mappedBy = "categorie")
    private List<Produit> produits;


}
