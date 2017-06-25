package com.treehouse.zag.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.validation.Validator;

/**
 * Created @author sobchak on 6/25/17.
 */
public class RestConfig extends RepositoryRestConfigurerAdapter {

    @Autowired
    private Validator validator;

    /**
     * Add the ability to create error messages on
     * create and save
     * @param validatingListener
     */
    @Override
    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
        validatingListener.addValidator("beforeCreate", validator);
        validatingListener.addValidator("beforeSave", validator);
    }
}
