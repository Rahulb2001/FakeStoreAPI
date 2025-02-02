package com.scaler.FakeStore.Service;

import com.scaler.FakeStore.Exception.ProductException;
import com.scaler.FakeStore.Model.Product;
import com.scaler.FakeStore.Projection.getDesCriptionTitlePriceImage;

import java.util.List;

public interface ProductDeclaration {

    Product findProductById(Long id) throws ProductException;

    List<Product> findallProducts();

    Product updateProduct(Product product,Long id);

    boolean deleteProduct(Long id);

    Product addProduct(Product product);

    List<Product> findProductsByCategory(Long id);

    List<getDesCriptionTitlePriceImage> findBydescriptiontitleprice(Long id);
}
