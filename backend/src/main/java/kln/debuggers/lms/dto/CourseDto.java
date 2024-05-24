package kln.debuggers.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {
        private Long id;
        private String title;
        private Long categoriesID;
        private Integer price;
        private String description;
        private Boolean activity;

}
