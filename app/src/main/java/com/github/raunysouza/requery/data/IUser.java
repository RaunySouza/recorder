package com.github.raunysouza.requery.data;

import com.github.raunysouza.requery.data.entity.PersistableEntity;

import io.requery.Column;
import io.requery.ForeignKey;
import io.requery.OneToOne;

/**
 * @author raunysouza
 */
@io.requery.Entity
public interface IUser extends PersistableEntity {

    @Column
    String getName();

    void setName(String value);

    @OneToOne
    @ForeignKey
    IPhoneData getPhoneData();

    void setPhoneData(IPhoneData value);
}
