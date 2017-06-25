package com.treehouse.zag.review;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * Created @author sobchak on 6/18/17.
 */
public interface ReviewRepository extends PagingAndSortingRepository<Review, Long> {
    @Override
    /* Access review repository > find one by id, which is optional, get the reviewer, which is also optional*/
    @PreAuthorize("hasRole('ROLE_ADMIN') or @reviewRepository.findOne(#id)?.reviewer?.username == authentication.name")
    void delete(@Param("id") Long id);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or #review.reviewer?.username == authentication.name")
    void delete(@Param("review") Review review);
}
