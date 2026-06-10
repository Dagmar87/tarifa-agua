package com.tarifa.dto;

import java.util.List;

import com.tarifa.enums.CategoriaConsumidor;

import lombok.Data;

@Data
public class CategoriaDTO {
	
	private CategoriaConsumidor categoria;

    private List<FaixaDTO> faixas;

	public CategoriaConsumidor getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaConsumidor categoria) {
		this.categoria = categoria;
	}

	public List<FaixaDTO> getFaixas() {
		return faixas;
	}

	public void setFaixas(List<FaixaDTO> faixas) {
		this.faixas = faixas;
	}    

}
