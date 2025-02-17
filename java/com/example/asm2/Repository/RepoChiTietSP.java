package com.example.asm2.Repository;

import com.example.asm2.Entity.ChiTietSP;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepoChiTietSP extends JpaRepository<ChiTietSP,Integer> {
    @Modifying
    @Transactional
    @Query(value = "delete ChiTietSP where IdDongSP = ?1",nativeQuery = true)
    int xoa(int id);

    @Modifying
    @Transactional
    @Query(value = "delete ChiTietSP where IdMauSac = ?1",nativeQuery = true)
    int xoa1(int id);

    @Modifying
    @Transactional
    @Query(value = "delete ChiTietSP where IdNSX = ?1",nativeQuery = true)
    int xoa2(int id);

    @Modifying
    @Transactional
    @Query(value = "delete ChiTietSP where IdSP = ?1",nativeQuery = true)
    int xoa3(int id);
    @Query(value = "select * from ChiTietSP where IdSP is not null ",nativeQuery = true)
    List<ChiTietSP> tk();

}
