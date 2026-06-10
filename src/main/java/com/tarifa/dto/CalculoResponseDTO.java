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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getConsumoTotal() {
		return consumoTotal;
	}

	public void setConsumoTotal(Integer consumoTotal) {
		this.consumoTotal = consumoTotal;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<DetalhamentoFaixaDTO> getDetalhamento() {
		return detalhamento;
	}

	public void setDetalhamento(List<DetalhamentoFaixaDTO> detalhamento) {
		this.detalhamento = detalhamento;
	}    

}
