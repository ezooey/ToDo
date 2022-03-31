package com.tdl.ToDo.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Todo {

    @Id @GeneratedValue
    @Column(name = "todo_No")
    private int todoNo;
    private String todoContent;
    private LocalDateTime todoDate;

    @Enumerated(EnumType.STRING)
    private TodoStatus tdStatus; // Y, N

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_no")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "member_no")
    private Member member;
}
