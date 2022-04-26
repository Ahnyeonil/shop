package ahn.shop.member.mapper;

import ahn.shop.login.LoginDto;
import ahn.shop.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MemberMapper {

    private final SqlSessionTemplate sqlSession;

    private final static String NAMESPACE = "ahn.shop.member.mapper.MemberMapper.";

    private final static String NAMESPACE2 = "ahn.shop.item.mapper.ItemMapper.";

    public List<MemberDto> selectList(){
        return sqlSession.selectList(NAMESPACE + "selectList");
    }

    public MemberDto selectMember(Long id){
        return sqlSession.selectOne(NAMESPACE + "selectMember", id);
    }

    public void insertMember(MemberDto member){
        sqlSession.insert(NAMESPACE + "insertMember", member);
    }

    public void updateMember(MemberDto member){
        sqlSession.update(NAMESPACE + "updateMember", member);
    }

    public void deleteMember(Long id){
        // 사용자 삭제
        sqlSession.delete(NAMESPACE + "deleteMember", id);
        // 해당 사용자가 등록한 물품 삭제
        /*sqlSession.delete(NAMESPACE2 + "deleteItemByMember", id);*/
    }

    public MemberDto selectMemberByLoginId(String loginId){
        return sqlSession.selectOne(NAMESPACE + "selectMemberByLoginId", loginId);
    }

}
