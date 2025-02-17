package com.example.asm2.Repository;

import com.example.asm2.Entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoKhachHang extends JpaRepository<KhachHang, Integer> {

}
