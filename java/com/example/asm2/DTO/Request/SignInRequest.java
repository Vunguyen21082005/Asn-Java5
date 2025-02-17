package com.example.asm2.DTO.Request;

import com.example.asm2.Entity.ChucVu;
import lombok.Data;
import lombok.Getter;

@Data
public class SignInRequest {
    private String ma;
    private String matKhau;
}
