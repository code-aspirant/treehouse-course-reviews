package com.treehouse.zag.review;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created @author sobchak on 6/18/17.
 */
public interface ReviewRepository extends PagingAndSortingRepository<Review, Long> {
}
