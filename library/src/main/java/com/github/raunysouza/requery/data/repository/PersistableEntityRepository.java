package com.github.raunysouza.requery.data.repository;

import com.github.raunysouza.requery.data.entity.PersistableEntity;

import java.util.List;

/**
 * @author raunysouza
 */
public interface PersistableEntityRepository<T extends PersistableEntity> extends IdEntityRepository<T> {

    List<T> findAllNotRemoved();
}
