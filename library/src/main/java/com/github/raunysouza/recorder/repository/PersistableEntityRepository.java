package com.github.raunysouza.recorder.repository;

import com.github.raunysouza.recorder.entity.PersistableEntity;

import java.util.List;

/**
 * @author raunysouza
 */
public interface PersistableEntityRepository<T extends PersistableEntity> extends IdEntityRepository<T> {

    List<T> findAllNotRemoved();
}
