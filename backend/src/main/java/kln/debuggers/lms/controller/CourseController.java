package kln.debuggers.lms.controller;

import lombok.AllArgsConstructor;
import narxoz.kz.dto.CourseDto;
import narxoz.kz.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private CourseService courseService;
    @PostMapping
    public ResponseEntity<CourseDto> createCourse(@RequestBody CourseDto courseDto){
        CourseDto savedCourse = courseService.createCourse(courseDto);

        return new ResponseEntity<>(savedCourse, HttpStatus.CREATED);
    }
        @GetMapping("get/{id}")
        public ResponseEntity<CourseDto> getCoursesById(@PathVariable("id") Long courseId){
            CourseDto courseDto = courseService.getCoursesById(courseId);
            return ResponseEntity.ok(courseDto);
        }
        @GetMapping
        public ResponseEntity<List<CourseDto>> getAllCourses(){
            List<CourseDto> courses = courseService.getAllCourses();
            return ResponseEntity.ok(courses);
        }

        @PutMapping("update/{id}")
        public ResponseEntity<CourseDto> updateCourses(@PathVariable("id") Long courseId,
                                                           @RequestBody CourseDto updatedCourse){
            CourseDto courseDto = courseService.updateCourses(courseId,updatedCourse);
            return ResponseEntity.ok(courseDto);
        }

        @DeleteMapping("{id}")
        public ResponseEntity<String> deleteCourse(@PathVariable("id") Long courseId){
            courseService.deleteCourse(courseId);
            return ResponseEntity.ok("Deleted!");
        }

}
