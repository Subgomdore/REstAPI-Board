package com.project.restapiboard.dto.response;

import com.project.restapiboard.entity.Board;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResPagingDto {

    private long typeNo;
    private long totalPages;
    private long totalElements;
    private int startPage;
    private int endPage;



}

