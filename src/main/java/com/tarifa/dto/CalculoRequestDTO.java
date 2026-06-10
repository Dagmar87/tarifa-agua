package com.tarifa.dto;

import com.tarifa.enums.CategoriaConsumidor;

import lombok.Data;

@Data
public class CalculoRequestDTO {
	
	private CategoriaConsumidor categoria;
	
	private Integer consumo;

	public CategoriaConsumidor getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaConsumidor categoria) {
		this.categoria = categoria;
	}

	public Integer getConsumo() {
		return consumo;
	}

	public void setConsumo(Integer consumo) {
		this.consumo = consumo;
	}	

}
