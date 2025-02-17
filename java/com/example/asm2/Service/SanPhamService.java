package com.example.asm2.Service;

import com.example.asm2.DTO.Request.DSPRequest;
import com.example.asm2.Entity.DongSP;
import com.example.asm2.Entity.SanPham;
import com.example.asm2.Mapstruct.mapper;
import com.example.asm2.Repository.RepoChiTietSP;
import com.example.asm2.Repository.RepoDongSP;
import com.example.asm2.Repository.RepoSanPham;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class SanPhamService {
    RepoSanPham rp;
    RepoChiTietSP sp;
    mapper map;
    public List<SanPham> getAll(){
        return rp.findAll();
    }
    public List<SanPham> add(DSPRequest data){
        rp.save(map.toSP(data));
        return rp.findAll();
    }
    public List<SanPham> delete(int ma){
        sp.xoa3(ma);
        rp.delete(rp.findById(ma).orElseThrow());
        return rp.findAll();
    }
    public SanPham details(int id) throws Exception {
        return rp.findById(id).orElseThrow(() -> new Exception("id khong ton tai"));

    }
    public List<SanPham> update(SanPham data){
        rp.save(data);
        return rp.findAll();
    }
}
