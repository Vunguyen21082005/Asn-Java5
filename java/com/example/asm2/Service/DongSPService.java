package com.example.asm2.Service;

import com.example.asm2.DTO.Request.DSPRequest;
import com.example.asm2.DTO.Request.SPCTRequest;
import com.example.asm2.Entity.ChiTietSP;
import com.example.asm2.Entity.DongSP;
import com.example.asm2.Mapstruct.mapper;
import com.example.asm2.Repository.RepoChiTietSP;
import com.example.asm2.Repository.RepoDongSP;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class DongSPService {
    RepoDongSP rp;
    RepoChiTietSP ctsp;
    mapper map;
    public List<DongSP> getAll(){
        return rp.findAll();
    }
    public List<DongSP> add(DSPRequest data){
        rp.save(map.toDSP(data));
        return rp.findAll();
    }
    public List<DongSP> delete(int id){
        log.info(String.valueOf(ctsp.xoa(id)));
        ctsp.xoa(id);
        rp.delete(rp.findById(id).orElseThrow());

        return rp.findAll();
    }
    public DongSP details(int id) throws Exception {
        return rp.findById(id).orElseThrow(() -> new Exception("id khong ton tai"));

    }
    public List<DongSP> update(DongSP data){
        rp.save(data);
        return rp.findAll();
    }
}
