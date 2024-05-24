package kln.debuggers.lms.controller;

import lombok.AllArgsConstructor;
import narxoz.kz.dto.CategoryDto;
import narxoz.kz.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private CategoryService categoryService;
        @PostMapping
        public ResponseEntity<CategoryDto> createCourse(@RequestBody CategoryDto categoryDto){
            CategoryDto savedCategory = categoryService.createCategory(categoryDto);

            return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
        }
        @GetMapping("get/{id}")
        public ResponseEntity<CategoryDto> getCategoriesById(@PathVariable("id") Long categoryId){
            CategoryDto categoryDto = categoryService.getCategoriesById(categoryId);
            return ResponseEntity.ok(categoryDto);
        }
        @GetMapping
        public ResponseEntity<List<CategoryDto>> getAllCategories(){
            List<CategoryDto> categories = categoryService.getAllCategories();
            return ResponseEntity.ok(categories);
        }

        @PutMapping("update/{id}")
        public ResponseEntity<CategoryDto> updateCategory(@PathVariable("id") Long categoryId,
                                                       @RequestBody CategoryDto updatedCategory){
            CategoryDto categoryDto = categoryService.updateCategory(categoryId,updatedCategory);
            return ResponseEntity.ok(categoryDto);
        }

        @DeleteMapping("{id}")
        public ResponseEntity<String> deleteCategory(@PathVariable("id") Long categoryId){
            categoryService.deleteCategory(categoryId);
            return ResponseEntity.ok("Deleted!");
        }

}
