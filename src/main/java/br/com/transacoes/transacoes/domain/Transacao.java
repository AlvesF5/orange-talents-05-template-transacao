package br.com.transacoes.transacoes.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import br.com.transacoes.transacoes.cartao.Cartao;
import br.com.transacoes.transacoes.estabelecimento.Estabelecimento;

@Entity
public class Transacao {
	
	@Id
	private String id;
	
	private BigDecimal valor;
	
	@ManyToOne
	private Estabelecimento estabelecimento;
	
	@ManyToOne
	private Cartao cartao;
	
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime efetivadaEm;
	
	
	
	@Deprecated
	public Transacao() {

	}
	


	public Transacao(String id, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao,
			LocalDateTime efetivadaEm) {
		this.id = id;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
		this.efetivadaEm = efetivadaEm;
	}
	
	
	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}

	@Override
	public String toString() {
		return "Transacao [id=" + id + ", valor=" + valor + ", estabelecimento=" + estabelecimento + ", cartao="
				+ cartao + ", efetivadaEm=" + efetivadaEm + "]";
	}
	
		
	

}
