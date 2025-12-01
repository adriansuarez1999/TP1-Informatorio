package com.info.moodtrack.service.habito.impl;

import com.info.moodtrack.dto.habito.HabitoCreateDto;
import com.info.moodtrack.dto.habito.HabitoDto;
import com.info.moodtrack.model.Habito;
import com.info.moodtrack.repository.habito.HabitoRepository;
import com.info.moodtrack.service.habito.HabitoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitoServiceImpl implements HabitoService {

    private final HabitoRepository habitoRepository;

    public HabitoServiceImpl(HabitoRepository habitoRepository) {
        this.habitoRepository = habitoRepository;
    }

    @Override
    public HabitoDto crearHabito(HabitoCreateDto dto) {
        Habito h = new Habito();
        h.setDescripcion(dto.descripcion());
        Habito guardado = habitoRepository.save(h);
        return new HabitoDto(guardado.getId(), guardado.getDescripcion());
    }

    @Override
    public List<HabitoDto> listarHabitos() {
        return habitoRepository.findAll()
                .stream()
                .map(h -> new HabitoDto(h.getId(), h.getDescripcion()))
                .toList();
    }
}

