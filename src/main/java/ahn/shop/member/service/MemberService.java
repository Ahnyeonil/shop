package ahn.shop.member.service;

import ahn.shop.member.dto.MemberDto;
import ahn.shop.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;

    public List<MemberDto> selectList(){
        List<MemberDto> memberList = memberMapper.selectList();
        return memberList;
    }

    public MemberDto selectMember(Long memberId){
        MemberDto memberInfo = memberMapper.selectMember(memberId);
        return memberInfo;
    }
}
