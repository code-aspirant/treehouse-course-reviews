package com.treehouse.zag.review;

import com.treehouse.zag.core.BaseEntity;
import com.treehouse.zag.course.Course;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created @author sobchak on 6/18/17.
 */
@Entity
public class Review extends BaseEntity {

    private int rating;
    private String description;

    @ManyToOne
    private Course course;

    // TODO - we are duplicating code here for every single entity. Share it?
    // -- we moved this into BaseEntity
    protected Review() {
        super();
    }

    public Review(int rating, String description) {
        this.rating = rating;
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}
