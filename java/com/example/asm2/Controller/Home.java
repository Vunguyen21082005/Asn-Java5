package com.example.asm2.Controller;


import com.example.asm2.Service.ChiTietSPService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class Home {
    ChiTietSPService se;
    @GetMapping("")
    public String getall(Model model){
        model.addAttribute("list",se.getAll());

        return "user/Home";
    }
}
