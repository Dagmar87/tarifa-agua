package com.tarifa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarifa.dto.CategoriaDTO;
import com.tarifa.dto.FaixaDTO;
import com.tarifa.dto.TabelaTarifariaDTO;
import com.tarifa.entity.CategoriaTarifaria;
import com.tarifa.entity.FaixaConsumo;
import com.tarifa.entity.TabelaTarifaria;
import com.tarifa.exception.ResourceNotFoundException;
import com.tarifa.repository.TabelaTarifariaRepository;
import com.tarifa.validador.FaixaValidator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TabelaTarifariaService {
	
	@Autowired
	private TabelaTarifariaRepository repository;
	
	@Autowired
    private FaixaValidator faixaValidator;
    
    public TabelaTarifaria salvar(
            TabelaTarifariaDTO dto) {

        TabelaTarifaria tabela = new TabelaTarifaria();

        tabela.setNome(dto.getNome());

        List<CategoriaTarifaria> categorias = new ArrayList<>();

        for (CategoriaDTO categoriaDTO : dto.getCategorias()) {

            faixaValidator.validar(
                    categoriaDTO.getFaixas());

            CategoriaTarifaria categoria =
                    new CategoriaTarifaria();

            categoria.setCategoria(
                    categoriaDTO.getCategoria());

            categoria.setTabela(tabela);

            List<FaixaConsumo> faixas =
                    new ArrayList<>();

            for (FaixaDTO faixaDTO :
                    categoriaDTO.getFaixas()) {

                FaixaConsumo faixa =
                        new FaixaConsumo();

                faixa.setInicio(
                        faixaDTO.getInicio());

                faixa.setFim(
                        faixaDTO.getFim());

                faixa.setValorUnitario(
                        faixaDTO.getValorUnitario());

                faixa.setCategoriaTarifaria(
                        categoria);

                faixas.add(faixa);
            }

            categoria.setFaixas(faixas);

            categorias.add(categoria);
        }

        tabela.setCategorias(categorias);

        return repository.save(tabela);
    }
    
    public List<TabelaTarifaria> listar() {

        return repository.findAll();
    }
    
    public TabelaTarifaria buscarPorId(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Tabela tarifária não encontrada"));
    }
    
    public void excluir(Long id) {

        if (!repository.existsById(id)) {

            throw new ResourceNotFoundException(
                    "Tabela tarifária não encontrada");
        }

        repository.deleteById(id);
    }
    
}
