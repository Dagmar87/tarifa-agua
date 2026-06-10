package com.tarifa.dto;

import java.util.List;

import com.tarifa.enums.CategoriaConsumidor;

import lombok.Data;

@Data
public class CategoriaDTO {
	
	private CategoriaConsumidor categoria;

    private List<FaixaDTO> faixas;

}
