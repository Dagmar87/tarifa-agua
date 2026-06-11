package com.tarifa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarifa.dto.CalculoRequestDTO;
import com.tarifa.dto.CalculoResponseDTO;
import com.tarifa.service.CalculoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/calculos")
@RequiredArgsConstructor
public class CalculoController {
	
	@Autowired
	private CalculoService service;
	
	@PostMapping
    public ResponseEntity<CalculoResponseDTO>
    calcular(@RequestBody CalculoRequestDTO dto) {

        return ResponseEntity.ok(
                service.calcularConta(dto));
    }

}
