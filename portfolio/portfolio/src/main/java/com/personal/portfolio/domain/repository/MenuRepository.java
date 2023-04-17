package com.personal.portfolio.domain.repository;

import com.personal.portfolio.domain.entity.Menu;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class MenuRepository implements JpaRepository<Menu, Long> {

    private static EntityManager entityManager;
    @Override
    public List<Menu> findAll() {
        return null;
    }

    @Override
    public List<Menu> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Menu> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Menu> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Menu entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Menu> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Menu> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Menu> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Menu> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Menu> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Menu> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Menu> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Menu getOne(Long aLong) {
        return null;
    }

    @Override
    public Menu getById(Long aLong) {
        return null;
    }

    @Override
    public Menu getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Menu> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Menu> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Menu> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Menu> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Menu> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Menu> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Menu, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
