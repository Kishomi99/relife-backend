package com.Employee.RegisterLogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Employee.RegisterLogin.model.Category;
import com.Employee.RegisterLogin.model.User;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer>{
<<<<<<< HEAD

=======
	Category findByCategoryName(String categoryName);
>>>>>>> a0c77a5 (fixed-category-service)
}
