package com.codecrafthub.service;

import com.codecrafthub.model.Course;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private static final String FILE_PATH = "courses.json";

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());

    private static List<Course> courses = new ArrayList<>();

    @PostConstruct
    public void init() {
        loadCourses();
    }

    private void loadCourses() {
        try {
            File file = new File(FILE_PATH);

            if (!file.exists()) {
                file.createNewFile();
                saveCourses();
            }

            courses = objectMapper.readValue(
                    file,
                    new TypeReference<>() {}
            );

        } catch (IOException e) {
            courses = new ArrayList<>();
        }
    }

    private static void saveCourses() {
        try {
            objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(FILE_PATH), courses);
        } catch (IOException e) {
            throw new RuntimeException("Error saving courses", e);
        }
    }

    public List<Course> getAllCourses() {
        return courses;
    }

    public static Course getCourseById(Long id) {
        return courses.stream()
                .filter(course -> course.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public Course addCourse(Course course) {

        validateCourse(course);

        long nextId = courses.stream()
                .mapToLong(Course::getId)
                .max()
                .orElse(0) + 1;

        course.setId(nextId);
        course.setCreatedAt(LocalDateTime.now());

        courses.add(course);
        saveCourses();

        return course;
    }

    public static Course updateCourse(Long id, Course updatedCourse) {

        Course existing = getCourseById(id);

        validateCourse(updatedCourse);

        existing.setName(updatedCourse.getName());
        existing.setDescription(updatedCourse.getDescription());
        existing.setTargetDate(updatedCourse.getTargetDate());
        existing.setStatus(updatedCourse.getStatus());

        saveCourses();

        return existing;
    }

    public static void deleteCourse(Long id) {

        Course existing = getCourseById(id);

        courses.remove(existing);

        saveCourses();
    }

    private static void validateCourse(Course course) {

        if (course.getName() == null || course.getName().isEmpty()) {
            throw new RuntimeException("Name is required\n");
        }

        if (course.getDescription() == null || course.getDescription().isEmpty()) {
            throw new RuntimeException("Description is required\n");
        }

        if (course.getTargetDate() == null) {
            throw new RuntimeException("Target date is required\n");
        }

        List<String> validStatus = List.of(
                "Not Started",
                "In Progress",
                "Completed"
        );

        if (!validStatus.contains(course.getStatus())) {
            throw new RuntimeException("Invalid status value\n");
        }
    }
}
