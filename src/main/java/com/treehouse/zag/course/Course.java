package com.treehouse.zag.course;

import com.treehouse.zag.core.BaseEntity;
import com.treehouse.zag.review.Review;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created @author sobchak on 6/18/17.
 */
@Entity
public class Course extends BaseEntity {

    @NotNull // Validation constraint. Not valid if the title is null.
    @Size(min = 2, max = 140)
    private String title;
    private String url;
    // Cascade will delete any associated reviews if the Course is deleted
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Review> reviews;

    // JPA requires a constructor that does not take any parameters
    protected Course() {
        super();
        reviews = new ArrayList<>(); // We want to initialize the list
    }

    public Course(String title, String url) {
        // Call default constructor to initialize id
        this();
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Review> getReviews() {
        return this.reviews;
    }

    public void addReview(Review review) {
        review.setCourse(this);
        reviews.add(review); // We'll want a constructor for reviews
    }
}
