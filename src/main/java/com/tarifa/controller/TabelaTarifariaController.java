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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(
        name = "Tabela Tarifária",
        description = "Gerenciamento das tabelas")
@RestController
@RequestMapping("/api/tabelas-tarifarias")
@RequiredArgsConstructor
public class TabelaTarifariaController {
	
	@Autowired
	private TabelaTarifariaService service;
	
	@Operation(
	        summary = "Cadastrar tabela tarifária")
	@PostMapping
    public ResponseEntity<?> salvar(
            @RequestBody TabelaTarifariaDTO dto) {

        return ResponseEntity.ok(
                service.salvar(dto));
    }
	
	@Operation(
	        summary = "Listar tabelas")
	@GetMapping
    public List<TabelaTarifaria> listar() {
        return service.listar();
    }
	
	@Operation(
	        summary = "Excluir tabela")
	@DeleteMapping("/{id}")
    public void excluir(
            @PathVariable Long id) {

        service.excluir(id);
    }

}
