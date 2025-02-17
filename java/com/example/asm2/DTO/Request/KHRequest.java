package com.example.asm2.DTO.Request;

import lombok.Data;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Getter
public class KHRequest {
    private String ma;
    private String ten;
    private String tenDem;
    private String ho;
    private String ngaySinh;
    private String sdt;
    private String diaChi;
    private String thanhPho;
    private String quocGia;
    private String matKhau;

}
