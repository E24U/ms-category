package ru.e24u.category.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.e24u.category.entity.Category;
import ru.e24u.category.repository.CategoryRepo;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepo categoryRepo;

    public Category createCategory(Category category) {
        if (categoryRepo.category(category.getCategory()) != null) {
            throw new IllegalArgumentException("Статья с таким названием уже существует");
        }
        try {
            return categoryRepo.save(category);
        } catch (Exception e) {
            throw new IllegalArgumentException("Проверьте правильность заполнения категории");
        }
    }

    public Category findById(long id) {
        try {
            return categoryRepo.findById(id).orElse(null);
        } catch (Exception e) {
            throw new IllegalArgumentException("Категория не найдена");
        }
    }

    public void updateCategory(long id, Category category) {
        try {
            Category rsl = categoryRepo.findById(id).get();
            rsl.setCategory(category.getCategory());
            rsl.setParent(category.getParent());
            categoryRepo.save(rsl);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public void deleteCategory(long id) {
        try {
            Category rsl = new Category();
            rsl.setId(id);
            categoryRepo.delete(rsl);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
