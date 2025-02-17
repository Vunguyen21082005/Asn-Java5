package com.example.asm2.Service;

import com.example.asm2.DTO.Request.DSPRequest;
import com.example.asm2.DTO.Request.KHRequest;
import com.example.asm2.Entity.DongSP;
import com.example.asm2.Entity.KhachHang;
import com.example.asm2.Mapstruct.mapper;
import com.example.asm2.Repository.RepoChiTietSP;
import com.example.asm2.Repository.RepoDongSP;
import com.example.asm2.Repository.RepoKhachHang;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)

public class KhachHangService {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    RepoKhachHang rp;
    mapper map;
    public List<KhachHang> getAll(){
        return rp.findAll();
    }
    public List<KhachHang> add(KHRequest data){

        KhachHang kh = map.toKH(data);
        kh.setNgaySinh(data.getNgaySinh());
        rp.save(kh);
        return rp.findAll();
    }
    public List<KhachHang> delete(int id){
        rp.delete(rp.findById(id).orElseThrow());

        return rp.findAll();
    }
    public KhachHang details(int id) throws Exception {
        return rp.findById(id).orElseThrow(() -> new Exception("id khong ton tai"));

    }
    public List<KhachHang> update(KhachHang data){
        rp.save(data);
        return rp.findAll();
    }
}
