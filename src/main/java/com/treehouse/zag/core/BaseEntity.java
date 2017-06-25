package com.treehouse.zag.core;

import javax.persistence.*;

/**
 * Created @author sobchak on 6/18/17.
 */
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;

    /**
     * Can use conditional header checking to see if things
     * have changed. Example: If-None-Match 0
     */
    @Version
    private Long version;

    protected BaseEntity() {
        id = null;
    }
}
