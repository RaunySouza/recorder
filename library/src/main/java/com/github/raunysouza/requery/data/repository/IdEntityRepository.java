package com.github.raunysouza.requery.data.repository;

import com.github.raunysouza.requery.data.entity.IdEntity;

import java.util.List;

import io.requery.Transaction;

/**
 * @author raunysouza
 */
public interface IdEntityRepository<T extends IdEntity> {

    T findById(long id);

    List<T> findAll();

    T save(T entity);

    int count();

    void delete(T entity);

    int delete(long id);

    Transaction transaction();
}
