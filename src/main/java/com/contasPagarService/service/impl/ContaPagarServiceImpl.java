package com.contasPagarService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.contasPagarService.entity.ContaPagar;
import com.contasPagarService.payload.ContaPagarDto;
import com.contasPagarService.repository.ContaPagarRepository;
import com.contasPagarService.service.ContaPagarService;

import jakarta.persistence.EntityNotFoundException;

public class ContaPagarServiceImpl implements ContaPagarService {

    @Autowired
    private ContaPagarRepository contaPagarRepository;

    @Override
    public ContaPagarDto createContaPagar(ContaPagarDto contaPagarDto) {

        ContaPagar notaExists = contaPagarRepository.findByNumeroReferencia(contaPagarDto.getNumeroReferencia());

        if(notaExists != null){
            throw new EntityNotFoundException("Nota fiscal não encontrada");
        }

        ContaPagar contaPagar = mapToEntity(contaPagarDto);

        ContaPagar newContaPagar = contaPagarRepository.save(contaPagar);

        return mapToDto(newContaPagar);
    }

    ContaPagar mapToEntity(ContaPagarDto contaPagarDto){

        ContaPagar contaPagar = new ContaPagar();

        contaPagar.setFornecedor(contaPagarDto.getFornecedor());
        contaPagar.setDataEmissao(contaPagarDto.getDataEmissao());
        contaPagar.setDataVencimento(contaPagarDto.getDataVencimento());
        contaPagar.setDescricao(contaPagarDto.getDescricao());
        contaPagar.setValorOriginal(contaPagarDto.getValorOriginal());
        contaPagar.setValorPago(contaPagarDto.getValorPago());
        contaPagar.setValorEmAberto(contaPagarDto.getValorEmAberto());
        contaPagar.setStatusPagamento(contaPagarDto.getStatusPagamento());
        contaPagar.setMetodoPagamento(contaPagarDto.getMetodoPagamento());
        contaPagar.setNumeroReferencia(contaPagarDto.getNumeroReferencia());
        contaPagar.setNotas(contaPagarDto.getNotas());
        contaPagar.setPrioridade(contaPagarDto.getPrioridade());
        contaPagar.setDepartamento(contaPagarDto.getDepartamento());
        contaPagar.setResponsavel(contaPagarDto.getResponsavel());
        contaPagar.setDataPagamento(contaPagarDto.getDataPagamento());

        return contaPagar;
    }

    ContaPagarDto mapToDto(ContaPagar contaPagar){

        ContaPagarDto contaPagarDto = new ContaPagarDto();

        contaPagarDto.setId(contaPagar.getId());
        contaPagarDto.setFornecedor(contaPagar.getFornecedor());
        contaPagarDto.setDataEmissao(contaPagar.getDataEmissao());
        contaPagarDto.setDataVencimento(contaPagar.getDataVencimento());
        contaPagarDto.setDescricao(contaPagar.getDescricao());
        contaPagarDto.setValorOriginal(contaPagar.getValorOriginal());
        contaPagarDto.setValorPago(contaPagar.getValorPago());
        contaPagarDto.setValorEmAberto(contaPagar.getValorEmAberto());
        contaPagarDto.setStatusPagamento(contaPagar.getStatusPagamento());
        contaPagarDto.setMetodoPagamento(contaPagar.getMetodoPagamento());
        contaPagarDto.setNumeroReferencia(contaPagar.getNumeroReferencia());
        contaPagarDto.setNotas(contaPagar.getNotas());
        contaPagarDto.setPrioridade(contaPagar.getPrioridade());
        contaPagarDto.setDepartamento(contaPagar.getDepartamento());
        contaPagarDto.setResponsavel(contaPagar.getResponsavel());
        contaPagarDto.setDataPagamento(contaPagar.getDataPagamento());

        return contaPagarDto;
    }
}
