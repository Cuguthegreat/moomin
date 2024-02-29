package com.example.moomin.controller;

import java.util.List;

import com.example.moomin.dto.MoominDto;
import com.example.moomin.dto.MoominResponse;
import com.example.moomin.models.Moomin;
import com.example.moomin.service.MoominService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class MoominController {

    private final MoominService moominService;

    public MoominController(MoominService moominService) {
        this.moominService = moominService;
    }

    @GetMapping("moomins")
    public ResponseEntity<MoominResponse> getAllMoomins(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "2") int pageSize) {

        return ResponseEntity.ok(moominService.readAllMoomins(pageNumber, pageSize));
    }

    @GetMapping("moomins/{id}")
    public ResponseEntity<MoominDto> getMoomins(@PathVariable int id) {
        return ResponseEntity.ok(moominService.readMoomin(id));
    }

    @PostMapping("moomins")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MoominDto> postMoomins(@RequestBody MoominDto moominDto) {
        return new ResponseEntity<>(moominService.createMoomin(moominDto), HttpStatus.CREATED);
    }

    @PutMapping("moomins/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MoominDto> putMoomins(@RequestBody MoominDto moominDto, @PathVariable int id) {
        return new ResponseEntity<>(moominService.updateMoomin(moominDto, id), HttpStatus.OK);
    }

    @DeleteMapping("moomins/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMoomins(@PathVariable int id) {
        moominService.deleteMoomin(id);
    }
}
