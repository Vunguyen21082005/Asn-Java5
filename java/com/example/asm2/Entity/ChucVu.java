package com.example.asm2.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ChucVu")
public class ChucVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "Ma")
    String ma;
    @Column(name = "Ten")
    String ten;
    @JsonIgnore
    @OneToMany(mappedBy = "idCV",cascade = CascadeType.ALL)
    List<NhanVien> nv;
}
