package br.com.transacoes.transacoes.controller;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.transacoes.transacoes.cartao.Cartao;
import br.com.transacoes.transacoes.cartao.repository.CartaoRepository;
import br.com.transacoes.transacoes.domain.Transacao;
import br.com.transacoes.transacoes.domain.TransacaoResponse;
import br.com.transacoes.transacoes.repository.TransacaoRepository;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {
	
	@Autowired
	private TransacaoRepository transacaoRepository;
	
	@Autowired
	private CartaoRepository cartaoRepository;
	
	@GetMapping("/{idCartao}")
	public ResponseEntity<Page<TransacaoResponse>>  transacoes(@PathVariable("idCartao") String idCartao, 
			@PageableDefault(sort =  "efetivadaEm", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao){
		
		
		Optional<Cartao> possivelCartao = cartaoRepository.findById(idCartao);
		
		if(possivelCartao.isPresent()) {
			Page<Transacao> transacoes =  transacaoRepository.findByCartaoId(idCartao,paginacao);
			
			return ResponseEntity.ok().body(TransacaoResponse.transformarParaTransacao(transacoes));
		}
		
		return ResponseEntity.notFound().build();
		
		
	}

}
