package com.example.demo.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "KEYWORD_MAPPING")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class KeywordMappingModel {


    @Id
    @Column(name ="id")
    private Long id;

    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "keyword_id")
    private Long keywordId;

//    private Long keywordCount;

    // 키워드를 눌렀을떄 해당 키워드의 상호명과 이미지를 리스트를 가져와야한다.

    //select name,thumbnail from store as s join keywordmapping as k  조인조건은 s.id = k.storeid where  k.storeid = 1;
    // 키워드맵핑 셀렉트 -- > store
    //select  name,thumbnail  from store where id in (select storeId from keywordmapping  where keywordId =2 );
}
