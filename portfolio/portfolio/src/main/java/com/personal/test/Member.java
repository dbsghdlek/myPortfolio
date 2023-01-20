package com.personal.test;

import javax.persistence.*;

@Entity   //테이블과 매핑을 하겠다는 것을 jpa에 전달
@Table(name="MEMBER")  // 매핑하는 테이블의 이름 전달
public class Member {
    @Id
    @Column(name="ID")
    public String id;
    @Column(name="NAME")
    private String username;

    private Integer age;
}
