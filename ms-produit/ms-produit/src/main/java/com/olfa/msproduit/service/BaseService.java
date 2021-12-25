package com.olfa.msproduit.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BaseService <E,M, I> {
    E           create(E entity) throws Exception;
    E           update(I id, E entity) throws Exception;
    boolean     delete(I id) throws Exception;
    E           getOne(I id) throws Exception;
    List<E> getAll();
    public Page<E> getAll(Pageable pageable);
}
