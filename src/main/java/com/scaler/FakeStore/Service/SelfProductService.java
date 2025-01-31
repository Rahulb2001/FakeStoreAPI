package com.scaler.FakeStore.Service;


import com.scaler.FakeStore.Exception.ProductException;
import com.scaler.FakeStore.Model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
public class SelfProductService implements ProductDeclaration{ {

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
}
