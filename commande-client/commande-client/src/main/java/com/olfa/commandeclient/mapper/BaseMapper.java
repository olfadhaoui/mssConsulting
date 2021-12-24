package com.olfa.commandeclient.mapper;

import java.text.ParseException;
import java.util.List;

/**
 * @author olfa dhaoui
 *
 *
 */
public interface BaseMapper<M,E>{
    E toEntity(M m) throws ParseException;
    M toModel(E e);
    List<E> toListEntity(List<M> modelList);
    List<M> toListModel(List<E> entityList);
}
