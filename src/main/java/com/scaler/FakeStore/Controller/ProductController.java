package com.scaler.FakeStore.Controller;


import com.scaler.FakeStore.Common.AuthCommon;
import com.scaler.FakeStore.DTO.UserDTO;
import com.scaler.FakeStore.Exception.ProductException;
import com.scaler.FakeStore.Model.Product;
import com.scaler.FakeStore.Projection.getDesCriptionTitlePriceImage;
import com.scaler.FakeStore.Service.ProductDeclaration;
import com.scaler.FakeStore.Service.ProductServices;
import com.scaler.FakeStore.Service.SelfProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductDeclaration productDeclaration;


    AuthCommon authCommon ;

    public ProductController(@Qualifier("selfProductService") ProductDeclaration productDeclaration,AuthCommon authCommon) {
        this.productDeclaration = productDeclaration;
        this.authCommon = authCommon;
    }

    @GetMapping()
    public ResponseEntity<Page<Product>> getallProducts(@RequestParam int page, @RequestParam int size) {
        return  new ResponseEntity<>(productDeclaration.findallProducts(page,size),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id
            )  throws ProductException {
       // UserDTO user = authCommon.ValidateToken(token);

//        if(user==null){
//            throw new ProductException("Token is invalid");
//        }
        System.out.println("Reached Controller for getting product by id");
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

    @PostMapping("/addproduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        System.out.println("Reached Controller");
        return new ResponseEntity<>(productDeclaration.addProduct(product),HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable("id") Long id){
        System.out.println("Reached Controller");
        return new ResponseEntity<>(productDeclaration.findProductsByCategory(id),HttpStatus.OK);
    }

    @GetMapping("/getproductsbydescription/{id}")
        public ResponseEntity<List<getDesCriptionTitlePriceImage>>
    getProductsByDescription(@PathVariable("id") Long id){
        System.out.println("Reached Controller");
            return new ResponseEntity<>(productDeclaration.
                    findBydescriptiontitleprice(id),HttpStatus.OK);
        }

}
