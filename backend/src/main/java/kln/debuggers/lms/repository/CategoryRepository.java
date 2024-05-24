package kln.debuggers.lms.repository;

import narxoz.kz.entity.Category;
import narxoz.kz.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository  extends JpaRepository<Category, Long> {
}
