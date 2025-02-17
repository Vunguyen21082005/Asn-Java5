package com.example.asm2.Repository;

import com.example.asm2.Entity.CuaHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoCuaHang extends JpaRepository<CuaHang,Integer> {
}
