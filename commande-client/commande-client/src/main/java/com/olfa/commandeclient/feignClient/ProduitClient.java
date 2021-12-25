package com.olfa.commandeclient.feignClient;

import com.olfa.commandeclient.models.ProduitModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="service-produit", url = "http://localhost:9017/api")
public interface ProduitClient {

    @GetMapping("/produits/{id}")
    public ProduitModel getOne(@PathVariable Long id) ;


}
