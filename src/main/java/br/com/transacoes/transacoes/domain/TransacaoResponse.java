package br.com.transacoes.transacoes.domain;

import java.math.BigDecimal;
import org.springframework.data.domain.Page;

public class TransacaoResponse {
	
	private BigDecimal valor;
	

	private String nomeEstabelecimento;
	
	private String cidadeEstabelecimento;
	
	private String enderecoEstabelecimento;
	
	
	private String numeroCartao;
	

	private String dataTransacao;
	
	
	public TransacaoResponse(Transacao transacao) {
		this.valor=transacao.getValor();
		this.nomeEstabelecimento=transacao.getEstabelecimento().getNome();
		this.cidadeEstabelecimento=transacao.getEstabelecimento().getCidade();
		this.enderecoEstabelecimento=transacao.getEstabelecimento().getCidade();
		this.numeroCartao=transacao.getCartao().getId();
		this.dataTransacao=transacao.getEfetivadaEm().toString();
	}
	
	
	public static Page<TransacaoResponse> transformarParaTransacao(Page<Transacao> transacoes){
		return transacoes.map(TransacaoResponse::new);
	}


	public BigDecimal getValor() {
		return valor;
	}


	public String getNomeEstabelecimento() {
		return nomeEstabelecimento;
	}


	public String getCidadeEstabelecimento() {
		return cidadeEstabelecimento;
	}


	public String getEnderecoEstabelecimento() {
		return enderecoEstabelecimento;
	}


	public String getNumeroCartao() {
		return numeroCartao;
	}


	public String getDataTransacao() {
		return dataTransacao;
	}
	
	

}
