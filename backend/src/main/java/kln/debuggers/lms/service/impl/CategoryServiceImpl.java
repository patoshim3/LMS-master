package narxoz.kz.service.impl;

import lombok.AllArgsConstructor;
import narxoz.kz.dto.CategoryDto;
import narxoz.kz.entity.Category;
import narxoz.kz.entity.Course;
import narxoz.kz.mapper.CategoryMapper;
import narxoz.kz.mapper.CourseMapper;
import narxoz.kz.repository.CategoryRepository;
import narxoz.kz.repository.CourseRepository;
import narxoz.kz.service.CategoryService;
import narxoz.kz.service.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@AllArgsConstructor
@ResponseStatus(value=NOT_FOUND)

public class CategoryServiceImpl  implements CategoryService {
    private CategoryRepository categoryRepository;
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = CategoryMapper.mapToCategory(categoryDto);
        Category savedCategory = categoryRepository.save(category);

        return CategoryMapper.mapToCategoryDto(savedCategory);
    }

    @Override
    public CategoryDto getCategoriesById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Course is not exist with given id: " + categoryId));

        return CategoryMapper.mapToCategoryDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map((category) -> CategoryMapper.mapToCategoryDto(category))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto updateCategory(Long categoryId, CategoryDto updatedCategory) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new ResponseStatusException(NOT_FOUND,
                "Employee is not exist with given id: " + categoryId));
        category.setName(updatedCategory.getName());

        Category updatedCategoryObj = categoryRepository.save(category);

        return CategoryMapper.mapToCategoryDto(updatedCategoryObj);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new ResponseStatusException(NOT_FOUND,
                "Course is not exist with given id: " + categoryId));
        categoryRepository.deleteById(categoryId);

    }
}
