package com.example.restauranteapi.controller;

import com.example.restauranteapi.model.Restaurante;
import com.example.restauranteapi.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @GetMapping("/ciudad/{ciudad}")
    public List<Restaurante> buscarPorCiudad(@PathVariable String ciudad){
        return restauranteRepository.findByCiudad(ciudad);
    }

    @GetMapping("/tipo-cocina/{tipoCocina}")
    public List<Restaurante> buscarPorTipoCocina(@PathVariable String tipoCocina){
        return restauranteRepository.findByTipoCocina(tipoCocina);
    }

    @PostMapping
    public Restaurante registrarRestaurante(@RequestBody Restaurante restaurante){
        return restauranteRepository.save(restaurante);
    }
}
