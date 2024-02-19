package com.personal.bankapidefault.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Setter
@Getter
public class IdRequestDto {

    @NotEmpty
    private long id;


}
