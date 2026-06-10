package com.tarifa.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tarifa.entity.FaixaConsumo;

@Service
public class CalculoService {
	
	public BigDecimal calcular(List<FaixaConsumo> faixas,
            Integer consumo) {
		
		BigDecimal total = BigDecimal.ZERO;
		
		int restante = consumo;
		
		for(FaixaConsumo faixa : faixas) {
			
			if(restante <= 0)
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
                        BigDecimal.valueOf(consumido));
			
			total = total.add(subtotal);
			
			restante -= consumido;
			
		}
		
		return total;
		
	}

}
