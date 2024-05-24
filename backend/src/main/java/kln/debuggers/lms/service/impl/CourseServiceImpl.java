package narxoz.kz.service.impl;

import lombok.AllArgsConstructor;
import narxoz.kz.dto.CourseDto;
import narxoz.kz.entity.Course;
import narxoz.kz.mapper.CourseMapper;
import narxoz.kz.repository.CourseRepository;
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
public class CourseServiceImpl implements CourseService {
        private CourseRepository courseRepository;
        @Override
        public CourseDto createCourse(CourseDto courseDto) {
            Course course = CourseMapper.mapToCourse(courseDto);
            Course savedCourse = courseRepository.save(course);

            return CourseMapper.mapToCourseDto(savedCourse);
        }
    @Override
    public CourseDto getCoursesById(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Course is not exist with given id: " + courseId));

        return CourseMapper.mapToCourseDto(course);
    }

    @Override
    public List<CourseDto> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream().map((course) -> CourseMapper.mapToCourseDto(course))
                .collect(Collectors.toList());
    }

    @Override
    public CourseDto updateCourses(Long courseId, CourseDto updatedCourse) {
        Course course = courseRepository.findById(courseId).orElseThrow(()-> new ResponseStatusException(NOT_FOUND,
                "Employee is not exist with given id: " + courseId));
        course.setTitle(updatedCourse.getTitle());
        course.setCategoriesID(updatedCourse.getCategoriesID());
        course.setPrice(updatedCourse.getPrice());
        course.setPrice(updatedCourse.getPrice());
        course.setDescription(updatedCourse.getDescription());
        course.setActivity(updatedCourse.getActivity());

        Course updatedCourseObj = courseRepository.save(course);

        return CourseMapper.mapToCourseDto(updatedCourseObj);
    }

    @Override
        public void deleteCourse(Long courseId) {

            Course course = courseRepository.findById(courseId).orElseThrow(()-> new ResponseStatusException(NOT_FOUND,
                    "Course is not exist with given id: " + courseId));
            courseRepository.deleteById(courseId);
        }

}
