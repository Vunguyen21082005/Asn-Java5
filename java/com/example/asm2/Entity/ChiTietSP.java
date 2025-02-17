package com.example.asm2.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "ChiTietSP")
public class ChiTietSP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @ManyToOne
    @JoinColumn(name = "IdSP", referencedColumnName = "id")
    SanPham sp;
    @ManyToOne
    @JoinColumn(name = "IdNsx", referencedColumnName = "id")
    NSX nsx;
    @ManyToOne
    @JoinColumn(name = "IdMauSac", referencedColumnName = "id")
    MauSac mauSac;
    @ManyToOne
    @JoinColumn(name = "IdDongSP", referencedColumnName = "id")
    DongSP dongSP;
    @Column(name = "NamBH")
    Integer namBH;
    @Column(name = "MoTa")
    String moTa;
    @Column(name = "SoLuongTon")
    Integer soLuongTon;
    @Column(name = "GiaNhap")
    Integer giaNhap;
    @Column(name = "GiaBan")
    Integer giaBan;
}
