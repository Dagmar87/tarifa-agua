package com.tarifa.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class FaixaDTO {
	
	private Integer inicio;

    private Integer fim;

    private BigDecimal valorUnitario;

	public Integer getInicio() {
		return inicio;
	}

	public void setInicio(Integer inicio) {
		this.inicio = inicio;
	}

	public Integer getFim() {
		return fim;
	}

	public void setFim(Integer fim) {
		this.fim = fim;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}  

}
