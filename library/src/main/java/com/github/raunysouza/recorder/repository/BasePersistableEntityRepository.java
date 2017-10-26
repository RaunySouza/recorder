package com.github.raunysouza.recorder.repository;

import com.github.raunysouza.recorder.entity.PersistableEntity;

import java.util.List;

import io.requery.meta.QueryAttribute;
import io.requery.sql.EntityDataStore;

/**
 * @author raunysouza
 */
public abstract class BasePersistableEntityRepository<T extends PersistableEntity> extends BaseIdEntityRepository<T> {

    private final QueryAttribute<? extends T, Boolean> removedAttr;

    public BasePersistableEntityRepository(EntityDataStore<T> dataStore, Class<T> entityClass,
                                           QueryAttribute<? extends T, Long> idAttr,
                                           QueryAttribute<? extends T, Boolean> removedAttr) {
        super(dataStore, entityClass, idAttr);
        this.removedAttr = removedAttr;
    }

    public List<T> findAllNotRemoved() {
        return getDataStore().select(getEntityClass())
                .where(getRemovedAttr().eq(false))
                .get()
                .toList();
    }

    protected QueryAttribute<? extends T, Boolean> getRemovedAttr() {
        return removedAttr;
    }

}
