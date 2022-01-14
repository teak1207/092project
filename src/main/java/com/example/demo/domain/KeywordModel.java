package com.example.demo.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// 담아오는 용기
@Entity
@Table(name = "KEYWORD")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class KeywordModel {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

}
