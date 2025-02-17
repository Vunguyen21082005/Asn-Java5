package com.example.asm2.DTO.Request;

import com.example.asm2.Entity.DongSP;
import com.example.asm2.Entity.MauSac;
import com.example.asm2.Entity.NSX;
import com.example.asm2.Entity.SanPham;
import lombok.Data;

@Data
public class SPCTRequest {
    SanPham sp;
    NSX nsx;
    MauSac mauSac;
    DongSP dongSP;
    Integer namBH;
    String moTa;
    Integer soLuongTon;
    Integer giaNhap;
    Integer giaBan;
}
