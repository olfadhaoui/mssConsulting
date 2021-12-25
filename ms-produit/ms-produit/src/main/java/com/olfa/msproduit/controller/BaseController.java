package com.olfa.msproduit.controller;

import com.olfa.msproduit.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class BaseController <E,M,I> {
    @Autowired
    private BaseService<E,M,I> baseService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody E entity) throws Exception{
        E lentity;
        try {
            lentity = baseService.create(entity);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(lentity);
    }

    @GetMapping
    public ResponseEntity<List<E>> findAll() {
        List<E> entitys = baseService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(entitys);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable I id) throws Exception {
        E entity;
        try {
            entity = baseService.getOne(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable I id) {
        try {
            baseService.delete(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body("Deleted success");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable I id, @RequestBody E entity) throws Exception {
        E lentity;
        try {
            lentity = baseService.update(id, entity);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(lentity);
    }

    @GetMapping(value = "/pagination")
    public ResponseEntity<Page<E>> findAllPaginator(@RequestParam(name = "page", defaultValue = "0") int page,
                                                    @RequestParam(name = "size", defaultValue = "4") int size) {

        Page<E> entitys = baseService.getAll(PageRequest.of(page, size));
        return ResponseEntity.status(HttpStatus.OK).body(entitys);
    }
}
