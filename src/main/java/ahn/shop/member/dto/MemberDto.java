package ahn.shop.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class MemberDto {

    private Long id;

    @NotEmpty(message = "관리자 id는 필수값입니다.")
    @Size(min = 4, max = 15, message = "관라지 id는 4자 ~ 15자 사이입니다.")
    private String memberId;

    @NotEmpty(message = "비밀번호는 필수값입니다.")
    private String password;

    @NotEmpty(message = "관리자명은 필수값입니다.")
    private String name;

    private int age;

    private String phoneNum;

    private String email;

    private String createDate;

    private String updateDate;

    private Long update_id;
}
