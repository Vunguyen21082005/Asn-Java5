package com.example.asm2.Controller;

import com.example.asm2.DTO.Request.DSPRequest;
import com.example.asm2.Entity.ChiTietSP;
import com.example.asm2.Entity.DongSP;
import com.example.asm2.Service.DongSPService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequestMapping("/admin/dong-san-pham")
public class DongSPController {
    DongSPService dsp;
    @GetMapping("")
    public String getall(Model model){
        model.addAttribute("list",dsp.getAll());
        return "admin/DongSanPham";
    }
    @PostMapping("/add")
    public String add(Model model,DSPRequest data){
        model.addAttribute("list",dsp.add(data));
        return "admin/DongSanPham";
    }
    @GetMapping("/delete/{ma}")
    public String delete(Model model,@PathVariable("ma") int id){

        model.addAttribute("list",dsp.delete(id));
        return "admin/DongSanPham";
    }
    @GetMapping("/{id}")
    public String details(Model model,@PathVariable("id") int id) throws Exception {
        model.addAttribute("dt",dsp.details(id));
        model.addAttribute("list",dsp.getAll());
        return "admin/DongSanPham";
    }
    @GetMapping("/view-update/{id}")
    public String viewUpdate(Model model,@PathVariable("id") int id){
        model.addAttribute("id",id);
        model.addAttribute("list",dsp.getAll());
        return "admin/DongSanPhamViewUpdate";
    }
    @PostMapping("/update")
    public String Update(DongSP data, Model model){

        model.addAttribute("list",dsp.update(data));
        return "admin/DongSanPham";
    }
}
