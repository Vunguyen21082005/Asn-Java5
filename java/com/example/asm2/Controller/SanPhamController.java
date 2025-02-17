package com.example.asm2.Controller;

import com.example.asm2.DTO.Request.DSPRequest;
import com.example.asm2.Entity.NSX;
import com.example.asm2.Entity.SanPham;
import com.example.asm2.Service.NSXService;
import com.example.asm2.Service.SanPhamService;
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
@RequestMapping("/admin/san-pham")
public class SanPhamController {

    SanPhamService sp;
    @GetMapping("")
    public String getall(Model model){
        model.addAttribute("list",sp.getAll());
        return "admin/SanPham";
    }
    @PostMapping("/add")
    public String add(Model model, DSPRequest data){
        model.addAttribute("list",sp.add(data));
        return "admin/SanPham";
    }
    @GetMapping("/delete/{ma}")
    public String delete(Model model,@PathVariable("ma") int id){

        model.addAttribute("list",sp.delete(id));
        return "admin/SanPham";
    }
    @GetMapping("/{id}")
    public String details(Model model,@PathVariable("id") int id) throws Exception {
        System.out.println(id);
        model.addAttribute("dt",sp.details(id));
        model.addAttribute("list",sp.getAll());
        return "admin/SanPham";
    }
    @GetMapping("/view-update/{id}")
    public String viewUpdate(Model model,@PathVariable("id") int id){
        model.addAttribute("id",id);
        model.addAttribute("list",sp.getAll());
        return "admin/SanPhamViewUpdate";
    }
    @PostMapping("/update")
    public String Update(SanPham data, Model model){
        model.addAttribute("list",sp.update(data));
        return "admin/SanPham";
    }
}
