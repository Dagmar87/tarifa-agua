package com.tarifa.validador;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tarifa.dto.FaixaDTO;

@Component
public class FaixaValidator {

    public void validar(List<FaixaDTO> faixas) {

        if (faixas.isEmpty()) {
            throw new IllegalArgumentException(
                    "Nenhuma faixa informada");
        }

        faixas.sort(
            Comparator.comparing(FaixaDTO::getInicio));

        if (faixas.get(0).getInicio() != 0) {
            throw new IllegalArgumentException(
                    "Primeira faixa deve iniciar em 0");
        }

        for (int i = 0; i < faixas.size(); i++) {

            FaixaDTO atual = faixas.get(i);

            if (atual.getInicio() >= atual.getFim()) {

                throw new IllegalArgumentException(
                        "Faixa inválida");
            }

            if (i > 0) {

                FaixaDTO anterior = faixas.get(i - 1);

                if (atual.getInicio()
                        <= anterior.getFim()) {

                    throw new IllegalArgumentException(
                            "Faixas sobrepostas");
                }
            }
        }
    }
}
