package com.example.asm2.Mapstruct;

import com.example.asm2.DTO.Request.*;
import com.example.asm2.DTO.Response.CTResponse;
import com.example.asm2.Entity.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface mapper {
    ChiTietSP toCTSP(SPCTRequest data);
    DongSP toDSP(DSPRequest data);
    MauSac toMS(DSPRequest data);
    NSX toNSX(DSPRequest data);
    SanPham toSP(DSPRequest data);
    ChucVu toCV(DSPRequest data);
    KhachHang toKH(KHRequest data);
    CuaHang toCH(CuaHangRequest data);
    NhanVien toNV(NVRequest data);
    NhanVien toNV2(SignInRequest data);
}
