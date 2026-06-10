package com.tarifa.dto;

import java.util.List;

import lombok.Data;

@Data
public class TabelaTarifariaDTO {
	
	private String nome;

    private List<CategoriaDTO> categorias;

}
