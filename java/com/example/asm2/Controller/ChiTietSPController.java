package com.example.asm2.Controller;

import com.example.asm2.DTO.Request.SPCTRequest;
import com.example.asm2.Entity.ChiTietSP;
import com.example.asm2.Entity.NSX;
import com.example.asm2.Service.*;
import com.nimbusds.jose.JOSEException;
import jakarta.servlet.http.HttpSession;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequestMapping("/admin/chi-tiet-san-pham")
public class ChiTietSPController {

    ChiTietSPService se;
    DongSPService dsp;
    MauSacService ms;
    NSXService nsx;
    SanPhamService sp;
    GenerateToken gt;
    @GetMapping("")
    public String getAll(Model model, HttpSession session) throws ParseException, JOSEException {
        model.addAttribute("list",se.getAll());
        model.addAttribute("dsp",dsp.getAll());
        model.addAttribute("ms",ms.getAll());
        model.addAttribute("nsx",nsx.getAll());
        model.addAttribute("sp",sp.getAll());
        session.setAttribute("tk","hung");
        session.setAttribute("mk","hung");

        return "admin/ChiTietSanPham";
    }
    @PostMapping("/add")
    public String add(Model model,SPCTRequest data){
        model.addAttribute("list",se.add(data));
        model.addAttribute("dsp",dsp.getAll());
        model.addAttribute("ms",ms.getAll());
        model.addAttribute("nsx",nsx.getAll());
        model.addAttribute("sp",sp.getAll());
        return "admin/ChiTietSanPham";
    }
    @GetMapping("/delete/{ma}")
    public String delete(Model model,@PathVariable("ma") int id){
        model.addAttribute("list",se.delete(id));
        model.addAttribute("dsp",dsp.getAll());
        model.addAttribute("ms",ms.getAll());
        model.addAttribute("nsx",nsx.getAll());
        model.addAttribute("sp",sp.getAll());
        return "admin/ChiTietSanPham";
    }
//    @GetMapping("/{id}")
//    public String details(Model model,@PathVariable("id") int id) throws Exception {
//        model.addAttribute("dt",se.details(id));
//        model.addAttribute("list",se.getAll());
//        model.addAttribute("dsp",dsp.getAll());
//        model.addAttribute("ms",ms.getAll());
//        model.addAttribute("nsx",nsx.getAll());
//        model.addAttribute("sp",sp.getAll());
//        return "admin/ChiTietSanPham";
//    }
    @GetMapping("/view-update/{id}")
    public String viewUpdate(Model model,@PathVariable("id") int id){
        model.addAttribute("id",id);
        model.addAttribute("list",se.getAll());
        model.addAttribute("dsp",dsp.getAll());
        model.addAttribute("ms",ms.getAll());
        model.addAttribute("nsx",nsx.getAll());
        model.addAttribute("sp",sp.getAll());
        return "admin/ChiTietSanPhamViewUpdate";
    }
    @PostMapping("/update")
    public String Update(ChiTietSP data,Model model){
        model.addAttribute("list",se.update(data));
        model.addAttribute("dsp",dsp.getAll());
        model.addAttribute("ms",ms.getAll());
        model.addAttribute("nsx",nsx.getAll());
        model.addAttribute("sp",sp.getAll());
        return "admin/ChiTietSanPham";
    }
}
