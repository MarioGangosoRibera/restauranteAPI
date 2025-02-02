package com.example.restauranteapi.repository;

import com.example.restauranteapi.model.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MesaRepository extends JpaRepository<Mesa, Long> {
    List<Mesa> findByRestauranteIdAndCapacidadAndPrecioReservaBetweenAndReservadaFalse(
            Long restauranteId, int capacidad, double precioMin, double precioMax);
}
