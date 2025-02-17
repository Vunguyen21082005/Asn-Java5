package com.example.asm2.Service;

import com.example.asm2.DTO.Request.DSPRequest;
import com.example.asm2.DTO.Request.NVRequest;
import com.example.asm2.Entity.NhanVien;
import com.example.asm2.Entity.SanPham;
import com.example.asm2.Mapstruct.mapper;
import com.example.asm2.Repository.RepoChiTietSP;
import com.example.asm2.Repository.RepoNhanVien;
import com.example.asm2.Repository.RepoSanPham;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class NhanVienService {
    RepoNhanVien rp;
    mapper map;
    public List<NhanVien> getAll(){
        return rp.findAll();
    }
    public List<NhanVien> add(NVRequest data){
        rp.save(map.toNV(data));
        return rp.findAll();
    }
    public List<NhanVien> delete(int ma){
        rp.delete(rp.findById(ma).orElseThrow());
        return rp.findAll();
    }
    public NhanVien details(int id) throws Exception {
        return rp.findById(id).orElseThrow(() -> new Exception("id khong ton tai"));

    }
    public List<NhanVien> update(NhanVien data){
        rp.save(data);
        return rp.findAll();
    }
}
