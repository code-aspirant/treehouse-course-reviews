package com.treehouse.zag.review;

import com.treehouse.zag.core.BaseEntity;

import javax.persistence.Entity;

/**
 * Created @author sobchak on 6/18/17.
 */
@Entity
public class Review extends BaseEntity {

    private int rating;
    private String description;

    // TODO - we are duplicating code here for every single entity. Share it?
    // -- we moved this into BaseEntity
    protected Review() {
        super();
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
}
