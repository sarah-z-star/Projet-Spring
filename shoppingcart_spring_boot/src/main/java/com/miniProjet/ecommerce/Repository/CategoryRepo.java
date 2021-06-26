package com.miniProjet.ecommerce.Repository;

import com.miniProjet.ecommerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo  extends JpaRepository<Category, Long> {

}
