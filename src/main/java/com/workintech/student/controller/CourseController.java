package com.workintech.student.controller;

import com.workintech.student.model1.Course;
import com.workintech.student.model1.CourseGpa;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.workintech.student.model1.*;

import java.util.*;

@Component
@RestController
@Data
public class CourseController {
    private List<Course> courseLists;
    private Map<Course,Integer> courseMap;
    private CourseGpa highCourseGpa;
    private CourseGpa midCourseGpa;
    private CourseGpa lowCourseGpa;
    @Autowired
    public CourseController(@Qualifier ("lowCourseGpa") CourseGpa low,@Qualifier ("midCourseGpa") CourseGpa mid,@Qualifier ("highCourseGpa") CourseGpa high){
this.lowCourseGpa=low;
this.midCourseGpa=mid;
this.highCourseGpa=high;
    }
    @PostConstruct
    public void init(){
        courseLists=new ArrayList<Course>();
        courseMap=new HashMap<Course,Integer>();

    }
    @GetMapping("/")
    public List<Course> get(){

        return getCourseLists();
    }
    @PostMapping("/")
    public Map<Course, Integer> post(@RequestBody Course course){
        int totalGpa=0;

        if(courseLists.contains(course) || course.getCredit()<0 || course.getCredit()>4 ) {

        return null;
        }
        courseLists.add(course);

            if(course.getCredit()<3) {
                totalGpa = course.getGrade().getCoefficient() * course.getCredit() * lowCourseGpa.getGpa();
            }
        if(course.getCredit()==3) {
            totalGpa = course.getGrade().getCoefficient() * course.getCredit() * midCourseGpa.getGpa();
        }
        if(course.getCredit()>3) {
            totalGpa = course.getGrade().getCoefficient() * course.getCredit() * highCourseGpa.getGpa();
        }
        courseMap.put(course,totalGpa);
        return courseMap;

        }


    }


