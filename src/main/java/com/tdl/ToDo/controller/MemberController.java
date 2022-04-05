package com.tdl.ToDo.controller;

import com.tdl.ToDo.domain.Member;
import com.tdl.ToDo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/new")
    public String joinMemberForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "member/joinMemberForm";
    }

    @PostMapping("/member/new")
    public String join(@Valid MemberForm form, BindingResult result) {

        if(result.hasErrors()) {
            return "member/joinMemberForm";
        }
        Member member = new Member();
        memberService.joinMember(member);
        return "redirect:/";
    }

//    @GetMapping("/member/login")
//    public String login() {
//        return "/member/login";
//    }
}
