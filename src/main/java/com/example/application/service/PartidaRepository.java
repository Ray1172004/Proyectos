package com.example.application.service;

import com.example.application.models.Partida;

public interface PartidaRepository {
    void wait(Partida partida);
}
