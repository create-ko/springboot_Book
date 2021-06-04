package com.sh.book.springboot.domain.posts;

import com.sh.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter                 // 핵심! Entity 클래스에서는 절대 Setter를 만들지 않는다.
@NoArgsConstructor      // 기본 생성사 자동 추가
@Entity                 // 테이블과 링크될 클래스임을 나타낸다.
public class Posts extends BaseTimeEntity {

    @Id  // PK를 의미한다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성규칙
    private Long id;

    @Column(length = 500, nullable = false)  // 기본값 이외의 컬럼에 특정 옵션을 넣기 위한 문구.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
