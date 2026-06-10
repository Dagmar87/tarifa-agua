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

}
