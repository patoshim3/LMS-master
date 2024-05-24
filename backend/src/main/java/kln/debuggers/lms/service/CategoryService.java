package kln.debuggers.lms.service;

import narxoz.kz.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto getCategoriesById(Long courseId);
    List<CategoryDto> getAllCategories();

    CategoryDto updateCategory(Long categoryId,CategoryDto updatedCategory);

    void deleteCategory(Long categoryId);
}
