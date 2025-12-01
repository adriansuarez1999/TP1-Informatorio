package com.info.moodtrack.service.habito;

import com.info.moodtrack.dto.habito.HabitoCreateDto;
import com.info.moodtrack.dto.habito.HabitoDto;

import java.util.List;

public interface HabitoService {

    HabitoDto crearHabito(HabitoCreateDto dto);

    List<HabitoDto> listarHabitos();
}
