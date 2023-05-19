package com.contasPagarService.repository;

import com.contasPagarService.entity.ContaPagar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaPagarRepository extends JpaRepository<ContaPagar, Long> {

    ContaPagar findByNumeroReferencia(String numeroReferencia);
}
