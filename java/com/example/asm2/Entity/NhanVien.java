package com.example.asm2.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NhanVien")
public class NhanVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Ma", nullable = false, unique = true)
    private String ma;

    @Column(name = "Ten", nullable = false)
    private String ten;

    @Column(name = "TenDem")
    private String tenDem;

    @Column(name = "Ho", nullable = false)
    private String ho;

    @Column(name = "GioiTinh")
    private String gioiTinh;

//    @Temporal(TemporalType.DATE)
    @Column(name = "NgaySinh")
    private String ngaySinh;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "Sdt")
    private String sdt;

    @Column(name = "MatKhau")
    private String matKhau;

    @ManyToOne
    @JoinColumn(name = "IdCH",referencedColumnName = "id")
    private CuaHang idCH;

    @ManyToOne
    @JoinColumn(name = "IdCV", referencedColumnName = "id")
    private ChucVu idCV;

    @Column(name = "TrangThai")
    private Boolean trangThai;
}
