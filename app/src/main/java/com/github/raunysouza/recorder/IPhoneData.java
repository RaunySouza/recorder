package com.github.raunysouza.recorder;

import com.github.raunysouza.requery.data.entity.PersistableEntity;

import io.requery.*;

/**
 * @author raunysouza
 */
@io.requery.Entity
public interface IPhoneData extends PersistableEntity {

    @Column(name = "phone_number")
    String getPhoneNumber();

    void setPhoneNumber(String value);

    @Column
    int getType();

    void setType(int value);
}
