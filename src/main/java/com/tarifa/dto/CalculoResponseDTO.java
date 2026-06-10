package com.tarifa.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class CalculoResponseDTO {
	
	private String categoria;

    private Integer consumoTotal;

    private BigDecimal valorTotal;

    private List<DetalhamentoFaixaDTO> detalhamento;

}
