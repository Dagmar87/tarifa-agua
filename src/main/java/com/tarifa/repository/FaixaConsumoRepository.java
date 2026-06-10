package com.tarifa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tarifa.entity.FaixaConsumo;

@Repository
public interface FaixaConsumoRepository extends JpaRepository<FaixaConsumo, Long> {
	
	List<FaixaConsumo> findByCategoriaTarifariaIdOrderByInicioAsc(Long id);

}
