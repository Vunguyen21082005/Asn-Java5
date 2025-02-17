package com.example.asm2.Controller;

import com.example.asm2.DTO.Request.DSPRequest;
import com.example.asm2.DTO.Request.KHRequest;
import com.example.asm2.Entity.DongSP;
import com.example.asm2.Entity.KhachHang;
import com.example.asm2.Service.DongSPService;
import com.example.asm2.Service.KhachHangService;
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
@RequestMapping("/admin/khach-hang")

public class KhachHangController {
    KhachHangService dsp;
    @GetMapping("")
    public String getall(Model model){
        model.addAttribute("list",dsp.getAll());
        return "user/KhachHang";
    }
    @PostMapping("/add")
    public String add(Model model, KHRequest data){
        model.addAttribute("list",dsp.add(data));
        return "user/KhachHang";
    }
    @GetMapping("/delete/{ma}")
    public String delete(Model model,@PathVariable("ma") int id){
        model.addAttribute("list",dsp.delete(id));
        return "user/KhachHang";
    }
    @GetMapping("/{id}")
    public String details(Model model,@PathVariable("id") int id) throws Exception {
        model.addAttribute("dt",dsp.details(id));
        model.addAttribute("list",dsp.getAll());
        return "user/KhachHang";
    }
    @GetMapping("/view-update/{id}")
    public String viewUpdate(Model model,@PathVariable("id") int id){
        model.addAttribute("id",id);
        model.addAttribute("list",dsp.getAll());
        return "user/KhachHangViewUpdate";
    }
    @PostMapping("/update")
    public String Update(KhachHang data, Model model){
        model.addAttribute("list",dsp.update(data));
        return "user/KhachHang";
    }
}
