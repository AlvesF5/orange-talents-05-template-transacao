package br.com.transacoes.transacoes;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

import br.com.transacoes.transacoes.domain.Transacao;
import br.com.transacoes.transacoes.repository.TransacaoRepository;

@Component
public class TransacoesConsumer {
	
	@Autowired
	private TransacaoRepository transacaoRepository;
	
	
	@Bean
	public NewTopic topic() {
		return TopicBuilder.name("transacoes").partitions(1).replicas(1).build();
	}



	@KafkaListener(id = "transacoes", topics = "transacoes")
	void transacoes(Transacao transacao) {

		transacaoRepository.save(transacao);
		System.out.println("Transação = " + transacao);
	}
	
}
