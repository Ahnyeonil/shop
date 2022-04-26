package ahn.shop.login;

import ahn.shop.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import java.net.http.HttpResponse;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("LoginDto") LoginDto loginDto) {
        return "login/loginForm";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginDto loginDto, HttpResponse response) {
        MemberDto loginMember = loginService.login(loginDto.getLoginId(), loginDto.getPassword());
        if (loginMember == null) {
            return "login/loginForm";
        }

        //new Cookie("memberId", String.valueOf(loginMember.get))

        return "redirect:/";
    }
}
