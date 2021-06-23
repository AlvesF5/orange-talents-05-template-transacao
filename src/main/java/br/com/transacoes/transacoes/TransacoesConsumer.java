package br.com.transacoes.transacoes;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.stereotype.Component;

import br.com.transacoes.transacoes.domain.Transacao;

@Component
public class TransacoesConsumer {
	
	public static void main(String[] args) {
		SpringApplication.run(TransacoesConsumer.class, args);
	}
	
	@Bean
	public NewTopic topic() {
		return TopicBuilder.name("transacoes").partitions(1).replicas(1).build();
	}

	@Bean
	JsonMessageConverter jsonMessageConverter() {
		return new JsonMessageConverter();
	}

	@KafkaListener(id = "transacoes", topics = "transacoes")
	void transacoes(Transacao transacao) {
		System.out.println("Transação = " + transacao);
	}
	
}
