package ahn.shop.item.service;

import ahn.shop.item.dto.ItemDto;
import ahn.shop.item.mapper.ItemMapper;
import ahn.shop.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemMapper itemMapper;

    // 상품 목록 조회
    public List<ItemDto> selectList(){
        List<ItemDto> itemList = itemMapper.selectList();
        return itemList;
    }

    // 상품 상세 조회
    public ItemDto selectItem(Long id){
        ItemDto itemInfo = itemMapper.selectItem(id);
        return itemInfo;
    }

    // 상품 등록
    public void insertItem(ItemDto itemDto) {
        itemMapper.insertItem(itemDto);
    }

    // 상품 수정
    public void updateItem(ItemDto itemDto) {
        itemMapper.updateItem(itemDto);
    }

    // 상품 삭제
    public void deleteItem(Long id){
        itemMapper.deleteItem(id);
    }
}
