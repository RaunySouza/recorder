package com.github.raunysouza.requery.data;

import com.github.raunysouza.requery.data.repository.BasePersistableEntityRepository;

import io.requery.sql.EntityDataStore;

/**
 * @author raunysouza
 */
public class EntityRepositoryImpl extends BasePersistableEntityRepository<IUser> implements EntityRepository {

    public EntityRepositoryImpl(EntityDataStore<IUser> dataStore) {
        super(dataStore, IUser.class, User.ID, User.REMOVED);
    }
}
