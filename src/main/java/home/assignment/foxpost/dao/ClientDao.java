package home.assignment.foxpost.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import home.assignment.foxpost.exception.RecordNotFoundException;
import home.assignment.foxpost.mapper.ClientMapper;
import home.assignment.foxpost.model.Client;

public class ClientDao {

	private static final String MESSAGE = " not present in DB";
	@Autowired
	private ClientMapper clientMapper;

	public List<Client> getAll() {
		return clientMapper.getAll();
	}

	public Client getClientByEmail(String email) throws RecordNotFoundException {
		Client clientByEmail = clientMapper.getClientByEmail(email);
		if (clientByEmail == null) {
			throw new RecordNotFoundException(email + MESSAGE);
		}

		return clientByEmail;
	}

	public Client getClientById(int id) throws RecordNotFoundException {
		Client clientById = clientMapper.getClientById(id);
		if (clientById == null) {
			throw new RecordNotFoundException(id + MESSAGE);
		}
		return clientById;

	}

}
