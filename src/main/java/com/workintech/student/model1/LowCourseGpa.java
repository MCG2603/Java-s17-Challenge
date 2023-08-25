package com.workintech.student.model1;

import org.springframework.stereotype.Component;

@Component
public class LowCourseGpa implements CourseGpa {
    public int getGpa() {

        return 3;

        }
    }