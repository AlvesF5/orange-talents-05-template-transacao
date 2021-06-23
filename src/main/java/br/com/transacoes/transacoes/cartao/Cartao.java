package br.com.transacoes.transacoes.cartao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cartao {
	
	@Id
	private String id;
	private String email;
	
	
	@Deprecated
	public Cartao() {
	}


	public Cartao(String id, String email) {
		this.id = id;
		this.email = email;
	}
	
	
	

}
