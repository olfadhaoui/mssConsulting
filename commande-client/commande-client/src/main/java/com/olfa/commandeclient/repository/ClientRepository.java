package com.olfa.commandeclient.repository;

import com.olfa.commandeclient.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author olfa dhaoui
 *
 *
 */
public interface ClientRepository extends JpaRepository<Client,Long> {
    @Query("select entity from Client entity where entity.code=:code")
    public Client findByCode(@Param("code") String code);
}
