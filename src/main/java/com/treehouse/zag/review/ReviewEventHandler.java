package com.treehouse.zag.review;

import com.treehouse.zag.user.User;
import com.treehouse.zag.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created @author sobchak on 6/25/17.
 * These handlers are synchronous with the User request loop.
 * Therefore, users will be waiting for these events to complete
 * before they will be aloud to proceed. Best practice would be
 * to not do too much here.
 * You can inject a lot of business logic here. Also makes it
 * easier to unit test.
 * TODO: test validation, security, and custom events are working as expected
 */
@Component
@RepositoryEventHandler(Review.class) // Watches reviews
public class ReviewEventHandler {

    private final UserRepository users;

    @Autowired
    public ReviewEventHandler(UserRepository users) {
        this.users = users;
    }

    @HandleBeforeCreate
    public void addReviewerBasedOnLoggedInUser(Review review) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = users.findByUsername(username);
        review.setReviewer(user);
    }
}
