package com.olfa.commandeclient.repository;

import com.olfa.commandeclient.entities.Client;
import com.olfa.commandeclient.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommandeRepository extends JpaRepository<Commande,Long> {
    @Query("select entity from Commande entity where entity.numero=:numero")
    public Client findByNumero(@Param("numero") String code);
}
