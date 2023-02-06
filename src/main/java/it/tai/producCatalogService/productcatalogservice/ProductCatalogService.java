package it.tai.producCatalogService.productcatalogservice;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

//identifica la classe come restful service (annotazione di Spring MVC)
@RestController
public class ProductCatalogService
{
    private static Map<String,Product> productCatalog = new HashMap<>();

    //identifica l'oerazione REST POST(annotazione di Spring MVC)
    @PostMapping("/product")
    public String addProduct(@RequestBody Product product)
    {
        productCatalog.put(product.getId(), product);
        return "product added succesfully";
    }

    //identifica l'oerazione REST GET(annotazione di Spring MVC)
    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable String id)
    {
        Product p = null;
        if((p = productCatalog.get(id)) == null)
            p = new Product("noProductFound","no product found", "no product found","",0.0);
        return p;
    }

    //identifica l'oerazione REST PUT(annotazione di Spring MVC)
    @PutMapping("/product")
    public String putProduct(@RequestBody Product product)
    {
        productCatalog.put(product.getId(), product);
        return "product updated successfully";
    }

    //identifica l'oerazione REST DELETE(annotazione di Spring MVC)
    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable String id)
    {
        productCatalog.remove(id);
        return "product deleted successfully";
    }
}