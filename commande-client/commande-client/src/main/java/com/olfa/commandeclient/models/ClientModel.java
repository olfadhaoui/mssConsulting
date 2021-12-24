package com.olfa.commandeclient.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;
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
public class ClientModel implements Serializable {
    private Long id;
    private String code;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String adresse;
    private String ville;
    private Long codePostal;
    private String tel;
    private String fax;
    private String gsm;
    private String email;

}
