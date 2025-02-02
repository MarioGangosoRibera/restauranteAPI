package com.example.restauranteapi.repository;

import com.example.restauranteapi.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
    List<Restaurante> findByCiudad(String ciudad);
    List<Restaurante> findByTipoCocina(String tipoCocina);
}
