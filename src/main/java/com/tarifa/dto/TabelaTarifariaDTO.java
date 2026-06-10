package com.tarifa.dto;

import java.util.List;

import lombok.Data;

@Data
public class TabelaTarifariaDTO {
	
	private String nome;

    private List<CategoriaDTO> categorias;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<CategoriaDTO> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<CategoriaDTO> categorias) {
		this.categorias = categorias;
	}    

}
