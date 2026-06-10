package com.tarifa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tarifa.entity.CategoriaTarifaria;
import com.tarifa.enums.CategoriaConsumidor;

@Repository
public interface CategoriaTarifariaRepository extends JpaRepository<CategoriaTarifaria, Long> {
	
	Optional<CategoriaTarifaria>
    findByCategoria(CategoriaConsumidor categoria);

}
