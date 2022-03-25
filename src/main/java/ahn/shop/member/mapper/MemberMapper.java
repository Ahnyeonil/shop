package ahn.shop.member.mapper;

import ahn.shop.member.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class MemberMapper {

    @Autowired
    @Qualifier("sqlSession")
    private SqlSessionTemplate sqlSession;

    private final static String NAMESPACE = "ahn.shop.member.mapper.MemberMapper.";

    //public List<MemberDto> selectList(String id, String name, int phoneNum, String email);

    public List<MemberDto> selectList(){
        return sqlSession.selectList(NAMESPACE + "selectList");
    }

    public MemberDto selectMember(Long memberId){
        return sqlSession.selectOne(NAMESPACE + "selectMember", memberId);
    }

    public void insertMember(MemberDto member){};

    public void updateMember(MemberDto member){};

    public void deleteMember(int id){};

}
