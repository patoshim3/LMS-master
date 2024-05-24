package kln.debuggers.lms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "courses")
public class Course {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "title")
        private String title;

        @Column(name = "categoriesID")
        private Long categoriesID;

        @Column(name = "price")
        private Integer price;

        @Column(name = "description")
        private String description;

        @Column(name = "activity")
        private Boolean activity;

}
