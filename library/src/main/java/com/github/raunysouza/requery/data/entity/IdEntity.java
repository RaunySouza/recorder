package com.github.raunysouza.requery.data.entity;

import io.requery.Generated;
import io.requery.Key;
import io.requery.Superclass;

/**
 * @author raunysouza
 */
@Superclass
public interface IdEntity {

    @Key
    @Generated
    long getId();
}
