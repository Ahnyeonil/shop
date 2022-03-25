package ahn.shop.member.dto;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

@Data
public class MemberDto {

    private Long id;

    private String memberId;

    private String password;

    private String name;

    private int age;

    private int phoneNum;

    private String email;
}
