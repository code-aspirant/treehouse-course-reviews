package com.treehouse.zag.core;

import com.treehouse.zag.course.Course;
import com.treehouse.zag.course.CourseRepository;
import com.treehouse.zag.review.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by jconnor on 6/18/17.
 */
@Component
public class DatabaseLoader implements ApplicationRunner {

    // Define what you are looking for
    private final CourseRepository courses;

    @Autowired // This will automatically wire up the CourseRepository
    public DatabaseLoader(CourseRepository courses) {
        this.courses = courses;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Course course = new Course("Java Basics", "https://teamtreehouse.com/library/java-basics");
        course.addReview(new Review(3, "You ARE a dork!!!"));
        courses.save(course);
        String[] templates = {
                "Up and running with %s",
                "%s basics",
                "Introduction to %s",
                "%s for Beginners",
                "%s for Neckbeards"
        };
        String[] buzzwords = {
                "Spring REST Data",
                "Java 9",
                "Scala",
                "Groovy",
                "Hibernate"
        };

        List<Course> bunchOfCourses = new ArrayList<>();
        IntStream.range(0, 100)
                .forEach(i -> {
                    String template = templates[i % templates.length]; // Will make sure it is within the range of your list
                    String buzzword = buzzwords[i % buzzwords.length];
                    String title = String.format(template, buzzword);
                    Course c = new Course(title, "http://www.example.com");
                    c.addReview(new Review(i % 5, String.format("Moar %s please!!!", buzzword)));
                    bunchOfCourses.add(c);
                });
        courses.save(bunchOfCourses);
    }
}
