package com.example.moomin.service;

import java.util.List;

import com.example.moomin.dto.MoominDto;
import com.example.moomin.dto.MoominResponse;

public interface MoominService {
    MoominResponse readAllMoomins(int pageNumber, int pageSize);
    MoominDto readMoomin(int id);
    MoominDto createMoomin(MoominDto moominDto);

    MoominDto updateMoomin(MoominDto moominDto, int id);

    void deleteMoomin(int id);

}
