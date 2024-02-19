package com.personal.bankapidefault.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class JwtResponseDto {

    private String accessToken;
    private String refreshToken;

}
