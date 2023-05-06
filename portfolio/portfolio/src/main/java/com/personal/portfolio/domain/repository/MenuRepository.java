package com.personal.portfolio.domain.repository;

import com.personal.portfolio.domain.entity.Menu;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
@Slf4j
@Repository
public class MenuRepository implements JpaRepository<Menu, Long> {

    private static EntityManager entityManager = new EntityManager() {
        @Override
        public void persist(Object entity) {

        }

        @Override
        public <T> T merge(T entity) {
            return null;
        }

        @Override
        public void remove(Object entity) {

        }

        @Override
        public <T> T find(Class<T> entityClass, Object primaryKey) {
            return null;
        }

        @Override
        public <T> T find(Class<T> entityClass, Object primaryKey, Map<String, Object> properties) {
            return null;
        }

        @Override
        public <T> T find(Class<T> entityClass, Object primaryKey, LockModeType lockMode) {
            return null;
        }

        @Override
        public <T> T find(Class<T> entityClass, Object primaryKey, LockModeType lockMode, Map<String, Object> properties) {
            return null;
        }

        @Override
        public <T> T getReference(Class<T> entityClass, Object primaryKey) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public void setFlushMode(FlushModeType flushMode) {

        }

        @Override
        public FlushModeType getFlushMode() {
            return null;
        }

        @Override
        public void lock(Object entity, LockModeType lockMode) {

        }

        @Override
        public void lock(Object entity, LockModeType lockMode, Map<String, Object> properties) {

        }

        @Override
        public void refresh(Object entity) {

        }

        @Override
        public void refresh(Object entity, Map<String, Object> properties) {

        }

        @Override
        public void refresh(Object entity, LockModeType lockMode) {

        }

        @Override
        public void refresh(Object entity, LockModeType lockMode, Map<String, Object> properties) {

        }

        @Override
        public void clear() {

        }

        @Override
        public void detach(Object entity) {

        }

        @Override
        public boolean contains(Object entity) {
            return false;
        }

        @Override
        public LockModeType getLockMode(Object entity) {
            return null;
        }

        @Override
        public void setProperty(String propertyName, Object value) {

        }

        @Override
        public Map<String, Object> getProperties() {
            return null;
        }

        @Override
        public Query createQuery(String qlString) {
            return null;
        }

        @Override
        public <T> TypedQuery<T> createQuery(CriteriaQuery<T> criteriaQuery) {
            return null;
        }

        @Override
        public Query createQuery(CriteriaUpdate updateQuery) {
            return null;
        }

        @Override
        public Query createQuery(CriteriaDelete deleteQuery) {
            return null;
        }

        @Override
        public <T> TypedQuery<T> createQuery(String qlString, Class<T> resultClass) {
            return null;
        }

        @Override
        public Query createNamedQuery(String name) {
            return null;
        }

        @Override
        public <T> TypedQuery<T> createNamedQuery(String name, Class<T> resultClass) {
            return null;
        }

        @Override
        public Query createNativeQuery(String sqlString) {
            return null;
        }

        @Override
        public Query createNativeQuery(String sqlString, Class resultClass) {
            return null;
        }

        @Override
        public Query createNativeQuery(String sqlString, String resultSetMapping) {
            return null;
        }

        @Override
        public StoredProcedureQuery createNamedStoredProcedureQuery(String name) {
            return null;
        }

        @Override
        public StoredProcedureQuery createStoredProcedureQuery(String procedureName) {
            return null;
        }

        @Override
        public StoredProcedureQuery createStoredProcedureQuery(String procedureName, Class... resultClasses) {
            return null;
        }

        @Override
        public StoredProcedureQuery createStoredProcedureQuery(String procedureName, String... resultSetMappings) {
            return null;
        }

        @Override
        public void joinTransaction() {

        }

        @Override
        public boolean isJoinedToTransaction() {
            return false;
        }

        @Override
        public <T> T unwrap(Class<T> cls) {
            return null;
        }

        @Override
        public Object getDelegate() {
            return null;
        }

        @Override
        public void close() {

        }

        @Override
        public boolean isOpen() {
            return false;
        }

        @Override
        public EntityTransaction getTransaction() {
            return null;
        }

        @Override
        public EntityManagerFactory getEntityManagerFactory() {
            return null;
        }

        @Override
        public CriteriaBuilder getCriteriaBuilder() {
            return null;
        }

        @Override
        public Metamodel getMetamodel() {
            return null;
        }

        @Override
        public <T> EntityGraph<T> createEntityGraph(Class<T> rootType) {
            return null;
        }

        @Override
        public EntityGraph<?> createEntityGraph(String graphName) {
            return null;
        }

        @Override
        public EntityGraph<?> getEntityGraph(String graphName) {
            return null;
        }

        @Override
        public <T> List<EntityGraph<? super T>> getEntityGraphs(Class<T> entityClass) {
            return null;
        }
    };
    private static EntityTransaction transaction = entityManager.getTransaction();
    //    //
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
        try{
            entityManager.persist(entity);
            transaction.commit();
            return entity;
        }catch (Exception e){
            log.error("menuEntity save error : " , e);
            return null;
        }
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
