package com.example.moomin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class MoominDto {
    private int id;
    private String name;
    private String gender;
}
