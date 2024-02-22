package com.personal.libraryapi.mapper;

import com.personal.libraryapi.dto.BookDto;
import com.personal.libraryapi.entity.BookEntity;

public interface BookMapper {

    BookDto toDto(final BookEntity bookEntity);
    BookEntity toEntity(final BookDto bookDto);


}
