package dev.sand.box.toolkit.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * Generic AbstractService using a default repository and the linked entity.
 *
 * @param <R>  The repository
 * @param <T>  Entity type of the repository
 * @param <ID> Primary key of the entity
 */
public abstract class AbstractService<R extends JpaRepository<T, ID>, T, ID extends Serializable> {
    private final R repository;

    protected AbstractService(R repository) {
        this.repository = repository;
    }

    @Transactional
    public T edit(T entity) {
        return this.repository.save(entity);
    }

    @Transactional
    public T create(T entity) {
        return this.repository.save(entity);
    }

    @Transactional
    public void remove(T id) {
        this.repository.delete(id);
    }

    protected R getRepository() {
        return this.repository;
    }
}
