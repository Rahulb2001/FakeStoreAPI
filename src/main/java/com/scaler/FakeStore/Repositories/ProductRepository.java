package com.scaler.FakeStore.Repositories;

import com.scaler.FakeStore.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
