package com.example.portfolio.hobby;

import com.example.portfolio.domain.hobby.HobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class HobbyServiceTest {

    @Autowired
    private HobbyService service;


}