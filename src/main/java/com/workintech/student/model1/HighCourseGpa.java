package com.workintech.student.model1;

import org.springframework.stereotype.Component;

@Component
public class HighCourseGpa implements CourseGpa {
    public int getGpa(){

         return 10;
    }
}
