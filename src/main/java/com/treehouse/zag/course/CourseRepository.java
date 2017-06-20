package com.treehouse.zag.course;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created @author sobchak on 6/18/17.
 * Originally implemented CrudRepository but later implemented
 * the PagingAndSortingRepository to paginate results
 */
public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {
    // Create update and delete methods created automatically
    @RestResource(rel = "title-contains", path = "containsTitle") // Update the rel and link you see on the page
    Page<Course> findByTitleContaining(@Param("title") String title, Pageable page);
}
