package com.example.moomin.service;

import java.util.List;

import com.example.moomin.dto.MoominDto;
import com.example.moomin.dto.MoominResponse;
import com.example.moomin.exceptions.MoominNotFoundException;
import com.example.moomin.models.Moomin;
import com.example.moomin.repository.MoominRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class MoominServiceImpl implements MoominService {

    private final MoominRepository moominRepository;

    public MoominServiceImpl(MoominRepository moominRepository) {
        this.moominRepository = moominRepository;
    }

    @Override
    public MoominResponse readAllMoomins(int pageNumber, int pageSize) {
        var page = moominRepository.findAll(PageRequest.of(pageNumber, pageSize));

        var content = page.getContent().stream()
                .map(MoominServiceImpl::mapToDto)
                .toList();

        return MoominResponse.builder()
                .content(content)
                .pageNumber(page.getNumber())
                .pageSize(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .last(page.isLast())
                .build();
    }

    @Override
    public MoominDto readMoomin(int id) {
        return moominRepository.findById(id)
                .map(MoominServiceImpl::mapToDto)
                .orElseThrow(() -> new MoominNotFoundException(":'("));
    }

    @Override
    public MoominDto createMoomin(MoominDto moominDto) {
        moominRepository.save(mapToEntity(moominDto));

        return moominDto;
    }

    @Override
    public MoominDto updateMoomin(MoominDto moominDto, int id) {
        var moomin = moominRepository.findById(id).orElseThrow(() -> new MoominNotFoundException(":'("));

        moomin.setName(moominDto.getName());
        moomin.setGender(moominDto.getGender());

        return mapToDto(moominRepository.save(moomin));
    }

    @Override
    public void deleteMoomin(int id) {
        moominRepository.deleteById(id);
    }

    private static Moomin mapToEntity(MoominDto moominDto) {
        return Moomin.builder()
                .name(moominDto.getName())
                .gender(moominDto.getGender())
                .build();
    }

    private static MoominDto mapToDto(Moomin moomin) {
        return MoominDto.builder()
                .id(moomin.getId())
                .name(moomin.getName())
                .gender(moomin.getGender())
                .build();
    }

}
