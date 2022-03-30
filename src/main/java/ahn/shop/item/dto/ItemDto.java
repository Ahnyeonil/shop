package ahn.shop.item.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class ItemDto {

    private Long id;

    @NotEmpty(message = "상품명은 필수값입니다.")
    private String name;

    @NotEmpty(message = "가격은 필수값입니다.")
    private int price;

    @NotEmpty(message = "수량은 필수값입니다.")
    private int quantity;

    private int registerId;
}
