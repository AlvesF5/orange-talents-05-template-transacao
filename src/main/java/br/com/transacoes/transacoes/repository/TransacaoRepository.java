package br.com.transacoes.transacoes.repository;




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.transacoes.transacoes.domain.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao,Long> {
	
	Page<Transacao> findByCartaoId(String idCartao, Pageable paginacao);

}
