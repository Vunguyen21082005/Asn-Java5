package com.example.asm2.Service;

import com.example.asm2.DTO.Request.SPCTRequest;
import com.example.asm2.Entity.ChiTietSP;
import com.example.asm2.Mapstruct.mapper;
import com.example.asm2.Repository.RepoChiTietSP;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class ChiTietSPService {
    RepoChiTietSP rp;
    mapper map;
    public List<ChiTietSP> getAll(){
        return rp.tk();
    }
    public List<ChiTietSP> add(SPCTRequest data){
        rp.save(map.toCTSP(data));
        return rp.tk();
    }
    public List<ChiTietSP> delete(int data){
        rp.delete(rp.findById(data).orElseThrow());
        return rp.tk();
    }
    public ChiTietSP details(int id) throws Exception {
        return rp.findById(id).orElseThrow(() -> new Exception("id khong ton tai"));

    }
    public List<ChiTietSP> update(ChiTietSP data){
        rp.save(data);
        return rp.tk();
    }
}
