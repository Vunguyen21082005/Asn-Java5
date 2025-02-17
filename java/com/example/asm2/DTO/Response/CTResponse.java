package com.example.asm2.DTO.Response;

import com.example.asm2.Entity.DongSP;
import com.example.asm2.Entity.MauSac;
import com.example.asm2.Entity.NSX;
import com.example.asm2.Entity.SanPham;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class CTResponse {
    Integer id;
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
