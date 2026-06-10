package com.tarifa.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class DetalhamentoFaixaDTO {
	
	private Integer inicio;

    private Integer fim;

    private Integer m3Cobrados;

    private BigDecimal valorUnitario;

    private BigDecimal subtotal;

}
