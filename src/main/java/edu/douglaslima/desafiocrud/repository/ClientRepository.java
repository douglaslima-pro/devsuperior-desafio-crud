package edu.douglaslima.desafiocrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.douglaslima.desafiocrud.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
