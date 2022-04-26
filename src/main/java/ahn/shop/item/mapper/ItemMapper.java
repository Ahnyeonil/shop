package ahn.shop.item.mapper;

import ahn.shop.item.dto.ItemDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ItemMapper {

    private final SqlSessionTemplate sqlSession;

    private final static String NAMESPACE = "ahn.shop.item.mapper.ItemMapper.";

    public List<ItemDto> selectList(){
        return sqlSession.selectList(NAMESPACE + "selectList");
    }

    public ItemDto selectItem(Long id){
        return sqlSession.selectOne(NAMESPACE + "selectItem", id);
    }

    public void insertItem(ItemDto item){
        sqlSession.insert(NAMESPACE + "insertItem", item);
    }

    public void updateItem(ItemDto item){
        sqlSession.update(NAMESPACE + "updateItem", item);
    }

    public void deleteItem(Long id){
        sqlSession.delete(NAMESPACE + "deleteItem", id);
    }
}
