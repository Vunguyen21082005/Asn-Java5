package com.example.asm2.Controller;

import com.example.asm2.DTO.Request.DSPRequest;
import com.example.asm2.Entity.MauSac;
import com.example.asm2.Entity.NSX;
import com.example.asm2.Service.MauSacService;
import com.example.asm2.Service.NSXService;
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
@RequestMapping("/admin/nsx")
public class NSXController {

    NSXService nsx;
    @GetMapping("")
    public String getall(Model model){
        model.addAttribute("list",nsx.getAll());
        return "admin/NSX";
    }
    @PostMapping("/add")
    public String add(Model model, DSPRequest data){
        model.addAttribute("list",nsx.add(data));
        return "admin/NSX";
    }
    @GetMapping("/delete/{ma}")
    public String delete(Model model,@PathVariable("ma") int id){

        model.addAttribute("list",nsx.delete(id));
        return "admin/NSX";
    }
    @GetMapping("/{id}")
    public String details(Model model,@PathVariable("id") int id) throws Exception {
        System.out.println(id);
        model.addAttribute("dt",nsx.details(id));
        model.addAttribute("list",nsx.getAll());
        return "admin/NSX";
    }
    @GetMapping("/view-update/{id}")
    public String viewUpdate(Model model,@PathVariable("id") int id){
        model.addAttribute("id",id);
        model.addAttribute("list",nsx.getAll());
        return "admin/NSXViewUpdate";
    }
    @PostMapping("/update")
    public String Update(NSX data, Model model){
        model.addAttribute("list",nsx.update(data));
        return "admin/NSX";
    }
}
