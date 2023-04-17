package com.personal.portfolio.domain.repository;


import com.personal.portfolio.web.dto.Singer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Repository
public class SingerRepository {
    public EntityManager entityManager;
    public EntityTransaction entityTransaction;
    public void inputSinger(Singer singer){
        entityManager.persist(singer);
        entityTransaction.commit();
    }
}
