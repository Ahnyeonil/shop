package ahn.shop.member.controller;

import ahn.shop.member.dto.MemberDto;
import ahn.shop.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/memberList")
    public String memberList(Model model) {
        List<MemberDto> memberDto = memberService.selectList();
        model.addAttribute("memberDto", memberDto);
        return "member/memberList";
    }

    @GetMapping("/member/{id}/memberInfo")
    public String memberInfo(@PathVariable("id") Long id, Model model){
        MemberDto memberDto = memberService.selectMember(id);
        model.addAttribute("memberDto", memberDto);
        return "member/memberInfo";
    }

    @GetMapping("/member/memberInsert")
    public String memberInsert(Model model){
        model.addAttribute("memberDto", new MemberDto());
        return "member/memberInsertForm";
    }

    @PostMapping("member/memberInsert")
    public String insertMember(MemberDto memberDto) {
        memberService.insertMember(memberDto);
        return "redirect:/member/memberList";
    }

    @PostMapping("member/{id}/memberUpdate")
    public String updateMember(@ModelAttribute MemberDto memberDto) {
        memberService.updateMember(memberDto);
        return "redirect:/member/{id}/memberInfo";
    }

    @PostMapping("member/{id}/memberDelete")
    public String deleteMember(@PathVariable("id") Long id, Model model) {
        memberService.deleteMember(id);

        List<MemberDto> memberDto = memberService.selectList();
        model.addAttribute("memberDto", memberDto);

        return "redirect:/member/memberList";
    }
}
