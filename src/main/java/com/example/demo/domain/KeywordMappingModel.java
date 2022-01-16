package com.example.demo.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "KEYWORD_MAPPING")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@SequenceGenerator(
        name = "KEYWORD_MAPPING_SEQ_GEN", //시퀀스 제너레이터 이름
        sequenceName = "KEYWORD_MAPPING_SEQ", //시퀀스 이름
        initialValue = 1, //시작값
        allocationSize = 1 //메모리를 통해 할당할 범위 사이즈
)
public class KeywordMappingModel {


    @Id
    @Column(name = "id")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, //사용할 전략을 시퀀스로  선택
            generator = "KEYWORD_MAPPING_SEQ_GEN" //식별자 생성기를 설정해놓은  STORE_SEQ_GEN 설정
    )
    private Long id;

    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "keyword_id")
    private Long keywordId;

    @Column(name = "keyword_count")
    private Long keywordCount;

    public KeywordMappingModel(Long storeId, Long keywordId, Long keywordCount) {
        this.storeId = storeId;
        this.keywordId = keywordId;
        this.keywordCount = keywordCount;
    }

    // 키워드를 눌렀을떄 해당 키워드의 상호명과 이미지를 리스트를 가져와야한다.

    //select name,thumbnail from store as s join keywordmapping as k  조인조건은 s.id = k.storeid where  k.storeid = 1;
    // 키워드맵핑 셀렉트 -- > store
    //select  name,thumbnail  from store where id in (select storeId from keywordmapping  where keywordId =2 );
}
