package com.olfa.commandeclient.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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
@Table(name = "CLIENT")
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    @Column(nullable = false)
    private String code;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;
    private Date dateNaissance;
    @Column(nullable = false)
    private String adresse;
    @Column(nullable = false)
    private String ville;
    @Column(nullable = false)
    private Long codePostal;
    private String tel;
    private String fax;
    @Column(nullable = false)
    private String gsm;
    @Column(nullable = false)
    private String email;




}
