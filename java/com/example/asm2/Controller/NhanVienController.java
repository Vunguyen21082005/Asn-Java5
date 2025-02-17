package com.example.asm2.Controller;

import com.example.asm2.DTO.Request.DSPRequest;
import com.example.asm2.DTO.Request.NVRequest;
import com.example.asm2.Entity.ChucVu;
import com.example.asm2.Entity.NhanVien;
import com.example.asm2.Entity.SanPham;
import com.example.asm2.Service.ChucVuService;
import com.example.asm2.Service.CuaHangService;
import com.example.asm2.Service.NhanVienService;
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
@RequestMapping("/admin/nhan-vien")
public class NhanVienController {
    NhanVienService nv;
    CuaHangService ch;
    ChucVuService cv;
    @GetMapping("")
    public String getall(Model model){
        model.addAttribute("list",nv.getAll());
        model.addAttribute("ch",ch.getAll());
        model.addAttribute("cv",cv.getAll());
        return "admin/NhanVien";
    }
    @PostMapping("/add")
    public String add(Model model, NVRequest data){
        model.addAttribute("list",nv.add(data));
        model.addAttribute("ch",ch.getAll());
        model.addAttribute("cv",cv.getAll());
        return "admin/NhanVien";
    }
    @GetMapping("/delete/{ma}")
    public String delete(Model model,@PathVariable("ma") int id){

        model.addAttribute("list",nv.delete(id));
        model.addAttribute("ch",ch.getAll());
        model.addAttribute("cv",cv.getAll());
        return "admin/NhanVien";
    }
    @GetMapping("/{id}")
    public String details(Model model,@PathVariable("id") int id) throws Exception {
        model.addAttribute("dt",nv.details(id));
        model.addAttribute("list",nv.getAll());
        model.addAttribute("ch",ch.getAll());
        model.addAttribute("cv",cv.getAll());
        return "admin/NhanVien";
    }
    @GetMapping("/view-update/{id}")
    public String viewUpdate(Model model,@PathVariable("id") int id){
        model.addAttribute("id",id);
        model.addAttribute("list",nv.getAll());
        model.addAttribute("ch",ch.getAll());
        model.addAttribute("cv",cv.getAll());
        return "admin/NhanVienViewUpdate";
    }
    @PostMapping("/update")
    public String Update(NhanVien data, Model model){
        model.addAttribute("list",nv.update(data));
        model.addAttribute("ch",ch.getAll());
        model.addAttribute("cv",cv.getAll());
        return "admin/NhanVien";
    }
}
