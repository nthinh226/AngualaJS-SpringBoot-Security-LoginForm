package vn.mobileid.simplelogin.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import vn.mobileid.simplelogin.entity.Product;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import vn.mobileid.simplelogin.utils.RandomString;

/**
 *
 * @author MSI-NT
 */
@RestController
@RequestMapping
public class ProductServiceController {

    private static final Map<String, Product> productRepo = new HashMap<>();

    static {

        for (int i = 0; i < 15; i++) {
            String name = RandomString.getAlphaNumericString(5);
            Product produc = new Product();
            produc.setId(Integer.toString(i + 1));
            produc.setName(name);
            productRepo.put(produc.getId(), produc);
        }

    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") String id) {
        productRepo.remove(id);
        return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/get-products", method = RequestMethod.GET)
    public ResponseEntity<Object> getproduct() {
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }
    

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        productRepo.put(product.getId(), product);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }
}
