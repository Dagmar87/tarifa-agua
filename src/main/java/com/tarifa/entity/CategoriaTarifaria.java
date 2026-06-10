package com.tarifa.entity;

import java.util.List;

import com.tarifa.enums.CategoriaConsumidor;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "categoria_tarifaria")
public class CategoriaTarifaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CategoriaConsumidor categoria;

    @ManyToOne
    @JoinColumn(name = "tabela_id")
    private TabelaTarifaria tabela;

    @OneToMany(mappedBy = "categoriaTarifaria",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    private List<FaixaConsumo> faixas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CategoriaConsumidor getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaConsumidor categoria) {
		this.categoria = categoria;
	}

	public TabelaTarifaria getTabela() {
		return tabela;
	}

	public void setTabela(TabelaTarifaria tabela) {
		this.tabela = tabela;
	}

	public List<FaixaConsumo> getFaixas() {
		return faixas;
	}

	public void setFaixas(List<FaixaConsumo> faixas) {
		this.faixas = faixas;
	}    
    
}