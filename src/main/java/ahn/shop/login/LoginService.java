package ahn.shop.login;

import ahn.shop.member.dto.MemberDto;
import ahn.shop.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberMapper memberMapper;

    public MemberDto login(String memberId, String password) {
        MemberDto loginMmber = memberMapper.selectMemberByLoginId(memberId);

        if (loginMmber.getPassword().equals(password)) {
            return loginMmber;
        } else {
            return null;
        }
    }
}
