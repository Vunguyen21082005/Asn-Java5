package com.example.asm2.Controller;

import com.example.asm2.DTO.Request.CuaHangRequest;
import com.example.asm2.DTO.Request.DSPRequest;
import com.example.asm2.Entity.CuaHang;
import com.example.asm2.Entity.DongSP;
import com.example.asm2.Service.CuaHangService;
import com.example.asm2.Service.DongSPService;
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
@RequestMapping("/admin/cua-hang")
public class CuaHangController {
    CuaHangService ch;
    @GetMapping("")
    public String getall(Model model){
        model.addAttribute("list",ch.getAll());
        return "admin/CuaHang";
    }
    @PostMapping("/add")
    public String add(Model model, CuaHangRequest data){
        model.addAttribute("list",ch.add(data));
        return "admin/CuaHang";
    }
    @GetMapping("/delete/{ma}")
    public String delete(Model model,@PathVariable("ma") int id){

        model.addAttribute("list",ch.delete(id));
        return "admin/CuaHang";
    }
    @GetMapping("/{id}")
    public String details(Model model,@PathVariable("id") int id) throws Exception {
        model.addAttribute("dt",ch.details(id));
        model.addAttribute("list",ch.getAll());
        return "admin/CuaHang";
    }
    @GetMapping("/view-update/{id}")
    public String viewUpdate(Model model,@PathVariable("id") int id){
        model.addAttribute("id",id);
        model.addAttribute("list",ch.getAll());
        return "admin/CuaHangViewUpdate";
    }
    @PostMapping("/update")
    public String Update(CuaHang data, Model model){

        model.addAttribute("list",ch.update(data));
        return "admin/CuaHang";
    }
}
