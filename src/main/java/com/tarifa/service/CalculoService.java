package com.tarifa.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarifa.dto.CalculoRequestDTO;
import com.tarifa.dto.CalculoResponseDTO;
import com.tarifa.dto.DetalhamentoFaixaDTO;
import com.tarifa.entity.CategoriaTarifaria;
import com.tarifa.entity.FaixaConsumo;
import com.tarifa.exception.ResourceNotFoundException;
import com.tarifa.repository.CategoriaTarifariaRepository;
import com.tarifa.repository.FaixaConsumoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CalculoService {
	
	@Autowired
	private CategoriaTarifariaRepository categoriaRepository;
	
	@Autowired
    private FaixaConsumoRepository faixaRepository;

    public CalculoResponseDTO calcularConta(
            CalculoRequestDTO dto) {

        CategoriaTarifaria categoria =
                categoriaRepository
                .findByCategoria(dto.getCategoria())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Categoria não encontrada"));

        List<FaixaConsumo> faixas =
                faixaRepository
                .findByCategoriaTarifariaIdOrderByInicioAsc(
                        categoria.getId());

        BigDecimal total = BigDecimal.ZERO;

        int restante = dto.getConsumo();

        List<DetalhamentoFaixaDTO> detalhes =
                new ArrayList<>();

        for (FaixaConsumo faixa : faixas) {

            if (restante <= 0)
                break;

            int tamanhoFaixa =
                    faixa.getFim()
                    - faixa.getInicio()
                    + 1;

            int consumido =
                    Math.min(restante,
                            tamanhoFaixa);

            BigDecimal subtotal =
                    faixa.getValorUnitario()
                    .multiply(
                            BigDecimal.valueOf(
                                    consumido));

            total = total.add(subtotal);

            DetalhamentoFaixaDTO detalhe =
                    new DetalhamentoFaixaDTO();

            detalhe.setInicio(
                    faixa.getInicio());

            detalhe.setFim(
                    faixa.getFim());

            detalhe.setM3Cobrados(
                    consumido);

            detalhe.setValorUnitario(
                    faixa.getValorUnitario());

            detalhe.setSubtotal(
                    subtotal);

            detalhes.add(detalhe);

            restante -= consumido;
        }

        CalculoResponseDTO response =
                new CalculoResponseDTO();

        response.setCategoria(
                dto.getCategoria().name());

        response.setConsumoTotal(
                dto.getConsumo());

        response.setValorTotal(
                total);

        response.setDetalhamento(
                detalhes);

        return response;
    }

}
