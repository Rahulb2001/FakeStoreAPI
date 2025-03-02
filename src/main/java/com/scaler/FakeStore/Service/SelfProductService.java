package com.scaler.FakeStore.Service;


import com.scaler.FakeStore.Exception.ProductException;
import com.scaler.FakeStore.Model.Category;
import com.scaler.FakeStore.Model.Product;
import com.scaler.FakeStore.Projection.getDesCriptionTitlePriceImage;
import com.scaler.FakeStore.Repositories.CategoryRepository;
import com.scaler.FakeStore.Repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        return productRepository.findById(id).orElseThrow(()->new ProductException("Product not found"));
    }

    @Override
    public Page<Product> findallProducts(int page, int size) {
        Pageable pageable= PageRequest.of(page,size, Sort.by("price").descending());
        return productRepository.findAll(pageable);
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
