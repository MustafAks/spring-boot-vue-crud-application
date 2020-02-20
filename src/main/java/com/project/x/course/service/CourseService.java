package com.project.x.course.service;

import com.project.x.course.model.Course;
import com.project.x.course.repository.CourseCustomRepository;
import com.project.x.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseCustomRepository customRepository;

    public List<Course> getAll() {
        List<Course> optional = courseRepository.findAll();
        return optional;
    }

    public List<Course> list(Course course) {
        return customRepository.list(course);
    }

    @Transactional
    public Course save(Course course) {
        return courseRepository.save(course);
    }
}
