package com.example.asm2.Service;

import com.example.asm2.DTO.Request.CuaHangRequest;
import com.example.asm2.DTO.Request.DSPRequest;
import com.example.asm2.Entity.ChucVu;
import com.example.asm2.Entity.CuaHang;
import com.example.asm2.Mapstruct.mapper;
import com.example.asm2.Repository.RepoChiTietSP;
import com.example.asm2.Repository.RepoChucVu;
import com.example.asm2.Repository.RepoCuaHang;
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
public class CuaHangService {
    RepoCuaHang rp;
    mapper map;
    public List<CuaHang> getAll(){
        return rp.findAll();
    }
    public List<CuaHang> add(CuaHangRequest data){
        rp.save(map.toCH(data));
        return rp.findAll();
    }
    public List<CuaHang> delete(int id){
        rp.delete(rp.findById(id).orElseThrow());
        return rp.findAll();
    }
    public CuaHang details(int id) throws Exception {
        return rp.findById(id).orElseThrow(() -> new Exception("id khong ton tai"));

    }
    public List<CuaHang> update(CuaHang data){
        rp.save(data);
        return rp.findAll();
    }
}
