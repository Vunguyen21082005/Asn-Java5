package com.example.asm2.Controller;

import com.example.asm2.DTO.Request.DSPRequest;
import com.example.asm2.Entity.DongSP;
import com.example.asm2.Entity.MauSac;
import com.example.asm2.Service.MauSacService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequestMapping("/admin/mau-sac")
public class MauSacController {
    MauSacService ms;
    @GetMapping("")
    public String getall(Model model){
        model.addAttribute("list",ms.getAll());
        return "admin/MauSac";
    }
    @PostMapping("/add")
    public String add(Model model, DSPRequest data){
        model.addAttribute("list",ms.add(data));
        return "admin/MauSac";
    }
    @GetMapping("/delete/{ma}")
    public String delete(Model model,@PathVariable("ma") int id){

        model.addAttribute("list",ms.delete(id));
        return "admin/MauSac";
    }
    @GetMapping("/{id}")
    public String details(Model model,@PathVariable("id") int id) throws Exception {
        System.out.println(id);
        model.addAttribute("dt",ms.details(id));
        model.addAttribute("list",ms.getAll());
        return "admin/MauSac";
    }
    @GetMapping("/view-update/{id}")
    public String viewUpdate(Model model,@PathVariable("id") int id){
        model.addAttribute("id",id);
        model.addAttribute("list",ms.getAll());
        return "admin/MauSacViewUpdate";
    }
    @PostMapping("/update")
    public String Update(MauSac data, Model model){
        model.addAttribute("list",ms.update(data));
        return "admin/MauSac";
    }
}
