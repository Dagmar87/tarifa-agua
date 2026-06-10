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

	public Integer getM3Cobrados() {
		return m3Cobrados;
	}

	public void setM3Cobrados(Integer m3Cobrados) {
		this.m3Cobrados = m3Cobrados;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}    

}
