package edu.douglaslima.desafiocrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.douglaslima.desafiocrud.dto.ClientDTO;
import edu.douglaslima.desafiocrud.entity.Client;
import edu.douglaslima.desafiocrud.exception.DatabaseException;
import edu.douglaslima.desafiocrud.exception.ResourceNotFoundException;
import edu.douglaslima.desafiocrud.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService implements EntityService<ClientDTO, Long> {
	
	@Autowired
	private ClientRepository clientRepository;

	@Transactional
	@Override
	public ClientDTO insert(ClientDTO clientDTO) {
		Client client = clientDTO.toEntity();
		clientRepository.save(client);
		return new ClientDTO(client);
	}

	@Transactional(readOnly = true)
	@Override
	public ClientDTO findById(Long id) {
		Client client = clientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhum cliente foi encontrado com o ID %d", id));
		return new ClientDTO(client);
	}

	@Transactional(readOnly = true)
	@Override
	public Page<ClientDTO> findAll(Pageable pageable) {
		Page<Client> result = clientRepository.findAll(pageable);
		return result.map(client -> new ClientDTO(client));
	}

	@Transactional
	@Override
	public ClientDTO update(Long id, ClientDTO clientDTO) {
		try {
			Client client = clientRepository.getReferenceById(id);
			clientDTO.updateEntity(client);
			clientRepository.save(client);
			return new ClientDTO(client);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Nenhum cliente foi encontrado com o ID %d", id);
		}
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public void delete(Long id) {
		if (!clientRepository.existsById(id)) {
			throw new ResourceNotFoundException("Nenhum cliente foi encontrado com o ID %d", id);
		}
		try {
			clientRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Erro de integridade referencial");
		}
	}

}
