package com.scaler.FakeStore.Service;

import com.scaler.FakeStore.Exception.ProductException;
import com.scaler.FakeStore.Model.Product;

import java.util.List;

public interface ProductDeclaration {

    Product findProductById(Long id) throws ProductException;

    List<Product> findallProducts();

    Product updateProduct(Product product,Long id);

    boolean deleteProduct(Long id);

}
