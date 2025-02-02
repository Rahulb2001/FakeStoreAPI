package com.scaler.FakeStore.Controller;


import com.scaler.FakeStore.Exception.ProductException;
import com.scaler.FakeStore.Model.Product;
import com.scaler.FakeStore.Projection.getDesCriptionTitlePriceImage;
import com.scaler.FakeStore.Service.ProductDeclaration;
import com.scaler.FakeStore.Service.ProductServices;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductDeclaration productDeclaration;

    public ProductController(@Qualifier("selfProductService") ProductDeclaration productDeclaration) {
        this.productDeclaration = productDeclaration;
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getallProducts() {

        return  new ResponseEntity<>(productDeclaration.findallProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id)  throws ProductException {

        return new ResponseEntity<>(productDeclaration.findProductById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product,
                                 @PathVariable("id") Long id) {
        return new ResponseEntity<>(productDeclaration.updateProduct(product,id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable("id") Long id) {

        return new ResponseEntity<>(productDeclaration.deleteProduct(id),HttpStatus.OK);
    }

    @GetMapping("/exception")
    public ResponseEntity<Void> checkingException(){
        int a=1/0;
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        System.out.println("Reached Controller");
        return new ResponseEntity<>(productDeclaration.addProduct(product),HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable("id") Long id){
        return new ResponseEntity<>(productDeclaration.findProductsByCategory(id),HttpStatus.OK);
    }

    @GetMapping("/getproductsbydescription/{id}")
        public ResponseEntity<List<getDesCriptionTitlePriceImage>>
    getProductsByDescription(@PathVariable("id") Long id){
            return new ResponseEntity<>(productDeclaration.
                    findBydescriptiontitleprice(id),HttpStatus.OK);
        }

}
