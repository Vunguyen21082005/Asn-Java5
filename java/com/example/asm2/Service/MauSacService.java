package com.example.asm2.Service;

import com.example.asm2.DTO.Request.DSPRequest;
import com.example.asm2.Entity.DongSP;
import com.example.asm2.Entity.MauSac;
import com.example.asm2.Mapstruct.mapper;
import com.example.asm2.Repository.RepoChiTietSP;
import com.example.asm2.Repository.RepoDongSP;
import com.example.asm2.Repository.RepoMauSac;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class MauSacService {
    RepoMauSac rp;
    RepoChiTietSP ctsp;
    mapper map;
    public List<MauSac> getAll(){
        return rp.findAll();
    }
    public List<MauSac> add(DSPRequest data){
        rp.save(map.toMS(data));
        return rp.findAll();
    }
    public List<MauSac> delete(int id){
        ctsp.xoa1(id);
        rp.delete(rp.findById(id).orElseThrow());
        return rp.findAll();
    }
    public MauSac details(int id) throws Exception {
        return rp.findById(id).orElseThrow(() -> new Exception("id khong ton tai"));

    }
    public List<MauSac> update(MauSac data){
        rp.save(data);
        return rp.findAll();
    }
}
