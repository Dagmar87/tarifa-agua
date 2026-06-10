package com.tarifa.dto;

import com.tarifa.enums.CategoriaConsumidor;

import lombok.Data;

@Data
public class CalculoRequestDTO {
	
	private CategoriaConsumidor categoria;
	
	private Integer consumo;

}
