package com.example.asm2.Service;

import com.example.asm2.DTO.Request.SignInRequest;
import com.example.asm2.Entity.KhachHang;
import com.example.asm2.Entity.NhanVien;
import com.example.asm2.Mapstruct.mapper;
import com.example.asm2.Repository.RepoKhachHang;
import com.example.asm2.Repository.RepoNhanVien;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;
@Service
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequiredArgsConstructor
public class GenerateToken {
    @NonFinal
    @Value("${user.key}")
    String key;
    RepoNhanVien rp;
    mapper map;

    public String dangNhap(SignInRequest data) throws JOSEException {
        NhanVien kh = rp.findNhanVienByMa(data.getMa());
        if(rp.existsNhanVienByMa(data.getMa()) && data.getMatKhau().equals(kh.getMatKhau())){
           return generateToken(kh);
        }
        return null;
    }
    public String generateToken(NhanVien data) throws JOSEException {
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);
        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .issueTime(new Date())
                .claim("scope",data.getIdCV().getMa())
                .build();
        Payload payload = claimsSet.toPayload();
        JWSObject object = new JWSObject(header,payload);
        object.sign(new MACSigner(key.getBytes()));
        return object.serialize();
    }
    public boolean verifyToken(String token) throws JOSEException, ParseException {
        MACVerifier verifier = new MACVerifier(key.getBytes());
        SignedJWT signedJWT = SignedJWT.parse(token);
        return signedJWT.verify(verifier);
    }
}
