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

    // 사용자 목록 조회
    public List<MemberDto> selectList(){
        List<MemberDto> memberList = memberMapper.selectList();
        return memberList;
    }

    // 사용자 상세 조회
    public MemberDto selectMember(Long id){
        MemberDto memberInfo = memberMapper.selectMember(id);
        return memberInfo;
    }

    // 사용자 등록
    public void insertMember(MemberDto memberDto) {
        memberMapper.insertMember(memberDto);
    }

    // 사용자 수정
    public void updateMember(MemberDto memberDto) {
        memberMapper.updateMember(memberDto);
    }

    // 사용자 삭제
    public void deleteMember(Long id){
        memberMapper.deleteMember(id);
    }
}
