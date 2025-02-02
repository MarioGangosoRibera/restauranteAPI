package com.example.restauranteapi.controller;

import com.example.restauranteapi.model.Mesa;
import com.example.restauranteapi.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesas")
public class MesaController {

    @Autowired
    private MesaRepository mesaRepository;

    @GetMapping("/restaurante/{restauranteId}")
    public List<Mesa> buscarMesaPorRestaurante(
        @PathVariable Long restauranteId,
        @RequestParam int capacidad,
        @RequestParam double precioMin,
        @RequestParam double precioMax){
        return mesaRepository.findByRestauranteIdAndCapacidadAndPrecioReservaBetweenAndReservadaFalse(restauranteId,capacidad,precioMin,precioMax);
    }

    @PostMapping
    public Mesa registrarMesa(@RequestBody Mesa mesa){
        return mesaRepository.save(mesa);
    }

    @PutMapping("/{id}/reservar")
    public Mesa reservarMesa(@PathVariable Long id){
        Mesa mesa = mesaRepository.findById(id).orElseThrow();
        mesa.setReservada(true);
        return mesaRepository.save(mesa);
    }

    @DeleteMapping("/{id}")
    public void eliminarMesa(@PathVariable Long id){
        mesaRepository.deleteById(id);
    }
}
