package com.treehouse.zag.course;

import org.springframework.data.repository.CrudRepository;

/**
 * Created @author sobchak on 6/18/17.
 */
public interface CourseRepository extends CrudRepository<Course, Long> {
    // Create update and delete methods created automatically
}
