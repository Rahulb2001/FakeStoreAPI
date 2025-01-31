package com.scaler.FakeStore.Repositories;

import com.scaler.FakeStore.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
