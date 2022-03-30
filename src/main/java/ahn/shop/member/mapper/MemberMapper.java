package ahn.shop.member.mapper;

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
        sqlSession.delete(NAMESPACE + "deleteMember", id);
    }

}
