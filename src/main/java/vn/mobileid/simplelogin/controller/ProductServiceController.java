package vn.mobileid.simplelogin.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static java.lang.Integer.max;
import vn.mobileid.simplelogin.entity.Product;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
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
        
        String[] productName = {
            "Iphone Xr",
            "Iphone 11",
            "Iphone 11 pro",
            "Iphone 11 pro max",
            "Iphone 12 pro max",
            "Iphone 13 pro max",
            "Iphone 14 pro max",
            "Apple Watch SE",
            "Apple Watch SE2",
            "Apple Watch Serial 6",
        };
        
        for (int i = 0; i < 10; i++) {
//            String name = RandomString.getAlphaNumericString(5);
            Product product = new Product();
            product.setId(Integer.toString(i + 1));
            product.setName(productName[i]);
            product.setColor("Black");
            product.setPrice(10000000);
            product.setDetail("Chi tiết sản phẩm "+ product.getName());
            
            productRepo.put(product.getId(), product);
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
