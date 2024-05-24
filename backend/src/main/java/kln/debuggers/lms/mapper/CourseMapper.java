package kln.debuggers.lms.mapper;

import narxoz.kz.dto.CourseDto;
import narxoz.kz.entity.Course;

public class CourseMapper {
        public static CourseDto mapToCourseDto(Course course){
            return new CourseDto(
                    course.getId(),
                    course.getTitle(),
                    course.getCategoriesID(),
                    course.getPrice(),
                    course.getDescription(),
                    course.getActivity()
            );
        }
        public static Course mapToCourse(CourseDto courseDto){
            return new Course(
                    courseDto.getId(),
                    courseDto.getTitle(),
                    courseDto.getCategoriesID(),
                    courseDto.getPrice(),
                    courseDto.getDescription(),
                    courseDto.getActivity()
            );
        }
}
