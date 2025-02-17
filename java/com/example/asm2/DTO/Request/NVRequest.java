package com.example.asm2.DTO.Request;

import com.example.asm2.Entity.ChucVu;
import com.example.asm2.Entity.CuaHang;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class NVRequest {
    private String ma;
    private String ten;
    private String tenDem;
    private String ho;
    private String gioiTinh;
    private String ngaySinh;
    private String diaChi;
    private String matKhau;
    private String sdt;
    private CuaHang idCH;
    private ChucVu idCV;
    private Boolean trangThai;
}
