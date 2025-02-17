package com.example.asm2.Service;

import com.example.asm2.DTO.Request.DSPRequest;
import com.example.asm2.Entity.DongSP;
import com.example.asm2.Entity.NSX;
import com.example.asm2.Mapstruct.mapper;
import com.example.asm2.Repository.RepoChiTietSP;
import com.example.asm2.Repository.RepoDongSP;
import com.example.asm2.Repository.RepoNSX;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class NSXService {
    RepoNSX rp;
    mapper map;
    RepoChiTietSP ctsp;
    public List<NSX> getAll(){
        return rp.findAll();
    }
    public List<NSX> add(DSPRequest data){
        rp.save(map.toNSX(data));
        return rp.findAll();
    }
    public List<NSX> delete(int ma){
        ctsp.xoa2(ma);
        rp.delete(rp.findById(ma).orElseThrow());
        return rp.findAll();
    }
    public NSX details(int id) throws Exception {
        return rp.findById(id).orElseThrow(() -> new Exception("id khong ton tai"));

    }
    public List<NSX> update(NSX data){
        rp.save(data);
        return rp.findAll();
    }
}
