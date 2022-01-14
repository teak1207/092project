package com.example.demo.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "KFA")
// 엔티티와 매핑할 테이블을 지정한다
/*
 주의사항
 기본생성자가 필수
 저장할 필드에 final 사용불가
 final 클래스,enum,interface,inner 클래스엔 사용불가
*/
@Entity // JPA를 사용해서 테이블과 매핑할 클래스는 @Entity를 필수로 붙여야함
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
//초기화 되지않은 final 필드나, @NonNull 이 붙은 필드에 대해 생성자를 생성해 줍니다. 주로 의존성 주입(Dependency Injection) 편의성을 위해서 사용
@Getter
public class RemindModel {

    @Id // id가 pk 알려줌.
    @Column(name = "id") // 테이블의 컬럼을 매칭
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "height")
    private int height;

    @Column(name = "weight")
    private int weight;

    @Column(name = "role")
    private String role;

    @Column(name = "club")
    private String club;
}
