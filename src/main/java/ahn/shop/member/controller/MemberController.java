package ahn.shop.member.controller;

import ahn.shop.member.dto.MemberDto;
import ahn.shop.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/memberList")
    public String memberList(Model model) {
        List<MemberDto> memberList = memberService.selectList();
        model.addAttribute("memberList", memberList);
        return "member/memberList";
    }

    @GetMapping("/member/{id}/memberInfo")
    public String memberInfo(@PathVariable("id") Long memberId, Model model){
        MemberDto memberInfo = memberService.selectMember(memberId);
        model.addAttribute("memberInfo", memberInfo);
        return "member/memberInfo";
    }
}
