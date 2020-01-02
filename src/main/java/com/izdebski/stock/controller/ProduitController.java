package com.izdebski.stock.controller;

import com.izdebski.stock.entity.Produit;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produit")
@CrossOrigin
public class ProduitController extends CrudController<Produit, Long>{


}