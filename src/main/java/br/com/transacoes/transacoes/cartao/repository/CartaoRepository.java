package br.com.transacoes.transacoes.cartao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.transacoes.transacoes.cartao.Cartao;

public interface CartaoRepository extends JpaRepository<Cartao, String> {
	
	Optional<Cartao> findById(Long idCartao);

}
