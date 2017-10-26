package com.github.raunysouza.recorder.repository;

import com.github.raunysouza.recorder.entity.IdEntity;

import java.util.List;

import io.requery.Transaction;
import io.requery.meta.QueryAttribute;
import io.requery.sql.EntityDataStore;

/**
 * @author raunysouza
 */
public abstract class BaseIdEntityRepository<T extends IdEntity> {

    private final EntityDataStore<T> dataStore;
    private final Class<T> entityClass;

    private final QueryAttribute<? extends T, Long> idAttr;

    public BaseIdEntityRepository(EntityDataStore<T> dataStore, Class<T> entityClass, QueryAttribute<? extends T, Long> idAttr) {
        this.dataStore = dataStore;
        this.entityClass = entityClass;
        this.idAttr = idAttr;
    }

    public T findById(long id) {
        return getDataStore().select(getEntityClass())
                .where(getIdAttr().eq(id))
                .get()
                .firstOrNull();
    }

    public List<T> findAll() {
        return getDataStore().select(getEntityClass())
                .get()
                .toList();
    }

    public int count() {
        return getDataStore().count(getEntityClass())
                .get()
                .value();
    }

    public T save(T entity) {
        return getDataStore().upsert(entity);
    }

    public void delete(T entity) {
        getDataStore().delete(entity);
    }

    public int delete(long id) {
        return getDataStore().delete(getEntityClass())
                .where(getIdAttr().eq(id))
                .get()
                .value();
    }

    public Transaction transaction() {
        return dataStore.transaction();
    }

    protected EntityDataStore<T> getDataStore() {
        return dataStore;
    }

    protected Class<T> getEntityClass() {
        return entityClass;
    }

    protected QueryAttribute<? extends T, Long> getIdAttr() {
        return idAttr;
    }
}
