package kln.debuggers.lms.mapper;

import narxoz.kz.dto.CategoryDto;
import narxoz.kz.entity.Category;

public class CategoryMapper {
    public static CategoryDto mapToCategoryDto(Category category){
        return new CategoryDto(
                category.getId(),
                category.getName()
        );
    }
    public static Category mapToCategory(CategoryDto categoryDto){
        return new Category(
                categoryDto.getId(),
                categoryDto.getName()
        );
    }
}
