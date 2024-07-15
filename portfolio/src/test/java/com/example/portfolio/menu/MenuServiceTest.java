package com.example.portfolio.menu;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;


@Transactional
public class MenuServiceTest {

    @Value("${paging.limit}")
    private int pagingLimit;


}
