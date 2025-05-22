package org.serratec.trabalhoIndividual.models;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Embeddable
public class Endereco {
	
	@NotBlank(message = "A rua não pode estar vazio ou nulo!")
	private String rua;
	
	@NotBlank(message = "A rua não pode estar vazio ou nulo!")
	private String cidade;
	
	@NotBlank(message = "O estado não pode estar vazio ou nulo!")
	@Size(min = 2, max = 2, message = "A sigla do estado deve conter somente 2 letras!")
	private String estado;
	
	@NotBlank(message = "O CEP não pode estar vazio ou nulo!")
	@Size(min = 9, max = 9, message = "CEP deve ter 9 caracteres, contendo (-)!")
	private String cep;
	
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
}

