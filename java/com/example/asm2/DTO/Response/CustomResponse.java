package com.example.asm2.DTO.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomResponse<T> {
    boolean trangThai;
    String message;
    T result;
}
