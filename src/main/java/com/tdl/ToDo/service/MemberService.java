package com.tdl.ToDo.service;

import com.tdl.ToDo.domain.Member;
import com.tdl.ToDo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public String joinMember(Member member){

        validateDuplicateMember(member);
        memberRepository.saveMember(member);
        return member.getMemberId();
    }

    private void validateDuplicateMember(Member member) {

        List<Member> findMembers = memberRepository.findById(member.getMemberId());
        if(!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        }
    }
}
