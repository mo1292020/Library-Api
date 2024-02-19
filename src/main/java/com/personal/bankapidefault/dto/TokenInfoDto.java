package com.personal.bankapidefault.dto;


import com.personal.bankapidefault.entity.UsersEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

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
