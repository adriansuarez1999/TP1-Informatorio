package com.info.moodtrack.controller;

import com.info.moodtrack.dto.habito.HabitoCreateDto;
import com.info.moodtrack.dto.habito.HabitoDto;
import com.info.moodtrack.service.habito.HabitoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/habitos")
public class HabitoController {

    private final HabitoService habitoService;

    public HabitoController(HabitoService habitoService) {
        this.habitoService = habitoService;
    }

    @PostMapping
    public HabitoDto crearHabito(@RequestBody HabitoCreateDto dto) {
        return habitoService.crearHabito(dto);
    }

    @GetMapping
    public List<HabitoDto> listar() {
        return habitoService.listarHabitos();
    }
}
