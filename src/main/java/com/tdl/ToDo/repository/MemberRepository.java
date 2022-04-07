package com.tdl.ToDo.repository;

import com.tdl.ToDo.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void saveMember(Member member) {
        em.persist(member);
    }

    public Member findOne(String memberId) {
        return em.find(Member.class, memberId);
    }


}
