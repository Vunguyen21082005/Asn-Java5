package com.example.asm2.Repository;

import com.example.asm2.Entity.KhachHang;
import com.example.asm2.Entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoNhanVien extends JpaRepository<NhanVien,Integer> {
    NhanVien findNhanVienByMa(String ma);
    NhanVien findNhanVienById(Integer id);
    boolean existsNhanVienByMa(String ma);
}
