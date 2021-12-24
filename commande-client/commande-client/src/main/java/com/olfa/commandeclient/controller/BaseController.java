package com.olfa.commandeclient.controller;

import com.olfa.commandeclient.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

/**
 * @author olfa dhaoui
 *
 *
 */
public class BaseController <E,M,I> {
    @Autowired
    private BaseService<E,M,I> baseService;
    @PostMapping
    public ResponseEntity<E> create(@RequestBody E entity) {
        E lentity = baseService.create(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(lentity);
    }

    @PostMapping ("/M")
    public ResponseEntity<M> createM(@RequestBody M entity) throws ParseException {
        M lentity = baseService.createM(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(lentity);
    }

    @GetMapping("/M")
    public ResponseEntity<List<Object>> findAllM() {
        List<Object> entitys = (List<Object>) baseService.getAllM();
        return ResponseEntity.status(HttpStatus.OK).body(entitys);
    }

    @GetMapping
    public ResponseEntity<List<Object>> findAll() {
        List<Object> entitys = (List<Object>) baseService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(entitys);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findAll(@PathVariable I id) throws Exception {
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

    @PutMapping("/M/{id}")
    public ResponseEntity<Object> updateM(@PathVariable I id, @RequestBody M entity) throws Exception {
        M lentity;
        try {
            lentity = baseService.updateM(id, entity);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(lentity);
    }
}
