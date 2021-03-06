package com.github.raunysouza.recorder.entity;

import io.requery.Column;
import io.requery.Superclass;

/**
 * @author raunysouza
 */
@Superclass
public interface PersistableEntity extends IdEntity {

    @Column(name = "is_removed")
    boolean isRemoved();

    void setRemoved(boolean value);
}
