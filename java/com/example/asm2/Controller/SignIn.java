package com.example.asm2.Controller;

import com.example.asm2.DTO.Request.SignInRequest;
import com.example.asm2.Service.GenerateToken;
import com.nimbusds.jose.JOSEException;
import jakarta.servlet.http.HttpSession;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@Slf4j

public class SignIn {
    GenerateToken generateToken;
    Home h;

    @PostMapping("/login")
    public String dangNhap(SignInRequest data, Model model, HttpSession session) throws JOSEException {
//        var context = SecurityContextHolder.getContext().getAuthentication();
//        context.getAuthorities().forEach(request -> log.info(request.getAuthority()));
        if(generateToken.dangNhap(data)!=null){
            model.addAttribute("token",generateToken.dangNhap(data));
            session.setAttribute("scope",);
            return h.getall(model);
        }else{
            return "user/login";
        }


    }
    @GetMapping("/admin/test")
    public String hello(){
//        var context = SecurityContextHolder.getContext().getAuthentication();
//        context.getAuthorities().forEach(request -> log.info(request.getAuthority()));
        return "hello";
    }
    @GetMapping("/sign-in")
    public String dangNhap(){
        return "/user/login";
    }
}
