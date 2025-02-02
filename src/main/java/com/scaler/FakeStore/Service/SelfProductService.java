package com.scaler.FakeStore.Service;


import com.scaler.FakeStore.Exception.ProductException;
import com.scaler.FakeStore.Model.Category;
import com.scaler.FakeStore.Model.Product;
import com.scaler.FakeStore.Projection.getDesCriptionTitlePriceImage;
import com.scaler.FakeStore.Repositories.CategoryRepository;
import com.scaler.FakeStore.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
public class SelfProductService implements ProductDeclaration{

    ProductRepository productRepository;
    CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository,
                              CategoryRepository categoryRepository){
        this.productRepository=productRepository;
        this.categoryRepository=categoryRepository;
    }

    @Override
    public Product findProductById(Long id) throws ProductException {
        return null;
    }

    @Override
    public List<Product> findallProducts() {
        return List.of();
    }

    @Override
    public Product updateProduct(Product product, Long id) {
        return null;
    }

    @Override
    public boolean deleteProduct(Long id) {
        return false;
    }

    @Override
    public Product addProduct(Product product) {

//        Category category=product.getCategory();
//
//        if(product.getCategory().getId()==null){
//            category=categoryRepository.save(category);
//            product.setCategory(category);
//        }

        Category category=product.getCategory();
        boolean byId = categoryRepository.existsById(category.getId());
        if(!byId){
            category=categoryRepository.save(category);
            product.setCategory(category);
        }

        return productRepository.save(product);
    }

    @Override
    public List<Product> findProductsByCategory(Long id) {
        return productRepository.findByCategory_Id(id);
    }

    @Override
    public List<getDesCriptionTitlePriceImage> findBydescriptiontitleprice(Long id) {
        return productRepository.findBydescriptiontitleprice(id);
    }


}
