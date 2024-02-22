package com.personal.libraryapi.dto;


import com.personal.libraryapi.entity.UsersEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenInfoDto {
     String accessToken;
     String refreshToken;
     String userAgentText;
     String localIpAddress;
     String remoteIpAddress;
     UsersEntity usersEntity;
}
