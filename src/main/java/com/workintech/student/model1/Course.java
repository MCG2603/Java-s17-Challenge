package com.workintech.student.model1;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Data
public class Course {
    private String name;
    private int credit;
    private Grade grade;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return  Objects.equals(name, course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, credit, grade);
    }
}
