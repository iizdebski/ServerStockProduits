package com.izdebski.stock.config.initData;

import com.izdebski.stock.entity.Produit;
import com.izdebski.stock.repository.ProduitRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class InitProducts implements ApplicationRunner {
    private final ProduitRepository produitRepository;

    public InitProducts(ProduitRepository produitRepository){
        this.produitRepository = produitRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Init Products ......");

        produitRepository.save(new Produit("Livre", 50, 20));
        produitRepository.save(new Produit("Cahier", 200, 5.25f));
        produitRepository.save(new Produit("Stylo", 500, 2.10f));
    }
}