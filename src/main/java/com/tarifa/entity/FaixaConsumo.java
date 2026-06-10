package com.tarifa.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "faixa_consumo")
@Getter
@Setter
public class FaixaConsumo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer inicio;
	
	private Integer fim;
	
	private BigDecimal valorUnitario;
	
	@ManyToOne
	private CategoriaTarifaria categoriaTarifaria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public CategoriaTarifaria getCategoriaTarifaria() {
		return categoriaTarifaria;
	}

	public void setCategoriaTarifaria(CategoriaTarifaria categoriaTarifaria) {
		this.categoriaTarifaria = categoriaTarifaria;
	}	

}
