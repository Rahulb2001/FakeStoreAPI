package com.scaler.FakeStore.Repositories;

import com.scaler.FakeStore.Model.Product;
import com.scaler.FakeStore.Projection.getDesCriptionTitlePriceImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByCategory_Id(Long id);

// HQL query
//    @Query( "select p.description as description, p.title as title , p.price as price ,p.image as image from Product p where p.id = :id")
//    List<getDesCriptionTitlePriceImage> findBydescriptiontitleprice(@Param("id") Long id);


    // Native query or SQL query
    @Query( value="select description,title,image ,price from product where id = :id" ,nativeQuery = true)
    List<getDesCriptionTitlePriceImage> findBydescriptiontitleprice(@Param("id") Long id);
}
