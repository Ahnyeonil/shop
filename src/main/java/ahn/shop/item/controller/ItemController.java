package ahn.shop.item.controller;

import ahn.shop.item.dto.ItemDto;
import ahn.shop.item.service.ItemService;
import ahn.shop.member.dto.MemberDto;
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
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/item/itemList")
    public String itemList(Model model) {
        List<ItemDto> itemDto = itemService.selectList();
        model.addAttribute("itemDto", itemDto);
        return "item/itemList";
    }

    @GetMapping("/item/{id}/itemInfo")
    public String memberInfo(@PathVariable("id") Long id, Model model){
        ItemDto itemDto = itemService.selectItem(id);
        model.addAttribute("itemDto", itemDto);
        return "item/itemInfo";
    }

    @GetMapping("/item/itemInsert")
    public String itemInsert(Model model){
        model.addAttribute("itemDto", new ItemDto());
        return "item/itemInsertForm";
    }

    @PostMapping("item/insertItem")
    public String insertItem(ItemDto itemDto) {
        itemService.insertItem(itemDto);
        return "redirect:/item/itemList";
    }

    @PostMapping("item/{id}/updateItem")
    public String updateItem(@ModelAttribute ItemDto itemDto) {
        itemService.updateItem(itemDto);
        return "redirect:/item/{id}/itemInfo";
    }

    @PostMapping("item/{id}/deleteItem")
    public String deleteItem(@PathVariable("id") Long id, Model model) {
        itemService.deleteItem(id);

        List<ItemDto> itemDto = itemService.selectList();
        model.addAttribute("itemDto", itemDto);

        return "redirect:/item/itemList";
    }
}
