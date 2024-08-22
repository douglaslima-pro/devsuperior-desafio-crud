package edu.douglaslima.desafiocrud.dto;

import java.time.LocalDate;

import edu.douglaslima.desafiocrud.entity.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public record ClientDTO(
		Long id,
		@NotNull(message = "Campo obrigatório")
		@NotBlank(message = "Nome não pode ser vazio!")
		String name,
		String cpf,
		Double income,
		@PastOrPresent(message = "Data de nascimento não pode ser data futura!")
		LocalDate birthDate,
		Integer children
		) {
	
	public ClientDTO(Client client) {
		this(client.getId(), client.getName(), client.getCpf(), client.getIncome(), client.getBirthDate(), client.getChildren());
	}
	
	public Client toEntity() {
		Client client = new Client();
		client.setId(id);
		client.setName(name);
		client.setCpf(cpf);
		client.setIncome(income);
		client.setBirthDate(birthDate);
		client.setChildren(children);
		return client;
	}
	
	public void updateEntity(Client client) {
		client.setName(name);
		client.setCpf(cpf);
		client.setIncome(income);
		client.setBirthDate(birthDate);
		client.setChildren(children);
	}

}
