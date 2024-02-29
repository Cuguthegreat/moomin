package com.example.moomin.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MoominResponse {
    private List<MoominDto> content;
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;

}
