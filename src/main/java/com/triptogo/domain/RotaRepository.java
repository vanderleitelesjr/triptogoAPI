package com.triptogo.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RotaRepository extends CrudRepository<Rota, Long> {
    Iterable<Rota> findByEstado(String estado);
}
