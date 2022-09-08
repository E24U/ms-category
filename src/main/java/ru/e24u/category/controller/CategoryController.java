package ru.e24u.category.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.e24u.category.entity.Category;
import ru.e24u.category.service.CategoryService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class CategoryController {

    private final CategoryService service;

    @PostMapping("/category")
    public Category create(@RequestBody Category category) {
        return service.createCategory(category);
    }

    @GetMapping("/category/{id}")
    public Category findById(@PathVariable long id) {
        return service.findById(id);
    }

    @PutMapping("/category/{id}")
    public void update(@PathVariable long id, @RequestBody Category category) {
        service.updateCategory(id, category);
    }

    @DeleteMapping("/category/{id}")
    public void delete(@PathVariable long id) {
        service.deleteCategory(id);
    }
}
