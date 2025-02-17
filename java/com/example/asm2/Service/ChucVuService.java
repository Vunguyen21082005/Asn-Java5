package com.example.asm2.Service;

import com.example.asm2.DTO.Request.DSPRequest;
import com.example.asm2.Entity.ChucVu;
import com.example.asm2.Entity.DongSP;
import com.example.asm2.Mapstruct.mapper;
import com.example.asm2.Repository.RepoChiTietSP;
import com.example.asm2.Repository.RepoChucVu;
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
public class ChucVuService {
    RepoChucVu rp;
    mapper map;
    public List<ChucVu> getAll(){
        return rp.findAll();
    }
    public List<ChucVu> add(DSPRequest data){
        rp.save(map.toCV(data));
        return rp.findAll();
    }
    public List<ChucVu> delete(int id){
        rp.delete(rp.findById(id).orElseThrow());

        return rp.findAll();
    }
    public ChucVu details(int id) throws Exception {
        return rp.findById(id).orElseThrow(() -> new Exception("id khong ton tai"));

    }
    public List<ChucVu> update(ChucVu data){
        rp.save(data);
        return rp.findAll();
    }
}
