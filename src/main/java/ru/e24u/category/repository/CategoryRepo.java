package ru.e24u.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.e24u.category.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {
    Category category(String category);
}
