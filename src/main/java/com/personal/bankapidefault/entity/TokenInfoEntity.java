package com.personal.bankapidefault.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "security_token" )
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TokenInfoEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @NotBlank
    @Column(length = 800)
    private String accessToken;
    @NotBlank
    @Column(length = 800)
    private String refreshToken;
    private String userAgentText;
    private String localIpAddress;

    private String remoteIpAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private UsersEntity usersEntity;



    public TokenInfoEntity(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
