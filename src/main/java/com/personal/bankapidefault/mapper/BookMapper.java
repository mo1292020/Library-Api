package com.personal.bankapidefault.mapper;

import com.personal.bankapidefault.dto.BookDto;
import com.personal.bankapidefault.dto.UserDto;
import com.personal.bankapidefault.entity.BookEntity;
import com.personal.bankapidefault.entity.UsersEntity;
import com.personal.bankapidefault.security.APPUserDetail;

public interface BookMapper {

    BookDto toDto(final BookEntity bookEntity);
    BookEntity toEntity(final BookDto bookDto);


}
