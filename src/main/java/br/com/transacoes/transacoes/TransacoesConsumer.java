package br.com.transacoes.transacoes;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.annotation.KafkaListener;

import org.springframework.stereotype.Component;

import br.com.transacoes.transacoes.domain.Transacao;
import br.com.transacoes.transacoes.repository.TransacaoRepository;

@Component
public class TransacoesConsumer {
	
	@Autowired
	private TransacaoRepository transacaoRepository;


	@KafkaListener(id = "transacoes", topics = "transacoes")
	void transacoes(Transacao transacao) {

		transacaoRepository.save(transacao);
		System.out.println("Transação = " + transacao);
	}
	
}
