package com.olfa.commandeclient.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;
import java.util.List;
/**
 * @author olfa dhaoui
 *
 *
 */
public interface BaseService <E,M,I>{
    E           create(E entity);
    M           createM(M entity) throws ParseException;
    E           update(I id, E entity) throws Exception;
    M           updateM(I id, M entity) throws Exception;
    boolean     delete(I id) throws Exception;
    E           getOne(I id) throws Exception;
    List<E> getAll();
    List<M> getAllM();

    public Page<E> getAll(Pageable pageable);
    public Page<M> getAllM(Pageable pageable);
}
