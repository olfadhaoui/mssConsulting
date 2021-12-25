package com.olfa.msproduit.controller;

import com.olfa.msproduit.entity.Categorie;
import com.olfa.msproduit.model.CategorieModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/categories")
public class CategorieController extends  BaseController<Categorie, CategorieModel,Long>{

}
