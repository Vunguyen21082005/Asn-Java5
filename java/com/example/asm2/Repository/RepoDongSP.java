package com.example.asm2.Repository;

import com.example.asm2.Entity.ChiTietSP;
import com.example.asm2.Entity.DongSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoDongSP extends JpaRepository<DongSP,Integer> {
}
