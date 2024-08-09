package org.nikola.trelloclone.controller;

import lombok.RequiredArgsConstructor;
import org.nikola.trelloclone.entity.Category;
import org.nikola.trelloclone.repository.CategoryRepository;
import org.nikola.trelloclone.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryRepository.findAll());
    }

}
