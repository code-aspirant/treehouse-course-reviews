package com.treehouse.zag.course;

import com.treehouse.zag.core.BaseEntity;

import javax.persistence.Entity;

/**
 * Created @author sobchak on 6/18/17.
 */
@Entity
public class Course extends BaseEntity {

    private String title;
    private String url;

    // JPA requires a constructor that does not take any parameters
    protected Course() {
        super();
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
}
