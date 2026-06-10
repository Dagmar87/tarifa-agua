package com.tarifa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tarifa.entity.CategoriaTarifaria;

@Repository
public interface CategoriaTarifariaRepository extends JpaRepository<CategoriaTarifaria, Long> {

}
