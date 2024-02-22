package com.personal.libraryapi.mapper.impl;

import com.personal.libraryapi.dto.BookDto;
import com.personal.libraryapi.entity.BookEntity;
import com.personal.libraryapi.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookMapperImpl implements BookMapper {
    @Override
    public BookDto toDto(BookEntity bookEntity) {
        return BookDto.builder()
                .id(bookEntity.getId())
                .title(bookEntity.getTitle())
                .author(bookEntity.getAuthor())
                .category(bookEntity.getCategory())
                .ISBN(bookEntity.getISBN())
                .pageNumber(bookEntity.getPageNumber())
                .price(bookEntity.getPrice())
                .deploydAt(bookEntity.getDeploydAt())
                .owner(bookEntity.getOwner())
                .build();
    }

    @Override
    public BookEntity toEntity(BookDto bookDto) {
        return BookEntity.builder()
                .id(bookDto.getId())
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .category(bookDto.getCategory())
                .ISBN(bookDto.getISBN())
                .pageNumber(bookDto.getPageNumber())
                .price(bookDto.getPrice())
                .deploydAt(bookDto.getDeploydAt())
                .owner(bookDto.getOwner())
                .build();
    }
}
