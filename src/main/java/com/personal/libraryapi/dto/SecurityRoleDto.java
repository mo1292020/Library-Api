package com.personal.libraryapi.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Component
public class SecurityRoleDto {

    Long id;
    String name;
}
