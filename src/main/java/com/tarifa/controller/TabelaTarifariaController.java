package com.tarifa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarifa.dto.TabelaTarifariaDTO;
import com.tarifa.entity.TabelaTarifaria;
import com.tarifa.service.TabelaTarifariaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tabelas-tarifarias")
@RequiredArgsConstructor
public class TabelaTarifariaController {
	
	@Autowired
	private TabelaTarifariaService service;
	
	@PostMapping
    public ResponseEntity<?> salvar(
            @RequestBody TabelaTarifariaDTO dto) {

        return ResponseEntity.ok(
                service.salvar(dto));
    }
	
	@GetMapping
    public List<TabelaTarifaria> listar() {
        return service.listar();
    }
	
	@DeleteMapping("/{id}")
    public void excluir(
            @PathVariable Long id) {

        service.excluir(id);
    }

}
