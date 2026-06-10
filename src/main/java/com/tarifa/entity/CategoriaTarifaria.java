package com.tarifa.entity;

import com.tarifa.enums.CategoriaConsumidor;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "categoria_tarifaria")
@Getter
@Setter
public class CategoriaTarifaria {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private CategoriaConsumidor categoria;
	
	@ManyToOne
	private TabelaTarifaria tabela;

}
