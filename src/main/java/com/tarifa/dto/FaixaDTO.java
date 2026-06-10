package com.tarifa.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class FaixaDTO {
	
	private Integer inicio;

    private Integer fim;

    private BigDecimal valorUnitario;

}
