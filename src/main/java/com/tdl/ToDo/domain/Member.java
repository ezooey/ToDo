package com.tdl.ToDo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_no")
    private int memberNo;

    private String memberId;
    private String memberPw;
    private String nickname;
    private String email;

    @Enumerated(EnumType.STRING)
    private MemberStatus mStatus; // Y, N

    @OneToMany(mappedBy = "member")
    private List<Todo> todoList = new ArrayList<>();
}
