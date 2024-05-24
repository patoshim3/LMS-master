package kln.debuggers.lms.service;

import narxoz.kz.dto.CourseDto;

import java.util.List;

public interface CourseService {
    CourseDto createCourse(CourseDto courseDto);

    CourseDto getCoursesById(Long courseId);
    List<CourseDto> getAllCourses();

    CourseDto updateCourses(Long courseId, CourseDto updatedCourse);

    void deleteCourse(Long courseId);
}
