package com.olfa.commandeclient.repository;

import com.olfa.commandeclient.entities.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande,Long> {
}
